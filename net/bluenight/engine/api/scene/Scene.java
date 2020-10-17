package net.bluenight.engine.api.scene;

import net.bluenight.engine.apiold.Entity;
import net.bluenight.engine.apiold.GameObject;
import net.bluenight.engine.apiold.Player;

import java.util.List;

/**
 * @author AdvancedAntiSkid
 * TODO pff pls dont use this
 */
public interface Scene
{
    String getName();

    Player getPlayer();
    void setPlayer(Player player);

    List<Entity> getEntities();
    void loadEntity(Entity entity);
    void unloadEntity(Entity entity);

    List<GameObject> getGameObjects();
    void loadGameObject(GameObject gameObject);
    void unloadGameObject(GameObject gameObject);
}
