package zaphx.oinkchannels;

import org.bukkit.plugin.java.JavaPlugin;
import zaphx.oinkchannels.Listeners.OnChatEvent;

public final class OinkChannels extends JavaPlugin {

    private static OinkChannels instance;


    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new OnChatEvent(), this);
        getCommand("sc").setExecutor(new ChannelCommand());
        getCommand("sctoggle").setExecutor(new ChannelCommand());
        getCommand("tc").setExecutor(new ChannelCommand());
        getCommand("tctoggle").setExecutor(new ChannelCommand());
        getCommand("rt").setExecutor(new ChannelCommand());
        getCommand("rttoggle").setExecutor(new ChannelCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static OinkChannels getInstance() {
        return instance;
    }
}
