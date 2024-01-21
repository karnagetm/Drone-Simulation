package drone_simulation;


import java.util.Random;
public class DroneArena {

	
	DroneArena(int x, int y){
		y_size = Integer.valueOf(y);
		
		x_size = Integer.valueOf(x);
		
		arena = new Drone[x][y];
		
		randomGenerator = new Random();
		
		drone_list = new Drone[x*y];
		
	}
	
	
	//setters
	private Integer x_size;
	private Integer y_size;
	public Drone[] drone_list;
	
	public static Integer number_of_drones = 0;
	private Drone[][] arena;
	private Random randomGenerator;
	private Drone posDrone;
	
	public void addPosDrone
	(int current_drone,
			int x_pos, 
			int y_pos, 
			String str) {
		
			
		
			// direction
				if(str.equals("NORTH"))
				{
					
					 posDrone = new Drone(x_pos,y_pos,Direction.NORTH);
				}
				if(str.equals("EAST"))
				{
					 
					 posDrone = new Drone(x_pos,y_pos,Direction.EAST);
				}
				if(str.equals("SOUTH"))
				{
				    
					 posDrone = new Drone(x_pos,y_pos,Direction.SOUTH);
				}
				if(str.equals("WEST"))
				{
					 
					 posDrone = new Drone(x_pos,y_pos,Direction.WEST);

				}	
		
					posDrone.setSpecificDrone(current_drone);
						int number_of_drones = 0;
						for(Drone d : drone_list) {
							if(d != null) {
								number_of_drones++;
								drone_list[number_of_drones+1] = posDrone; // sends new drone to back of list
							}
						}
						}
		
							
				//adds a drone
				public void addDrone() {
					Integer random_y = null;
						Integer random_x = null;
					do {
						random_y = randomGenerator.nextInt(y_size);
						random_x = randomGenerator.nextInt(x_size);
				} while (getDroneAt (random_x, random_y) instanceof Drone||
						random_y <= 1 || 
						random_x <= 1);
						// adding drone to random location and adding drone to list 
						Drone d = new Drone(random_x, random_y, Direction.getRandomDir());
						drone_list[number_of_drones]= d;
						number_of_drones++;
					
						arena[random_x][random_y] = d; // puts drone in arena
						}
				
				
				//getters
				public Drone[] getDroneList() {
					return drone_list;
				}
				
				public Drone getDroneAt(int x, int y) 
				{
					if (arena[x][y] instanceof Drone) 
					{
						return arena[x][y];
					} else {
						return null;
							}
						}
				
				public Integer getX() {
					return x_size;
				}
				
				public Integer getY() {
					return y_size;
				}
				
				
				//display drones to canvas
				public void showDrones(ConsoleCanvas c) {
					for (Drone d : drone_list) {
						if(d != null) {
							d.displayDrone(c);
							}
						}
					}
				
				//moving ALL drones
				public void moveAllDrones() {
					for(Drone d : drone_list) {
						if(d != null) {
							d.tryToMove(this);
							}
						}
					}
				
				//moves one drone
				public void moveDrone(Drone d, Integer new_x, Integer new_y) {
					arena [d.getXPos()][d.getYPos()] = null;
					arena [new_x][new_y]= d;
				}
					
				//this checks if all drones are within arena 
				public boolean canMoveHere ( Integer x_pos, Integer y_pos ) {
					if (x_pos  >= x_size-1 || x_pos<=0) {
						return false;
					}
					else if (y_pos >= y_size || y_pos<=0) {
						return false;
					}
					else if (getDroneAt( x_pos, y_pos ) instanceof Drone ) {
						return false;
					}
					else {
						return true;
					}
					
					
					
					
					
					
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}
		


	//public static void main(String[] args) {
	//	DroneArena a = new DroneArena(20,10); //create drone arena
		
	//	a.addDrone();
	//	System.out.println(a.toString()); //print where the drone is
//	}

//}