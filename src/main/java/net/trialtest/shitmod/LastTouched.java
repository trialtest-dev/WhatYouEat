package net.trialtest.shitmod;

import java.util.HashMap;
import java.util.UUID;



public class LastTouched {
	private HashMap<UUID, Boolean> lastTouched = new HashMap<UUID, Boolean>();
	
	public Boolean wasTouched(UUID id) {
		Boolean a = lastTouched.get(id);
		if(a == null) {
			lastTouched.put(id, Boolean.FALSE);
		}
		Boolean b = lastTouched.get(id);
		return b;
	}
	
	public void addTouch(UUID id) {
		lastTouched.remove(id);
		lastTouched.put(id, Boolean.TRUE);
	}
	
	public void resetTouch(UUID id) {
		lastTouched.remove(id);
		lastTouched.put(id, Boolean.FALSE);

	}
}
