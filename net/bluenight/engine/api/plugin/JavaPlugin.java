package net.bluenight.engine.api.plugin;

import java.net.URLClassLoader;

/**
 * @author AdvancedAntiSkid
 */
public class JavaPlugin
{
    public final URLClassLoader classLoader;
    public final Thread context;
    public final Plugin main;
    public final PluginInfo info;
    private boolean enabled;

    public JavaPlugin(URLClassLoader classLoader, Thread context, Plugin main, PluginInfo info)
    {
        this.classLoader = classLoader;
        this.context = context;
        this.main = main;
        this.info = info;
        this.enabled = false;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
        if(enabled) context.start();
        else context.stop();
    }
}
