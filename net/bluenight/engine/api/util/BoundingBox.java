package net.bluenight.engine.api.util;

/**
 * @author AdvancedAntiSkid
 */
public class BoundingBox
{
    private float width;
    private float height;

    public BoundingBox(float width, float height)
    {
        this.width = width;
        this.height = height;
    }

    public boolean isColliding(Vector entity, Vector point)
    {
        return point.getX() >= entity.getX() - width / 2 && point.getX() <= entity.getX() + width / 2
            && point.getY() >= entity.getY() && point.getY() <= entity.getY() + height
            && point.getZ() >= entity.getZ() - width / 2 && point.getZ() <= entity.getZ() + width / 2;
    }
}
