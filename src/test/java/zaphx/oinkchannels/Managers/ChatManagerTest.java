package zaphx.oinkchannels.Managers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.bukkit.entity.Player;
import zaphx.oinkchannels.Objects.ChannelType;


import static org.bukkit.ChatColor.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class ChatManagerTest {

    ChatManager chatManager = ChatManager.getInstance();

    @Test
    public void test_formatMessageForChannel() {
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getName()).thenReturn("Zaphoo");
        when(mockPlayer.hasPermission("oinkchannels.channel.sc")).thenReturn(true);
        String message = "Hello world";
        ChannelType type = ChannelType.STAFF_CHAT;

        String expectedResult = GOLD + "[" + RED + "Staff Chat" + GOLD + "] " + DARK_RED + "Zaphoo " + GOLD + ">> " + RED + "Hello world";

        assertEquals(chatManager.formatMessageForChannel(type, mockPlayer, message), expectedResult);

    }

    @Test
    public void test_togglePlayerChannel() {
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getName()).thenReturn("Zaphoo");
        when(mockPlayer.hasPermission("oinkchannels.channel.sc")).thenReturn(true);
        ChannelType type = ChannelType.STAFF_CHAT;

        assert !chatManager.isToggled(mockPlayer);

        chatManager.togglePlayerChannel(mockPlayer, type);

        assertTrue(chatManager.isToggled(mockPlayer));
    }

    @Test
    public void test_isToggled() {
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getName()).thenReturn("Zaphoo");
        when(mockPlayer.hasPermission("oinkchannels.channel.sc")).thenReturn(true);
        ChannelType type = ChannelType.STAFF_CHAT;




        chatManager.togglePlayerChannel(mockPlayer, type);
        assertTrue(chatManager.isToggled(mockPlayer));

    }

    @Test
    public void test_getChannelType() {
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getName()).thenReturn("Zaphoo");
        when(mockPlayer.hasPermission("oinkchannels.channel.sc")).thenReturn(true);
        ChannelType type = ChannelType.STAFF_CHAT;

        ChannelType expectedType = ChannelType.STAFF_CHAT;

        chatManager.togglePlayerChannel(mockPlayer, type);

        assertEquals(expectedType, chatManager.getChannelType(mockPlayer));
    }

    @Test
    public void test_getChannelType_multiToggle() {
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getName()).thenReturn("Zaphoo");
        when(mockPlayer.hasPermission("oinkchannels.channel.sc")).thenReturn(true);
        when(mockPlayer.hasPermission("oinkchannels.channel.tc")).thenReturn(true);
        ChannelType type = ChannelType.STAFF_CHAT;
        ChannelType type2 = ChannelType.TRIAL_CHAT;

        ChannelType expectedType = ChannelType.TRIAL_CHAT;

        chatManager.togglePlayerChannel(mockPlayer, type);
        chatManager.togglePlayerChannel(mockPlayer, type2);

        assertEquals(expectedType, chatManager.getChannelType(mockPlayer));
    }
}