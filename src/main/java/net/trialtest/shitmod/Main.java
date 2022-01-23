package net.trialtest.shitmod;

import org.bukkit.plugin.java.JavaPlugin;

import net.trialtest.shitmod.listeners.EatingListeners;
import net.trialtest.shitmod.listeners.ShittingListeners;

public class Main extends JavaPlugin {
	private static LastEaten lastEatenObject = new LastEaten();
	private static AmountShifted amountShiftedObject = new AmountShifted();
	private static LastTouched lastTouchedObject = new LastTouched();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ShittingListeners(), this);
		getServer().getPluginManager().registerEvents(new EatingListeners(), this);
		
		
		//LastEaten.init();
		//LastTouched.init();
		//AmountShifted.init();
	}

	@Override
	public void onDisable() {
		
	}
	
	public static LastEaten getLastEatenObject() {
		return lastEatenObject;
	}
	
	public static AmountShifted getAmountShiftedObject() {
		return amountShiftedObject;
	}

	public static LastTouched getLastTouchedObject() {
		return lastTouchedObject;
	}
}
