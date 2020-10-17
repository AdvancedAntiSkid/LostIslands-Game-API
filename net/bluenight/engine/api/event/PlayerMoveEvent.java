package net.bluenight.engine.api.event;

import net.bluenight.engine.api.util.Position;
import net.bluenight.engine.api.entity.Player;

/**
 * @author AdvancedAntiSkid
 */
public class PlayerMoveEvent implements Event
{
    private Player player;
    private Position form, to;

    public PlayerMoveEvent(Player player, Position from,Position to)
    {
        this.player = player;
        this.form = from;
        this.to = to;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Position getForm()
    {
        return form;
    }

    public void setForm(Position form)
    {
        this.form = form;
    }

    public Position getTo()
    {
        return to;
    }

    /**
     * Use Player#teleport for event resynchronizing
     */
    public void setTo(Position to)
    {
        this.to = to;
    }
}
