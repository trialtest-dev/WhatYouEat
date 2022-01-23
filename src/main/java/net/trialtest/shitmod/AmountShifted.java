package net.trialtest.shitmod;

import java.util.HashMap;
import java.util.UUID;

public class AmountShifted {
	private HashMap<UUID, Integer> amountShifted = new HashMap<UUID, Integer>();
	
	public Integer getAmountShifted(UUID id) {
		Integer placeholder = amountShifted.get(id);
		System.out.println("Squat for " + placeholder + " apples~~");
		return amountShifted.get(id);
		
	}
	
	public void addPlayer(UUID id) {
		amountShifted.put(id, new Integer(0));
	}
	
	public void addShiftCount(UUID id) {
		System.out.println(getAmountShifted(id));
		
		if(amountShifted.get(id) == null) {
			amountShifted.replace(id, 0);
		}
		else {
			Integer placeholder = new Integer(amountShifted.get(id).intValue() + 1);
			amountShifted.replace(id, placeholder);
		}
		
	}
	
	public void resetShiftCount(UUID id) {
		amountShifted.replace(id, 0);
	}
}
