package droneGUI;

public class Drone extends Item {
	
	protected double droneAngle;
	protected double droneSpeed;
	public Drone(double ix, double iy, double ir, double iang, double isp)
	{
		super(ix, iy, ir);
		col = 'r';
		droneAngle = iang;
		droneSpeed = isp;
	}
	
	@Override
	protected void checkItem(DroneArena da) {	//Uses the droneArena method checkItemAngle
		droneAngle = da.checkItemAngle(x, y, rad, droneAngle, ItemID);
		if (da.checkHit(this)) da.removeDrone(this);	
	}
	
	@Override
	protected void adjustItem() {
		double radAngle = droneAngle*Math.PI/180;	//adjusts the items
		x += droneSpeed * Math.cos(radAngle);		// new X position
		y += droneSpeed * Math.sin(radAngle);		// new Y position
	}
	
	@Override
	public String toString() { //Generates a string of info, mostly used for testing
		return getStrType() + " "+ ItemID +" at "+Math.round(x)+", "+Math.round(y) + " angle" + Math.round(droneAngle);
	}
	
	@Override
	protected String getStrType() {
		return "Classic Drone";
	}
}