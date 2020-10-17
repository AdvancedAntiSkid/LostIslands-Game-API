package net.bluenight.engine.api.plugin.exception;

/**
 * @author AdvancedAntiSkid
 */
public class InvalidPluginException extends RuntimeException
{
    public InvalidPluginException(String cause)
    {
        super(cause);
    }

    public InvalidPluginException(Throwable cause)
    {
        super(cause);
    }

    public InvalidPluginException()
    {
        super();
    }
}
