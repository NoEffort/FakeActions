package me.noeffort.fakeactions.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.noeffort.fakeactions.Messages;

public class MessageUtil implements Listener {
	
	public static String translate(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static String translate(String string, CommandSender sender) {		
		if(string.contains(Messages.username)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				string = string.replace(Messages.username, player.getName());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.username, sender.getName());
			}
		}
		if(string.contains(Messages.playername)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				string = string.replace(Messages.playername, player.getDisplayName());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.playername, sender.getName());
			}
		}
		if(string.contains(Messages.sender)) {
			if(sender instanceof Player) {
				string = string.replace(Messages.sender, sender.getName());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.sender, sender.getName());
			}
		}
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static String translate(String string, CommandSender sender, String args) {
		if(string.contains(Messages.username)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				string = string.replace(Messages.username, player.getName());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.username, sender.getName());
			}
		}
		if(string.contains(Messages.playername)) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				string = string.replace(Messages.playername, player.getDisplayName());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.playername, sender.getName());
			}
		}
		if(string.contains(Messages.sender)) {
			if(sender instanceof Player) {
				string = string.replace(Messages.sender, sender.getName());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.sender, sender.getName());
			}
		}
		if(string.contains(Messages.message)) {
			if(sender instanceof Player) {
				string = string.replace(Messages.message, args.toString());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.message, args.toString());
			}
		}
		if(string.contains(Messages.string)) {
			if(sender instanceof Player) {
				string = string.replace(Messages.string, args.toString());
			}
			else if(sender instanceof ConsoleCommandSender) {
				string = string.replace(Messages.string, args.toString());
			}
		}
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static String message(String[] args, int num) {
		StringBuilder message = new StringBuilder();
		for(int i = num; i < args.length; i++) {
			message.append(args[i]).append(" ");
		}
		return message.toString().trim();
	}
	
}
