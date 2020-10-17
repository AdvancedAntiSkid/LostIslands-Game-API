package net.bluenight.engine.api.plugin;

import net.bluenight.engine.api.plugin.exception.InvalidPluginException;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AdvancedAntiSkid
 */
public class PluginManager
{
    private ServiceProvider serviceProvider;
    private List<JavaPlugin> plugins = new ArrayList<>();

    public PluginManager()
    {
        this.serviceProvider = new ServiceProvider(this);
    }

    public JavaPlugin loadPlugin(File file) throws Exception
    {
        try
        {
            PluginInfo info = PluginInfo.load(file);

            for (JavaPlugin plugin : plugins)
            {
                if (info.name.equals(plugin.info.name))
                    throw new InvalidPluginException("Name is already registered");
                if (info.main.equals(plugin.info.main))
                    throw new InvalidPluginException("Main class is already registered");
            }

            URLClassLoader classLoader = new URLClassLoader(new URL[] { file.toURI().toURL() }, this.getClass().getClassLoader());
            Class<?> clazz = Class.forName(info.main, true, classLoader);
            Plugin main = ((Plugin) clazz.newInstance());
            Thread context = new Thread(main::onEnabled);
            JavaPlugin plugin = new JavaPlugin(classLoader, context, main, info);

            plugins.add(plugin);
            return plugin;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void unloadPlugin(JavaPlugin plugin)
    {
        if (!plugins.contains(plugin))
            throw new IllegalArgumentException("Plugin isn't loaded");
        plugins.remove(plugin);
        try
        {
            plugin.classLoader.close();
            System.gc();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void unloadPlugin(String name)
    {
        unloadPlugin(getPlugin(name));
    }

    public void enablePlugin(JavaPlugin plugin)
    {
        plugin.setEnabled(true);
    }

    public void enablePlugin(String name)
    {
        enablePlugin(getPlugin(name));
    }

    public void disablePlugin(JavaPlugin plugin)
    {
        plugin.setEnabled(false);
    }

    public void disablePlugin(String name)
    {
        disablePlugin(getPlugin(name));
    }

    public JavaPlugin getPlugin(String name)
    {
        return plugins.stream().filter(p -> name.equals(p.info.name)).findFirst().orElse(null);
    }

    public JavaPlugin getPlugin(Thread context)
    {
        return plugins.stream().filter(p -> p.context == context).findFirst().orElse(null);
    }

    public JavaPlugin getCurrentPlugin()
    {
        return getPlugin(Thread.currentThread());
    }

    public void validatePluginError()
    {
        JavaPlugin plugin = getCurrentPlugin();
        if(plugin != null && !getCurrentPlugin().isEnabled())
            throw new SecurityException("Can not invoke method because plugin isn't enabled");
    }

    public boolean validatePlugin()
    {
        JavaPlugin plugin = getCurrentPlugin();
        return plugin != null && plugin.isEnabled();
    }

    public boolean isPluginEnabled(JavaPlugin plugin)
    {
        return plugin.isEnabled();
    }

    public boolean isPluginEnabled(String name)
    {
        return isPluginEnabled(getPlugin(name));
    }

    public ServiceProvider getServiceProvider()
    {
        return serviceProvider;
    }
}
