package zaphx.oinkchannels.Objects;

import static org.bukkit.ChatColor.*;

public enum ChannelType {
    STAFF_CHAT(GOLD + "[" + RED + "Staff Chat" + GOLD + "] " + DARK_RED + "{name} " + GOLD + ">> " + RED + "{message}", "oinkchannels.channel.sc"),
    TRIAL_CHAT(GRAY + "[" + DARK_AQUA + "Trial Chat" + GRAY + "] " + DARK_AQUA + "{name}" + GRAY + " >> " + AQUA + "{message}","oinkchannels.channel.tc"),
    ROOT_CHAT(GRAY + "{name}@root " + DARK_GRAY + ": " + GRAY + "{message}","oinkchannels.channel.rt");

    private String channelFormat;
    private String permission;
    ChannelType(String channelFormat, String permission) {
        this.channelFormat = channelFormat;
        this.permission = permission;
    }

    public String getChannelFormat() {
        return channelFormat;
    }

    public String getPermission() {
        return permission;
    }
}
