package net.bluenight.engine.api.plugin.exception;

/**
 * @author AdvancedAntiSkid
 */
public class PluginEventException extends RuntimeException
{
    public PluginEventException(String cause)
    {
        super(cause);
    }

    public PluginEventException(Throwable cause)
    {
        super(cause);
    }

    public PluginEventException()
    {
        super();
    }
}
