package net.bluenight.engine.api.entity;

import net.bluenight.engine.api.util.Region;
import net.bluenight.engine.api.util.Position;

/**
 * @author AdvancedAntiSkid
 */
public class Component
{
    public final GameObject gameObject;

    public Component(GameObject gameObject)
    {
        this.gameObject = gameObject;
    }

    public void update() {}

    public void start() {}
    public void stop() {}

    public void onMotionUpdate(Position from, Position to) {}
    public void onRegionEnter(Region region, Position from, Position to) {}
}
