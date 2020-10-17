package net.bluenight.engine.api.util;

/**
 * @author AdvancedAntiSkid
 */
public class Region
{
    private double x, y, z;
    private double expandX1, expandX2;
    private double expandY1, expandY2;
    private double expandZ1, expandZ2;

    public Region(double x, double y, double z, double expandX1, double expandX2, double expandY1, double expandY2, double expandZ1, double expandZ2)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.expandX1 = expandX1;
        this.expandX2 = expandX2;
        this.expandY1 = expandY1;
        this.expandY2 = expandY2;
        this.expandZ1 = expandZ1;
        this.expandZ2 = expandZ2;
    }

    public boolean colliding(Position position)
    {
        double posX = position.getX();
        double posY = position.getY();
        double posZ = position.getRotZ();
        return posX <= posX + expandX2 && posX >= posX - expandX1 && posY <= posY + expandY2 && posY
            >= posY - expandY1 && posZ <= posZ + expandZ2 && posZ >= posZ - expandZ1;
    }

    public void expand(double x1, double x2, double y1, double y2, double z1, double z2)
    {
        this.expandX1 += x1;
        this.expandX2 += x2;
        this.expandY1 += y1;
        this.expandY2 += y2;
        this.expandZ1 += z1;
        this.expandZ2 += z2;
    }

    public void expand(double x, double y, double z)
    {
        expand(x, x, y, y, z, z);
    }

    public void expandX(double x1, double x2)
    {
        expand(x1, x2, 0, 0, 0, 0);
    }

    public void expandY(double y1, double y2)
    {
        expand(0, 0, y1, y2, 0, 0);
    }

    public void expandZ(double z1, double z2)
    {
        expand(0, 0, 0, 0, z1, z2);
    }

    public void expandX(double x)
    {
        expand(x, x, 0, 0, 0, 0);
    }

    public void expandY(double y)
    {
        expand(0, 0, y, y, 0, 0);
    }

    public void expandZ(double z)
    {
        expand(0, 0, 0, 0, z, z);
    }

    public void shorten(double x1, double x2, double y1, double y2, double z1, double z2)
    {
        expandX1 = Math.max(expandX1 - x1, 0);
        expandX2 = Math.max(expandX2 - x2, 0);
        expandY1 = Math.max(expandY1 - y1, 0);
        expandY2 = Math.max(expandY2 - y2, 0);
        expandZ1 = Math.max(expandZ1 - z1, 0);
        expandZ2 = Math.max(expandZ2 - z2, 0);
    }

    public void shorten(double x, double y, double z)
    {
        shorten(x, x, y, y, z, z);
    }

    public void shortenX(double x1, double x2)
    {
        shorten(x1, x2, 0, 0, 0, 0);
    }

    public void shortenY(double y1, double y2)
    {
        shorten(0, 0, y1, y2, 0, 0);
    }

    public void shortenZ(double z1, double z2)
    {
        shorten(0, 0, 0, 0, z1, z2);
    }

    public void shortenX(double x)
    {
        shorten(x, x, 0, 0, 0, 0);
    }

    public void shortenY(double y)
    {
        shorten(0, 0, y, y, 0, 0);
    }

    public void shortenZ(double z)
    {
        shorten(0, 0, 0, 0, z, z);
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public double getExpandX1()
    {
        return expandX1;
    }

    public void setExpandX1(double expandX1)
    {
        this.expandX1 = expandX1;
    }

    public double getExpandX2()
    {
        return expandX2;
    }

    public void setExpandX2(double expandX2)
    {
        this.expandX2 = expandX2;
    }

    public double getExpandY1()
    {
        return expandY1;
    }

    public void setExpandY1(double expandY1)
    {
        this.expandY1 = expandY1;
    }

    public double getExpandY2()
    {
        return expandY2;
    }

    public void setExpandY2(double expandY2)
    {
        this.expandY2 = expandY2;
    }

    public double getExpandZ1()
    {
        return expandZ1;
    }

    public void setExpandZ1(double expandZ1)
    {
        this.expandZ1 = expandZ1;
    }

    public double getExpandZ2()
    {
        return expandZ2;
    }

    public void setExpandZ2(double expandZ2)
    {
        this.expandZ2 = expandZ2;
    }
}
