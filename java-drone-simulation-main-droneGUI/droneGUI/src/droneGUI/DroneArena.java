package droneGUI;

import java.util.ArrayList;
import java.util.Random;

public class DroneArena {	
	private Random randomGenerator;		// used for random obstacles
	private double xSize, ySize;		// size of arena
	private ArrayList<Item> allItems;	// array list of all drones in arena
	
	DroneArena() {
		this(600, 600);		//creates arena 	
	}
	
	DroneArena(double xS, double yS){
		xSize = xS;
		ySize = yS;
		allItems = new ArrayList<Item>();					
		randomGenerator = new Random();
	}
	
	public double getXSize() { //returns arena size in x
		return xSize;
	}
	
	public double getYSize() { //returns arena size in y
		return ySize;
	}
	
	public void drawArena(MyCanvas mc) {
		
		for (Item I : allItems) I.drawItem(mc);	// draws all Items
	}

	public void checkItems() {
		ArrayList<Item> allItemsClone = (ArrayList<Item>) allItems.clone(); 
		
		for (Item I : allItemsClone)I.checkItem(this);	// Checks the angle of all Items using the checkItemAngle function from DroneBorderPane.
	}

	public void adjustItems() {
		for (Item I : allItems) I.adjustItem();
	}
	public ArrayList<String> describeAll()
	{
		ArrayList<String> ans = new ArrayList<String>();// set up ArrayList
		
		for (Item I : allItems) ans.add(I.toString());			// add string desc defining each drone in arena
		return ans;												// return string list
	}

	public double checkItemAngle(double x, double y, double rad, double ang, int notID) { 					// x = Item x position, rad = radius 																								// y = Item y position, ang = angle		
		double ans = ang;
		
		if (x < rad || x > xSize - rad) ans = 180 - ans;
			// Set mirror angle if the ball is about to pass through the left or right walls.
		
		if (y < rad || y > ySize - rad) ans = - ans;
			// if try to go off top or bottom, deflects back 	
		
		for (Item I : allItems) 
			
			if (I.getID() != notID && I.hitting(x, y, rad)) ans = 180*Math.atan2(y-I.getY(), x-I.getX())/Math.PI;
				
		
		return ans;	// return the angle
	}
	public boolean checkHit (Item Drone) {	//check if the hunter has hit a drone	
		boolean ans = false;
		
    	for (Item I : allItems)
    		if (I instanceof DroneHunter && I.hitting(Drone)) ans = true;
		return ans;			
	}
		public void removeDrone(Item drone) {
			allItems.remove(drone);
	}
			public void reset() {
					allItems.clear();
	}
	public void addDrone() {
		allItems.add(new Drone(xSize/3, ySize/2, 10, 60, 5));
	}
	public void addConsole() {
		allItems.add(new ConsoleDrone(randomGenerator.nextDouble()*(xSize-10/2), randomGenerator.nextDouble()*(ySize-10/3), 10, 10, 3));  
	}																																	   
	public void addHunter() {
		allItems.add(new DroneHunter(randomGenerator.nextDouble()*(xSize-5/2), randomGenerator.nextDouble()*(ySize-5/3), 5, 30, 1));
	}
	public void addObstacle() {
		allItems.add(new Obstacle(randomGenerator.nextDouble()*(xSize-15/2), randomGenerator.nextDouble()*(ySize-15/3), 15));  
		// places the obstacle randomly in the arena
	}																														   	
}