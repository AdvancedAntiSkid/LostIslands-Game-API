package net.bluenight.engine.api.event;

/**
 * @author AdvancedAntiSkid
 * @see #state true ? key down : key released
 */
public class KeyUpdateEvent implements Event
{
    private int key;
    private boolean state;

    public KeyUpdateEvent(int key, boolean state)
    {
        this.key = key;
        this.state = state;
    }

    public int getKey()
    {
        return key;
    }

    public boolean getState()
    {
        return state;
    }
}
