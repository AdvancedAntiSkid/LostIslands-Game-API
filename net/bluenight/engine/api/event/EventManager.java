package net.bluenight.engine.api.event;

import java.lang.reflect.Method;
import java.util.*;

public class EventManager
{
    private Map<Class<? extends Event>, List<EventData>> REGISTRY_MAP = new HashMap<>();

    private void sortListValue(Class<? extends Event> clazz)
    {
        List<EventData> flexableArray = new ArrayList<>();

        for(byte b : EventPriority.VALUES)
        {
            for(EventData methodData : REGISTRY_MAP.get(clazz))
            {
                if(methodData.priority.code == b)
                {
                    flexableArray.add(methodData);
                }
            }
        }
        REGISTRY_MAP.put(clazz, flexableArray);
    }

    private boolean isMethodBad(Method method)
    {
        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventTarget.class);
    }

    private boolean isMethodBad(Method method, final Class<? extends Event> clazz)
    {
        return isMethodBad(method) || method.getParameterTypes()[0].equals(clazz);
    }

    public List<EventData> get(Class<? extends Event> clazz)
    {
        return REGISTRY_MAP.get(clazz);
    }

    public void cleanMap(boolean removeOnlyEmptyValues)
    {
        Iterator<Map.Entry<Class<? extends Event>, List<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();
        while(iterator.hasNext())
        {
            if(!removeOnlyEmptyValues || iterator.next().getValue().isEmpty())
            {
                iterator.remove();
            }
        }
    }

    public void unregister(Object o, final Class<? extends Event> clazz)
    {
        if(REGISTRY_MAP.containsKey(clazz))
        {
            REGISTRY_MAP.get(clazz).removeIf(methodData -> methodData.source.equals(o));
        }
        cleanMap(true);
    }

    public void unregister(final Object o)
    {
        for(List<EventData> flexableArray : REGISTRY_MAP.values())
        {
            for(int i = flexableArray.size() - 1; i >= 0; i--)
            {
                if(flexableArray.get(i).source.equals(o))
                {
                    flexableArray.remove(i);
                }
            }
        }
        cleanMap(true);
    }

    public void register(Method method, Object o)
    {
        Class<?> clazz = method.getParameterTypes()[0];
        EventData methodData = new EventData(o, method, method.getAnnotation(EventTarget.class).priority());
        methodData.target.setAccessible(true);
        if(REGISTRY_MAP.containsKey(clazz))
        {
            if(!REGISTRY_MAP.get(clazz).contains(methodData))
            {
                REGISTRY_MAP.get(clazz).add(methodData);
                sortListValue((Class<? extends Event>) clazz);
            }
        }
        else
        {
            REGISTRY_MAP.put((Class<? extends Event>) clazz, new ArrayList<EventData>()
            {
                {
                    this.add(methodData);
                }
            });
        }
    }

    public void register(Object o, Class<? extends Event> clazz)
    {
        for(Method method : o.getClass().getMethods())
        {
            if(!isMethodBad(method, clazz))
            {
                register(method, o);
            }
        }
    }

    public void register(Object o)
    {
        for(Method method : o.getClass().getMethods())
        {
            if(!isMethodBad(method))
            {
                register(method, o);
            }
        }
    }

    public int size()
    {
        return REGISTRY_MAP.size();
    }
}
