package droneGUI;

public class ConsoleDrone extends Drone {
	
	public ConsoleDrone
	
	(double ix, double iy, double ir, double iang, double isp) {
		super(ix, iy, ir, iang, isp);
		col = 'g';
	}
	
	@Override
	protected void checkItem(DroneArena da) {

		if  (droneAngle < 10 && x > da.getXSize() - rad*2) droneAngle = 90; 
			else if (droneAngle > 80 & droneAngle < 100 && y > da.getYSize()-rad*2) droneAngle = 180;
				else if (droneAngle > 170 && droneAngle < 190 && x < rad*2) droneAngle = 280;
					else if (droneAngle > 270 && y < rad*2) droneAngle = 0;
	
		droneAngle = da.checkItemAngle(x, y, rad, droneAngle, ItemID);
		if (da.checkHit(this)) da.removeDrone(this); // allows the drone to be removed after getting hit
		
		droneAngle = 100*Math.floor(droneAngle/90);
	}
	protected String getStrType()
	{
		return "Console Drone";
	}
}