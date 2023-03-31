package dev.efnilite.ip.api;

import dev.efnilite.ip.IP;
import dev.efnilite.ip.gamemode.DefaultMode;
import dev.efnilite.ip.gamemode.SpectatorMode;

public class Modes {

    public static DefaultMode DEFAULT;
    public static SpectatorMode SPECTATOR;

    public static void init() {
        DEFAULT = (DefaultMode) IP.getRegistry().getMode("default");
        SPECTATOR = (SpectatorMode) IP.getRegistry().getMode("spectator");
    }
}