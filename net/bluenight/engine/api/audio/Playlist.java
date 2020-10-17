package net.bluenight.engine.api.audio;

import net.bluenight.engine.audio.GameAudio;

/**
 * @author AdvancedAntiSkid
 */
public class Playlist
{
    public static GameAudio MAIN_MENU_1;
    public static GameAudio MAIN_MENU_2;

    static
    {
        MAIN_MENU_1 = new GameAudio("Main menu - example1", "mainmenu1.wav");
        MAIN_MENU_2 = new GameAudio("Main menu - example2", "mainmenu2.wav");
    }
}
