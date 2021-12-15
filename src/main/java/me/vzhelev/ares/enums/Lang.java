package me.vzhelev.ares.enums;

import me.vzhelev.ares.Ares;
import me.vzhelev.ares.utils.ColourUtil;
import org.bukkit.command.CommandSender;

public enum Lang {
    PREFIX("&8[&cBlockedCmds&8] ", false),
    BLOCKED_CMD("&cThis command is currently blocked by staff.", true),
    NO_PERMISSION("&cYou do not have permission to execute this command.", true);

    private String defaultValue;
    private boolean usePrefix;

    private Lang(String defaultValue, boolean usePrefix) {
        this.defaultValue = defaultValue;
        this.usePrefix = usePrefix;
    }

    public String getDefault() {
        return this.defaultValue;
    }

    public String getPath() {
        return this.name();
    }

    public boolean usePrefix() {
        return this.usePrefix;
    }

    public String toString() {
        boolean usePrefix = false;
        String prefix = null;
        if (Ares.getInstance().getSettingsManager().getLang().isSet(PREFIX.getPath()) && !Ares.getInstance().getSettingsManager().getLang().getString(PREFIX.getPath()).equalsIgnoreCase("") && Ares.getInstance().getSettingsManager().getLang().getString(PREFIX.getPath()) != null && this.usePrefix()) {
            usePrefix = true;
            prefix = ColourUtil.replaceString(Ares.getInstance().getSettingsManager().getLang().getString(PREFIX.getPath()));
        }

        if (Ares.getInstance().getSettingsManager().getLang().isSet(this.getPath())) {
            if (!Ares.getInstance().getSettingsManager().getLang().getString(this.getPath()).equalsIgnoreCase("") && Ares.getInstance().getSettingsManager().getLang().getString(this.getPath()) != null) {
                return usePrefix ? prefix + ColourUtil.replaceString(Ares.getInstance().getSettingsManager().getLang().getString(this.getPath())) : ColourUtil.replaceString(Ares.getInstance().getSettingsManager().getLang().getString(this.getPath()));
            } else {
                return "";
            }
        } else {
            return usePrefix ? prefix + ColourUtil.replaceString(this.defaultValue) : ColourUtil.replaceString(this.defaultValue);
        }
    }

    public static void sendMessage(CommandSender sender, String replacedString) {
        if (!replacedString.equalsIgnoreCase("")) {
            String[] message = replacedString.split("\\\\n");
            String[] var6 = message;
            int var5 = message.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                String msg = var6[var4];
                sender.sendMessage(msg.replace("\\n", ""));
            }

        }
    }
}
