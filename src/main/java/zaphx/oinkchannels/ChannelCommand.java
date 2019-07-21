package zaphx.oinkchannels;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import zaphx.oinkchannels.Managers.ChatManager;
import zaphx.oinkchannels.Objects.ChannelType;

import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

public class ChannelCommand implements CommandExecutor {

    ChatManager chatManager = ChatManager.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (command.getName()) {
            case "sc":
                if (chatManager.senderHasPermissionForChannel(sender, ChannelType.STAFF_CHAT))
                    chatManager.sendMessages(ChannelType.STAFF_CHAT, sender, joinArgs(args));
                else
                    sender.sendMessage(RED + "You do not have permission to chat in that chat.");
                break;
            case "tc":
                if (chatManager.senderHasPermissionForChannel(sender, ChannelType.TRIAL_CHAT))
                    chatManager.sendMessages(ChannelType.TRIAL_CHAT, sender, joinArgs(args));
                else
                    sender.sendMessage(RED + "You do not have permission to chat in that chat.");
                break;
            case "rt":
                if (chatManager.senderHasPermissionForChannel(sender, ChannelType.ROOT_CHAT))
                    chatManager.sendMessages(ChannelType.ROOT_CHAT, sender, joinArgs(args));
                else
                    sender.sendMessage(RED + "You do not have permission to chat in that chat.");
                break;
            case "sctoggle":
                if (chatManager.senderHasPermissionForChannel(sender, ChannelType.STAFF_CHAT)) {
                    if (sender instanceof Player) {
                        sender.sendMessage(GREEN + "You toggled staff chat.");
                        chatManager.togglePlayerChannel((Player)sender, ChannelType.STAFF_CHAT);
                    } else
                        sender.sendMessage(RED + "You must be a player to do that.");
                } else {
                    sender.sendMessage(RED + "You do not have permission to chat in that chat.");
                }
                break;
            case "tctoggle":
                if (chatManager.senderHasPermissionForChannel(sender, ChannelType.TRIAL_CHAT)) {
                    if (sender instanceof Player) {
                        sender.sendMessage(GREEN + "You toggled trial chat.");
                        chatManager.togglePlayerChannel((Player) sender, ChannelType.TRIAL_CHAT);
                    } else
                        sender.sendMessage(RED + "You must be a player to do that.");
                } else {
                    sender.sendMessage(RED + "You do not have permission to chat in that chat.");
                }
                break;
            case "rttoggle":
                if (chatManager.senderHasPermissionForChannel(sender, ChannelType.ROOT_CHAT)) {
                    if (sender instanceof Player) {
                        sender.sendMessage(GREEN + "You toggled root chat.");
                        chatManager.togglePlayerChannel((Player) sender, ChannelType.ROOT_CHAT);
                    } else
                        sender.sendMessage(RED + "You must be a player to do that.");
                } else {
                    sender.sendMessage(RED + "You do not have permission to chat in that chat.");
                }
                break;
            default:
                break;
        }
        return true;
    }

    public String joinArgs(String[] args) {
        StringBuilder joined = new StringBuilder();
        for (String arg : args) {
            joined.append(arg).append(" ");
        }
        return joined.toString();
    }
}
