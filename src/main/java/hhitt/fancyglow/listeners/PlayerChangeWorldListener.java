package hhitt.fancyglow.listeners;

import hhitt.fancyglow.FancyGlow;
import hhitt.fancyglow.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import java.util.List;

public class PlayerChangeWorldListener implements Listener {

    // Listener to player world change to manage disabled-worlds
    private FancyGlow plugin;

    public PlayerChangeWorldListener(FancyGlow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerWorldChange(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        String actualWorld = player.getWorld().getName();
        List<String> noAllowedWorlds = this.plugin.getConfig().getStringList("Disabled_Worlds");
        if (noAllowedWorlds.contains(actualWorld)) {
            player.setGlowing(false);
            MessageUtils.miniMessageSender(player, this.plugin.getMainConfigManager().getDisabledWorldMessage());
        }
    }
}
