package me.vzhelev.ares;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    Ares m = Ares.instance;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ares")) {
            if (!sender.hasPermission("ares.use")) {
                sender.sendMessage(m.color("&f&l{&4&lAres&f&l} &cНямате право да използвате тази команда!"));
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(m.color("&7&l&m------&f&l{&4&lAres&f&l}&7&l&m------"));
                sender.sendMessage(m.color("&7&l➥ &a/ares reload &7&l➤ &fРестарт на приставката!"));
                sender.sendMessage(m.color("&7&l➥ &aAuthor &7&l➤ &fgalactic22"));
                sender.sendMessage(m.color("&7&l&m------&f&l{&4&lAres&f&l}&7&l&m------"));
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                m.config.reload();
                sender.sendMessage(m.color("&f&l{&4&lAres&f&l} &fПриставката е рестартирана!"));
                Bukkit.getPluginManager().disablePlugin(m);
                Bukkit.getPluginManager().enablePlugin(m);
                return true;
            }
        }
        return true;
    }

}
