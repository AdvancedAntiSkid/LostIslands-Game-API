package net.bluenight.engine.api.plugin;

import net.bluenight.engine.api.entity.Component;
import net.bluenight.engine.api.entity.Entity;
import net.bluenight.engine.api.event.Event;
import net.bluenight.engine.ui.Listener;

import java.io.File;
import java.util.function.Consumer;

/**
 * @author AdvancedAntiSkid
 * I belive this is the only easy way of overriding methods when initializing a plugin using reflection :S
 */
public class Plugin
{
    private final PluginService pluginService;

    public Plugin(PluginService pluginService)
    {
        this.pluginService = pluginService;
    }

    public Plugin()
    {
        this(null);
    }

    public void onEnabled()
    {
    }

    public void onDisabled()
    {
    }

    public final Entity getEntity(int id)
    {
        return pluginService.getEntity(id);
    }

    public final void addComponent(Entity entity, Class<? extends Component> clazz)
    {
        pluginService.addComponent(entity, clazz);
    }

    public final String getName()
    {
        return pluginService.getName();
    }

    public final void registerEvents(Listener listener)
    {
        pluginService.registerEvents(listener);
    }

    public final <T extends Event> void registerEvent(Class<T> event, Consumer<T> action)
    {
        pluginService.registerEvent(event, action);
    }
    public final File getDataFolder()
    {
        return pluginService.getDataFolder();
    }
}
