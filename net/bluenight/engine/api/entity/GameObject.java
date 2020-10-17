package net.bluenight.engine.api.entity;

import net.bluenight.engine.api.util.Position;

/**
 * @author AdvancedAntiSkid
 */
public interface GameObject
{
    int getId();
    Position getPosition();
    void setPosition(Position position);
    int getTexture();
}
