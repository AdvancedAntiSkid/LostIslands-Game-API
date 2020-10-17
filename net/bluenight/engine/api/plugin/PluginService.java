package net.bluenight.engine.api.plugin;

import net.bluenight.engine.api.entity.Component;
import net.bluenight.engine.api.entity.Entity;
import net.bluenight.engine.api.event.Event;
import net.bluenight.engine.ui.Listener;

import java.io.File;
import java.util.function.Consumer;

/**
 * @author AdvancedAntiSkid
 * Gets implemented in runtime
 */
public interface PluginService
{
    Entity getEntity(int id);
    void addComponent(Entity entity, Class<? extends Component> clazz);
    String getName();
    void registerEvents(Listener listener);
    <T extends Event> void registerEvent(Class<T> event, Consumer<T> action);
    File getDataFolder();
}
