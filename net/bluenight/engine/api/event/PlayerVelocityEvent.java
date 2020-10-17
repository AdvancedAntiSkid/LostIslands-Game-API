package net.bluenight.engine.api.event;

import net.bluenight.engine.api.util.Vector;

/**
 * @author AdvancedAntiSkid
 */
public class PlayerVelocityEvent implements Event
{
    private Vector velocity;

    public PlayerVelocityEvent(Vector velocity)
    {
        this.velocity = velocity;
    }

    public Vector getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Vector velocity)
    {
        this.velocity = velocity;
    }
}
