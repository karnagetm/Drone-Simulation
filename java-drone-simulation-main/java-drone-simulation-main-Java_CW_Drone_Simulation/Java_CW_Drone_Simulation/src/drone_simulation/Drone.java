package drone_simulation;

public class Drone {
	private Integer x_pos;
	private Integer y_pos;
	public static int drone_identifier = 0;
	private Direction current_direction;
	private Integer specific_drone;
	
	
	Drone(int x, int y, Direction dir){
		y_pos = Integer.valueOf(y);
		x_pos = Integer.valueOf(x);
		specific_drone = drone_identifier;
		current_direction = dir;
		drone_identifier++;
	}


	
	public boolean isHere(int x, int y) {//checks if drone is in correct location
		if(x_pos == x && y_pos == y) {
			return true;
	} 	else {
			return false;
	}
}
	
	//getters
	public int getXPos() {
		return x_pos;
	}
	public int getYPos() {
		return y_pos;
	}
	public int getCurrentDrone() {
		return specific_drone;
	}
	public Direction getDirection() {
		return current_direction;
	}
	public void setSpecificDrone (int current_drone) {
		specific_drone = current_drone;
	}
	
	
	// show drone to canvas
	public void displayDrone(ConsoleCanvas c) {
		c.showIt(x_pos,y_pos,'D');
	}
	
	
	
	
	// moving drone to new position
	public void tryToMove(DroneArena a ) {
			switch(current_direction) { // location from old location 
			case NORTH: //old location NORTH
				if (a.canMoveHere(x_pos, y_pos-1)) {
					a.moveDrone(this,x_pos ,y_pos-1);
					x_pos++;
					
				}
				else {
					current_direction = current_direction.getNextDir();
				}
				break;
				
			case EAST:
				if(a.canMoveHere(x_pos+1, y_pos)) {
					a.moveDrone(this, x_pos+1, y_pos);
					x_pos++;
				}
				else {
					current_direction = current_direction.getNextDir();
				}
				break;
			case SOUTH:
				if(a.canMoveHere(x_pos, y_pos+1)) {
					a.moveDrone(this, x_pos, y_pos+1);
					y_pos++;
				}
				else {
					current_direction = current_direction.getNextDir();
				}
				break;
				
			case WEST:
				if(a.canMoveHere(x_pos-1, y_pos)) {
					a.moveDrone(this, x_pos-1, y_pos);
					x_pos--;
				}
				else {
					current_direction = current_direction.getNextDir();
				}
				break;
				
				
				
				
				
			}
	}
	
	
	
	
}
	
	


	//public static void main(String[] args) {
	//	Drone d = new Drone(5, 3);
	//	Drone e = new Drone(4, 3); //creating drone
	//	System.out.println(d.toString());
	//	System.out.println(e.toString());//print where drone is

//	}

// }
