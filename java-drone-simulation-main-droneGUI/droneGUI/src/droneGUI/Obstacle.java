package droneGUI;

public class Obstacle extends Item {
	/**
	 * 
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public Obstacle(double ix, double iy, double ir) {
		super(ix, iy, ir);
	}
	protected String getStrType() {
		return "Obstacle";
	}
	
	
	@Override
	protected void checkItem(DroneArena da) { 
		
	}
		
	@Override								
	protected void adjustItem() { 

	}
}
