package drone_simulation;
import java.util.Scanner;




public class DroneInterface {
	
	private Scanner s;							
   	private DroneArena myArena;
   	String direc;
   
   	// MAIN Function that allows the interface to appear
	public static void main(String[] args) {
		DroneInterface r = new DroneInterface();
	}
   	
   	
   	
   	//doDisplay settings- displays canvas
   		public void doDisplay() {
   			Integer y_size = myArena.getY();
	    	Integer x_size = myArena.getX();
	    	
	    	ConsoleCanvas c = new ConsoleCanvas(x_size,y_size);
	    	myArena.showDrones(c);
	    	System.out.print(c.writeCanvas());
	    
   		}
   		
   		
   	//turnOn the drones
	    private void turnOn() {
	    	int count = 10;
	    	while(count>0) {
				
				myArena.moveAllDrones();
    			this.doDisplay();
    			count--;
    			try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	    }
	    
   		
   	public DroneInterface() {
   		s = new Scanner(System.in);
   		myArena = new DroneArena(20, 10);
   		char choice = ' ';
   		do {
   			//menu
   			System.out.print("A: adds drone, D: display drones, M: move drones,"
   					+ " N: makes all drones move, B : new empty arena, X: exit > ");
   			s.nextLine();
   				choice = s.next().charAt(0);
   				switch (choice) {
   				case 'A' :
    			case 'a' :
    				myArena.addDrone();
    				break;
    				
    				
    			case 'D' :
        		case 'd' :
        			this.doDisplay();
        			break;
        			
        			
        		case 'M':
        		case 'm':
        			myArena.moveAllDrones();
        			this.doDisplay();
        			break;
        			
        		case 'N':
        		case 'n':
        			this.turnOn();
        			break;
        			
        		case 'B':
        		case 'b':
        			System.out.print("input new x size >>");
        			int x_size = s.nextInt();
        			
        			System.out.print("Enter the new y size >>");
        			int y_size = s.nextInt();
        			
        			myArena = new DroneArena(x_size, y_size);
        			break;
        			
        			case 'x' : choice ='X';
        			break;
        			}
   		
   				} while (choice != 'X');
   					s.close();
   			}
   
   	
   	}
