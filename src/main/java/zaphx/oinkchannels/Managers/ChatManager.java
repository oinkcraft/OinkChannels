package zaphx.oinkchannels.Managers;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import zaphx.oinkchannels.Objects.ChannelType;
import zaphx.oinkchannels.OinkChannels;

import java.util.HashMap;

public class ChatManager {

    private static ChatManager instance;
    private HashMap<Player, ChannelType> toggledChannels = new HashMap<>();

    private ChatManager() {
    }

    public static ChatManager getInstance() {
        return instance == null ? instance = new ChatManager() : instance;
    }

    public String formatMessageForChannel(ChannelType type, CommandSender sender, String message) {
        return type.getChannelFormat().replaceAll("\\{name}", sender.getName()).replaceAll("\\{message}", message);
    }

    public void togglePlayerChannel(Player player, ChannelType channelType) {
        if (toggledChannels.containsKey(player)) {
            if (toggledChannels.get(player) == channelType)
                toggledChannels.remove(player);
            else
                toggledChannels.put(player, channelType);
        } else
            toggledChannels.put(player, channelType);
    }

    public boolean isToggled(Player player) {
        return toggledChannels.containsKey(player);
    }

    public ChannelType getChannelType(Player player) {
        return toggledChannels.get(player);
    }

    public boolean senderHasPermissionForChannel(CommandSender sender, ChannelType channelType) {
        return sender.hasPermission(channelType.getPermission());
    }

    public void sendMessages(ChannelType channelType, CommandSender player, String message) {
        for (Player user : OinkChannels.getInstance().getServer().getOnlinePlayers()) {
            if (user.hasPermission(channelType.getPermission())) {
                user.sendMessage(formatMessageForChannel(channelType, player, message));
            }
        }
    }
}
