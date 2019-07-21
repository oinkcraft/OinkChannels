package zaphx.oinkchannels.Objects;

import org.junit.Assert;
import org.junit.Test;

import static org.bukkit.ChatColor.*;
import static org.junit.Assert.*;

public class ChannelTypeTest {

    @Test
    public void test_getChannelFormat() {
        ChannelType type = ChannelType.STAFF_CHAT;

        String expectedFormat = GOLD + "[" + RED + "Staff Chat" + GOLD + "] " + DARK_RED + "{name} " + GOLD + ">> " + RED + "{message}";

        Assert.assertEquals(expectedFormat, type.getChannelFormat());
    }

    @Test
    public void test_getPermission() {
        ChannelType type = ChannelType.STAFF_CHAT;

        String expectedPermission = "oinkchannels.channel.sc";

        Assert.assertEquals(expectedPermission, type.getPermission());
    }
}