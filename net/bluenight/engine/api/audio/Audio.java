package net.bluenight.engine.api.audio;

import net.bluenight.engine.api.util.Position;
import net.bluenight.engine.api.util.Vector;

/**
 * @author AdvancedAntiSkid
 */
public interface Audio
{
    String getName();
    int getId();
    int getBuffer();

    void play();
    void pause();
    void resume();
    void stop();
    void destroy();

    boolean isPlaying();
    boolean isPaused();
    boolean isStopped();

    Vector getVelocity();
    void setVelocity(Vector velocity);

    void setLooping(boolean looping);

    float getVolume();
    void setVolume(float volume);

    float getPitch();
    void setPitch(float pitch);

    Position getPosition();
    void setPosition(Position position);
}
