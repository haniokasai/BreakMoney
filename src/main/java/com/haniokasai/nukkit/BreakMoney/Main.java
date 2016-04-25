package com.haniokasai.nukkit.BreakMoney;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import me.onebone.economyapi.EconomyAPI;



public class Main extends PluginBase implements Listener{


		public void onEnable() {
			 this.getServer().getPluginManager().registerEvents(this, this);
				getDataFolder().mkdir();

				Config config = new Config(
		                new File(this.getDataFolder(), "config.yml"),Config.YAML,
		                new LinkedHashMap<String, Object>() {
		                    {
		                    	put("//id", "//momey");
		                    	put("17", "5");
		                    	put("15", "10");
		                    	put("14", "15");
		                    	put("1", "1");
		                    	put("16", "3");
		                    	put("56", "30");
		                    	put("73", "10");
		                    	put("74", "10");
		                    }
		                });
		        config.save();
		}


		@EventHandler
		public void onBlockBreak(BlockBreakEvent event){
			Config config = new Config(new File(this.getDataFolder(), "config.yml"));
			Player player = event.getPlayer();
			Block block = event.getBlock();
			if(config.get(Integer.toString(block.getId())) != null){
				String moneya = config.get(Integer.toString(block.getId())).toString();
				int money = new Integer(moneya);
					if(money  > 0){
						EconomyAPI.getInstance().addMoney(player, money);

				}
			}
		}

	}