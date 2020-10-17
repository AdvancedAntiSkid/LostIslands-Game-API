package net.bluenight.engine.api.entity;

import java.net.InetAddress;

/**
 * @author AdvancedAntiSkid
 */
public interface Player extends Entity
{
    void sendMessage(String message);
    int getPing();
    InetAddress getAddress();
}
