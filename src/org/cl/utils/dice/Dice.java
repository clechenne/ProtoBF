package org.cl.utils.dice;

public class Dice {
	private static IRandom random = MMRandom.generate(MMRandom.R_DEFAULT); 
	
	private static IRandom randomForUnregister=null;
	
	public static void register(IRandom aRandomImpl) {
		randomForUnregister = random;
		random = aRandomImpl;
	}
	
	public static Roll rollD6() {
		return random.d6();
	}

	public static Roll rollD12() {
		return random.d12();
	}

	public static Roll rollD4() {
		return random.d4();
	}
	
	public static void unregister() {
		if (randomForUnregister != null) {
			random = randomForUnregister;
		}
		
	}
}
