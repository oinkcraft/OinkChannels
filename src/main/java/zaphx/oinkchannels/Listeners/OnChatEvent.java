package zaphx.oinkchannels.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import zaphx.oinkchannels.Managers.ChatManager;
import zaphx.oinkchannels.Objects.ChannelType;
import zaphx.oinkchannels.OinkChannels;

public class OnChatEvent implements Listener {

    ChatManager chatManager = ChatManager.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void chatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (chatManager.isToggled(player)) {
            event.setCancelled(true);
            ChannelType channelType = chatManager.getChannelType(player);
            for (Player user: OinkChannels.getInstance().getServer().getOnlinePlayers()) {
                if (user.hasPermission(channelType.getPermission()))
                    user.sendMessage(chatManager.formatMessageForChannel(channelType, player, event.getMessage()));
            }
        }

    }
}
