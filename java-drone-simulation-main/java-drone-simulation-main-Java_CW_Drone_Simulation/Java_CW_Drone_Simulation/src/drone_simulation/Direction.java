package drone_simulation;

import java.util.Random;

public enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	
	public static Direction getRandomDir() { // 
		// chooses random direction from the list
		Random random = new Random();
		
		return values()[random.nextInt(values().length)];	
	}
	
	public Direction getNextDir() {
		return values()[(this.ordinal() + 1) % values().length];
	}
}
