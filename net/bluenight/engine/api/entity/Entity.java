package net.bluenight.engine.api.entity;

import net.bluenight.engine.api.util.Position;

public interface Entity extends GameObject
{
    int getHealth();
    void setHealth(int health);
    boolean isFlying();
    void setFlying(boolean flying);
    boolean getAllowFlight();
    void setAllowFlight(boolean allowFlight);
    void teleport(Position position);
}
