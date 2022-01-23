package net.trialtest.shitmod;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;

public class LastEaten {
	
	private HashMap<UUID, Material> lastEaten = new HashMap<UUID, Material>();
	
	//public UUID getPlayerInMap(UUID p) {
		//return lastEaten.get(p);
	//}
	
	public Material getMaterialInMap(UUID p) {
		return lastEaten.get(p);
	}
	
	public void setPlayerInMap(UUID p){
		lastEaten.put(p, null);
	}
	
	public void setMaterialInMap(UUID p, Material m) {
		lastEaten.replace(p, m);
		//lastEaten.remove(p);
		//lastEaten.put(p, m);
		//System.out.println(getMaterialInMap(p));
	}

}
