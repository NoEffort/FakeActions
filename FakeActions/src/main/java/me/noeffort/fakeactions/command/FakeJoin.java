package me.noeffort.fakeactions.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import me.noeffort.fakeactions.Main;
import me.noeffort.fakeactions.Messages;
import me.noeffort.fakeactions.util.MessageUtil;

public class FakeJoin implements CommandExecutor, Listener {
	
	private final Main plugin;
	
	public FakeJoin(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp()) {
			if(args.length < 1) {
				sender.sendMessage(MessageUtil.translate(Messages.toolittleargs));
				return true;
			}
			if(args.length > 1) {
				sender.sendMessage(MessageUtil.translate(Messages.toomanyargs));
				return true;
			} else {
				Bukkit.broadcastMessage(MessageUtil.translate(Main.messageData.get("fakeJoin"), sender, args[0]));
			}
		} else {
			return false;
		}
		return true;
	}
}
