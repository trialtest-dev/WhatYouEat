package net.trialtest.shitmod.listeners;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import net.trialtest.shitmod.AmountShifted;
import net.trialtest.shitmod.LastEaten;
import net.trialtest.shitmod.LastTouched;
import net.trialtest.shitmod.Main;

public class ShittingListeners implements Listener {
	
	LastEaten lastEaten = Main.getLastEatenObject();
	AmountShifted amountShifted = Main.getAmountShiftedObject();
	LastTouched lastTouched = Main.getLastTouchedObject();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent e) {
		lastEaten.setPlayerInMap(e.getPlayer().getUniqueId());
		amountShifted.addPlayer(e.getPlayer().getUniqueId());
		
		//set player resource pack to the special one :)))
		e.getPlayer().setResourcePack("https://drive.google.com/uc?export=download&id=1ZMhEpa_NN4QAcsJTlHghcKMERNzpflwi"); //fuck this deprecated method LMAOOO also blcokbench is SHIT
		
		
		//System.out.println("Shit status; " + LastTouched.wasTouched(e.getPlayer().getUniqueId()));
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onShit (PlayerToggleSneakEvent e) {
		Player player = e.getPlayer();
		
		if(!player.isSneaking()) {
			UUID playerID = player.getUniqueId();
			Material playerPooMaterial = lastEaten.getMaterialInMap(playerID);
			
			if(playerPooMaterial == null) {
				shitting(player, Material.COCOA_BEANS);
				return;
			}
				
			else if(playerPooMaterial.equals(Material.IRON_SWORD)) {
				shitting(player, lastEaten.getMaterialInMap(playerID));
				amountShifted.addShiftCount(playerID);
				player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
				player.damage(2.5);
				player.sendTitle(ChatColor.DARK_RED + "You feel a deep rumbling in your bowels...", "Shit, that " + 
						playerPooMaterial.toString() + " wasn't supposed to be there.", 10, 20, 10);
				lastEaten.setMaterialInMap(playerID, null);
				loseHunger(player);
				
			}
			else if(playerPooMaterial.equals(Material.APPLE)) {
				switch(amountShifted.getAmountShifted(playerID)) {
				case 0:
					//System.out.println("Squat 0 for apples!~");
					player.playSound(player.getLocation(), Sound.BLOCK_WOOD_BREAK, (float) .25, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 1:
					player.playSound(player.getLocation(), Sound.BLOCK_WOOD_FALL, (float) .5, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 2:
					player.playSound(player.getLocation(), Sound.ENTITY_HORSE_STEP_WOOD, (float) .75, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 3:
					player.playSound(player.getLocation(), Sound.ENTITY_SLIME_SQUISH, (float) 1, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 4:
					player.playSound(player.getLocation(), Sound.BLOCK_WOOD_FALL, 1, 1);
					amountShifted.addShiftCount(playerID);
					shitting(player, Material.OAK_SAPLING);
					break;
				default:
					System.out.println(amountShifted.getAmountShifted(playerID));
				}
			}
			else if(playerPooMaterial.equals(Material.BEEF) || playerPooMaterial.equals(Material.PORKCHOP)) {
				
				
				if(playerPooMaterial.equals(Material.BEEF) && amountShifted.getAmountShifted(playerID) >= 5) {
					birthing(player, EntityType.COW);
					
				}
				if(playerPooMaterial.equals(Material.PORKCHOP) && amountShifted.getAmountShifted(playerID) >= 5) {
					birthing(player, EntityType.PIG);
				}
				
				switch(amountShifted.getAmountShifted(playerID)) {
				case 0:
					player.playSound(player.getLocation(), Sound.ENTITY_SLIME_SQUISH, (float) .1, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 1:
					player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, (float) .25, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 2:
					player.playSound(player.getLocation(), Sound.ENTITY_SLIME_HURT, (float) .5, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 3:
					player.playSound(player.getLocation(), Sound.ENTITY_SLIME_SQUISH, (float) .75, 1);
					amountShifted.addShiftCount(playerID);
					break;
				case 4:
					player.playSound(player.getLocation(), Sound.ENTITY_SLIME_DEATH, (float) 1, 1);
					amountShifted.addShiftCount(playerID);
					break;
					
				}
			}
			else {
				shitting(player, Material.COCOA_BEANS);
				
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPickUpShit (PlayerAttemptPickupItemEvent e) {
		
		if(e.getItem().getItemStack().getItemMeta().getDisplayName().equals("Poo")) {
			if(!lastTouched.wasTouched(e.getPlayer().getUniqueId())) {
				e.getPlayer().sendMessage(ChatColor.DARK_RED + "Holy " + ChatColor.MAGIC + "SHIT" + ChatColor.RESET + "" + ChatColor.DARK_RED + " you're disgusting wtf!");
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1));
				lastTouched.addTouch(e.getPlayer().getUniqueId());
			}
			
			e.setCancelled(true);
		}
		
	}
	
	void shitting(Player player, Material m) {

		ItemStack poo = new ItemStack(m);
		ItemMeta pooMeta = poo.getItemMeta();
		pooMeta.setDisplayName("Poo");
		
		
		if(m.equals(Material.OAK_SAPLING)) {
			pooMeta.setCustomModelData(1);
			lastEaten.setMaterialInMap(player.getUniqueId(), null);
		}
		else {
			player.playSound(player.getLocation(), Sound.ENTITY_SLIME_SQUISH_SMALL, 1, 1);
		}
		
		poo.setItemMeta(pooMeta);
		
		Item droppedPoo = player.getWorld().dropItem(player.getLocation(), poo); //where tf is the exact location? the head? the ass? 
		//javadocs dont fkn help
		droppedPoo.setVelocity(shitVelocity(player));
		amountShifted.resetShiftCount(player.getUniqueId());
		
		loseHunger(player);
		
		
	}
	
	void birthing(Player player, EntityType a) {
		
		player.damage(5.5);
		player.sendMessage(ChatColor.RED + "HUHHH?? Okay, that's e - " + ChatColor.MAGIC + "fucking" + ChatColor.RESET
				+ " - nough.");
		lastEaten.setMaterialInMap(player.getUniqueId(), null);
		
		player.playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH, 1, 1);
		Entity animal = player.getWorld().spawnEntity(player.getLocation(), a, true);
		animal.setVelocity(shitVelocity(player));
		amountShifted.resetShiftCount(player.getUniqueId());
		
		loseHunger(player);
		
	}
	
	Vector shitVelocity(Player player) {
		Vector playerLookVec = player.getEyeLocation().getDirection();
		Vector oppositeVec = playerLookVec.clone().multiply(-1);
		
		return oppositeVec;
	}
	
	void loseHunger(Player player) {
		if(player.getSaturation() > 0  && player.getFoodLevel() > 0) {
			player.setSaturation(player.getSaturation() - 1);
		}
		else {
			player.setFoodLevel(player.getFoodLevel() - 2);
		}
	}
}
