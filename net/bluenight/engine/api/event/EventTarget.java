package net.bluenight.engine.api.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author AdvancedAntiSkid
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventTarget
{
    EventPriority priority() default EventPriority.NORMAL;
    boolean ignoreCancelled() default false;
}
