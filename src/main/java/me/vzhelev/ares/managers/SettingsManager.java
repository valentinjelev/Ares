package me.vzhelev.ares.managers;

import me.vzhelev.ares.enums.Lang;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {
    private FileConfiguration lang;
    private File langFile;

    public SettingsManager() {
    }

    public void setup(Plugin p) {
        this.setupLang(p);
        this.setValues();
    }

    private void setupLang(Plugin p) {
        this.langFile = new File(p.getDataFolder(), "lang.yml");
        if (!this.langFile.exists()) {
            try {
                this.langFile.createNewFile();
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

        this.lang = YamlConfiguration.loadConfiguration(this.langFile);
    }

    public FileConfiguration getLang() {
        return this.lang;
    }

    private void saveLang() {
        try {
            this.getLang().save(this.langFile);
        } catch (IOException var2) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not save config to " + this.langFile, var2);
        }

    }

    public void setValues() {
        Lang[] var4;
        int var3 = (var4 = Lang.values()).length;

        for(int var2 = 0; var2 < var3; ++var2) {
            Lang lang = var4[var2];
            if (!this.getLang().isSet(lang.getPath())) {
                this.getLang().set(lang.getPath(), lang.getDefault());
            }
        }

        this.saveLang();
    }
}