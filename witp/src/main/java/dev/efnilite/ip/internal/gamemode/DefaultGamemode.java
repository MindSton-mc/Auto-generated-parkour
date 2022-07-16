package dev.efnilite.ip.internal.gamemode;

import dev.efnilite.ip.api.Gamemode;
import dev.efnilite.ip.generator.DefaultGenerator;
import dev.efnilite.ip.leaderboard.Leaderboard;
import dev.efnilite.ip.player.ParkourPlayer;
import dev.efnilite.ip.player.ParkourUser;
import dev.efnilite.vilib.inventory.item.Item;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * The default parkour gamemode
 */
public class DefaultGamemode implements Gamemode {

    private final Leaderboard leaderboard = new Leaderboard(getName());

    @Override
    public @NotNull String getName() {
        return "default";
    }

    @Override
    public @NotNull Item getItem(String locale) {
        return new Item(Material.BARREL, "<#6693E7><bold>Default")
                .lore("<dark_gray>Standard • 默认 • 默認", "<dark_gray>• Défaut • デフォルト • Standaard");
    }

    @Override
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    @Override
    public void create(Player player) {
        player.closeInventory();

        ParkourPlayer pp = ParkourPlayer.getPlayer(player);
        if (pp != null && pp.getGenerator() instanceof DefaultGenerator) {
            return;
        }

        ParkourUser.joinDefault(player);
    }

    @Override
    public void click(Player player) {
        create(player);
    }

    @Override
    public boolean isVisible() {
        return true;
    }
}
