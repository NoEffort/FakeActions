package me.noeffort.fakeactions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.noeffort.fakeactions.command.FakeJoin;
import me.noeffort.fakeactions.command.FakeKick;
import me.noeffort.fakeactions.command.FakeLeave;
import me.noeffort.fakeactions.util.MessageUtil;

public class Main extends JavaPlugin {
	
	private static Main instance;
	public static HashMap<String, String> messageData = new HashMap<String, String>();
	
	@Override
	public void onEnable() {
		getLogger().info("Plugin Enabled! " + getVersion());
		registerCommands();
		
		File file = new File(getDataFolder() + File.separator + "messages.yml");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		registerMessages();
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		for(String message : config.getConfigurationSection("").getKeys(false)) {
			messageData.put(message, config.getString(message));
		}
	}
	
	public void registerMessages() {
		setMessage("fakeJoin", "&e{STRING} has joined the game.");
		setMessage("fakeLeave", "&e{STRING} has left the game.");
		setMessage("fakeKick", "&6Player &c{SENDER} &6kicked {USERNAME} for {MESSAGE}.");
		setMessage("fakeBan", "&6Player &c{SENDER} &bbanned &c{USERNAME} &6for: &c{MESSAGE}&6.");
		setMessage("fakeOP", "&7&o[{SENDER}: Opped {USERNAME}]");
		setMessage("fakeDeOP", "&7&o[{SENDER}: De-opped {USERNAME}]");
	}
	
	public void registerCommands() {
		this.getCommand("fakejoin").setExecutor(new FakeJoin(this));
		this.getCommand("fakeleave").setExecutor(new FakeLeave(this));
		this.getCommand("fakekick").setExecutor(new FakeKick(this));
	}
	
	public String getVersion() {
		PluginDescriptionFile pdf = this.getDescription();
		return pdf.getVersion();
	}
	
	private void setMessage(String name, String message) {
		File file = new File(getDataFolder() + File.separator + "messages.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		if(!config.isSet(name)) {
			config.set(name, message);
			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Main get() {
		return instance;
	}

}
