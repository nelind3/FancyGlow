package hhitt.fancyglow.utils;

import org.bukkit.ChatColor;

public class MessageUtils {

    // Just to translate color codes in all messages

    public static String getColoredMessages(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}