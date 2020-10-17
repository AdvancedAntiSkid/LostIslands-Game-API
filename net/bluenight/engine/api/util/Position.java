package net.bluenight.engine.api.util;

/**
 * @author AdvancedAntiSkid
 */
public class Position
{
    private double x, y, z;
    private double rotX, rotY, rotZ;

    public Position(double x, double y, double z, double rotX, double rotY, double rotZ)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
    }

    public Position(double posX, double posY, double posZ)
    {
        this(posX, posY, posZ, 0, 0, 0);
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }

    public double getRotX()
    {
        return rotX;
    }

    public void setRotX(double rotX)
    {
        this.rotX = rotX;
    }

    public double getRotY()
    {
        return rotY;
    }

    public void setRotY(double rotY)
    {
        this.rotY = rotY;
    }

    public double getRotZ()
    {
        return rotZ;
    }

    public void setRotZ(double rotZ)
    {
        this.rotZ = rotZ;
    }
}
