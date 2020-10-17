package net.bluenight.engine.api.event;

/**
 * @author AdvancedAntiSkid
 */
public enum EventPriority
{
    LOWEST(0), LOW(1), NORMAL(2), HIGH(3), HIGHEST(4);

    public final int code;

    EventPriority(int code)
    {
        this.code = code;
    }

    public static final byte[] VALUES = {0, 1, 2, 3, 4};
}
