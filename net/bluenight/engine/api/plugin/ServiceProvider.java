package net.bluenight.engine.api.plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AdvancedAntiSkid
 */
public class ServiceProvider
{
    private PluginManager pluginManager;
    private Map<JavaPlugin, Map<String, Service>> services;

    public ServiceProvider(PluginManager pluginManager)
    {
        this.pluginManager = pluginManager;
        this.services = new HashMap<>();
    }

    public void load(JavaPlugin plugin)
    {
        services.put(plugin, new HashMap<>());
    }

    public void unload(JavaPlugin plugin)
    {
        services.remove(plugin);
    }

    public void register(String name, Service service)
    {
        JavaPlugin plugin = pluginManager.getCurrentPlugin();
        if(plugin != null && plugin.isEnabled())
        {
            services.get(plugin).put(name, service);
        }
    }

    public void unregister(String name)
    {
        JavaPlugin plugin = pluginManager.getCurrentPlugin();
        if(plugin != null && plugin.isEnabled())
        {
            services.get(plugin).remove(name);
        }
    }

    public <T extends Service> Service getService(String name)
    {
        JavaPlugin plugin = pluginManager.getCurrentPlugin();
        if(plugin == null || !plugin.isEnabled())
        {
            throw new IllegalStateException("No plugin context in function call");
        }
        return services.get(plugin).get(name);
    }

    public <T extends Service> Service getService(JavaPlugin plugin, String name)
    {
        if(plugin == null || !plugin.isEnabled())
        {
            throw new IllegalStateException("Plugin is not enabled");
        }
        return services.get(plugin).get(name);
    }
}
