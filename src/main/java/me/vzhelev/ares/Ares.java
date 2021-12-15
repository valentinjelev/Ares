package me.vzhelev.ares;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.vzhelev.ares.listeners.PlayerCommandPreprocess;
import me.vzhelev.ares.managers.SettingsManager;
import me.vzhelev.ares.utils.LoggerUtil;
import me.vzhelev.ares.utils.TimeUtil;

public class Ares extends JavaPlugin implements Listener, CommandExecutor {

    private SettingsManager settingsManager;

    public ConfigManager config = new ConfigManager(this, "config.yml", "config.yml");
    public static Ares instance;

    @SuppressWarnings("unused")
    public void onEnable() {
        instance = this;
        long startTime = System.currentTimeMillis();
        this.saveDefaultConfig();
        this.settingsManager = new SettingsManager();
        this.getSettingsManager().setup(this);
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("ares").setExecutor(new Commands());
        this.getServer().getPluginManager().registerEvents(new PlayerCommandPreprocess(), this);
        int scheduleSyncRepeatingTask = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this,
                new Runnable() {
                    @SuppressWarnings("unlikely-arg-type")
                    public void run() {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if ((!config.getStringList("Ops").contains(p.getName()))
                                    && (!config.getStringList("Ops").contains(p.getUniqueId())) && (p.isOp())) {
                                p.setOp(false);
                                getServer().dispatchCommand(getServer().getConsoleSender(),
                                        config.getString("Command").replace("{playername}", p.getName()));
                            }
                        }
                    }
                }, 20L, 20L);
    }

    public SettingsManager getSettingsManager() { return this.settingsManager; }
    public static Ares getInstance() {
        return instance;
    }

    @SuppressWarnings("unlikely-arg-type")
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = (Player) event.getPlayer();
        if ((!config.getStringList("Ops").contains(p.getName()))
                && (!config.getStringList("Ops").contains(p.getUniqueId())) && (p.isOp())) {
            p.setOp(false);
            getServer().dispatchCommand(getServer().getConsoleSender(),
                    config.getString("Command").replace("{playername}", p.getName()));
        }
    }

    public String color(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}