package me.vzhelev.ares.listeners;

import me.vzhelev.ares.Ares;
import me.vzhelev.ares.enums.Lang;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocess implements Listener {
    public PlayerCommandPreprocess() {
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        if (!e.getPlayer().hasPermission("BLOCKEDCOMMANDS.BYPASS") && !e.getPlayer().hasPermission("BLOCKEDCOMMANDS.*") && !e.getPlayer().isOp()) {
            List<String> list = this.getBlockedCmds();
            list.stream().filter((cmd) -> {
                return e.getMessage().toLowerCase().contains(cmd.toLowerCase());
            }).forEach((msg) -> {
                e.setCancelled(true);
                Lang.sendMessage(e.getPlayer(), Lang.BLOCKED_CMD.toString());
            });
        }

    }

    private List<String> getBlockedCmds() {
        return Ares.getInstance().getConfig().getStringList("BLOCKED_COMMANDS");
    }
}