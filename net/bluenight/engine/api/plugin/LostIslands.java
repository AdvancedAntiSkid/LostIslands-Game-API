package net.bluenight.engine.api.plugin;

import net.bluenight.engine.api.event.Event;
import net.bluenight.engine.api.event.EventData;
import net.bluenight.engine.api.event.EventManager;
import net.bluenight.engine.api.event.Listener;
import net.bluenight.engine.api.plugin.exception.PluginEventException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AdvancedAntiSkid
 */
public class LostIslands
{
    private static PluginManager pluginManager = new PluginManager();
    private static Map<String, EventManager> eventRegistry = new HashMap<>();

    public static void register(Plugin plugin, Listener listener)
    {
        JavaPlugin currentPlugin = pluginManager.getCurrentPlugin();
        if(currentPlugin.main == plugin && currentPlugin.isEnabled())
        {
            String name = currentPlugin.info.name;
            if(!eventRegistry.containsKey(name))
                eventRegistry.put(name, new EventManager());
            eventRegistry.get(name).register(listener);
        }
        else
        {
            throw new IllegalStateException("You can only register events inside an enabled plugin");
        }
    }

    public static void unregister(Plugin plugin, Listener listener)
    {
        JavaPlugin currentPlugin = pluginManager.getCurrentPlugin();
        if(currentPlugin.main == plugin && currentPlugin.isEnabled())
        {
            String name = currentPlugin.info.name;
            if(eventRegistry.containsKey(name))
                eventRegistry.get(name).unregister(listener);
            if(eventRegistry.get(name).size() == 0)
                eventRegistry.remove(name);
        }
        else
        {
            throw new IllegalStateException("You can only unregister events inside an enabled plugin");
        }
    }

    public static void fireEvent(Event event)
    {
        for(EventManager eventManager : eventRegistry.values())
        {
            List<EventData> dataList = eventManager.get(event.getClass());
            if(dataList != null)
            {
                for(EventData data : dataList)
                {
                    try
                    {
                        data.target.invoke(data.source, event);
                    }
                    catch (Exception e)
                    {
                        throw new PluginEventException(e);
                    }
                }
            }
        }
    }

    public static PluginManager getPluginManager()
    {
        return pluginManager;
    }
}
