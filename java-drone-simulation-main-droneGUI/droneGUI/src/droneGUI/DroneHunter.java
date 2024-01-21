package droneGUI;

public class DroneHunter extends Drone {
	
	public DroneHunter
			(double ix,
			double iy, 
			double ir, 
			double iang, 
			double isp) {
		
			super (ix,
				iy, 
				ir, 
				iang,
				isp);
			
		col = 'b';
	}
	
	protected void checkItem(DroneArena da) {  //Checks collisions with items and border wall
		droneAngle = da.checkItemAngle(x, y, rad, droneAngle, ItemID);
	}
	
	protected String getStrType() { // displays name for items e.g Drone hunter
		return "Drone Hunter";
	}
}
