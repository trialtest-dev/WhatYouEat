package net.trialtest.shitmod.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import net.trialtest.shitmod.LastEaten;
import net.trialtest.shitmod.Main;

public class EatingListeners implements Listener {
	
	LastEaten lastEaten = Main.getLastEatenObject();
	
	@EventHandler
	public void onEatingFood (PlayerItemConsumeEvent e) {
		ItemStack food = e.getItem();
		
		if(!food.getType().equals(Material.POTION) || !food.getType().equals(Material.MILK_BUCKET)) {
			lastEaten.setMaterialInMap(e.getPlayer().getUniqueId(), food.getType());
			System.out.println(lastEaten.getMaterialInMap(e.getPlayer().getUniqueId()));
		}
	}
	
	@EventHandler
	public void onEatingTools (PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Action action = e.getAction();
		
		if((action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) && player.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD)) {
			player.getInventory().setItemInMainHand(null);
			player.setFoodLevel(player.getFoodLevel() + 2);
			player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);
			lastEaten.setMaterialInMap(player.getUniqueId(), Material.IRON_SWORD);
		}
	}
}
