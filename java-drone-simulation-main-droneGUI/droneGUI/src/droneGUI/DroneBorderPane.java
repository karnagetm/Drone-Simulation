package droneGUI;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DroneBorderPane extends Application {
	private MyCanvas mc;
	private AnimationTimer timer;								// timer 
	private VBox rtPane;										// information box for hit registration
	private DroneArena da;
	
	private void showAbout() {
	    Alert alert = new Alert(AlertType.INFORMATION);				//   popup box to be used in the setMenu method; when the about menu is selected, this box appears.
	    alert.setTitle("About");									// title of the box 
	    alert.setHeaderText(null);									// set header text	
	    alert.setContentText(" If you want to reset the simulation, go to File > Reset Simulation. ");		
	    alert.showAndWait();
	} 																	// show box 	
	    
	   
	private MenuBar setMenu() {
		MenuBar menuBar = new MenuBar();						// create main menu
	
		Menu mFile = new Menu("File");	
		// add File main menu
		MenuItem mExit = new MenuItem("Exit");	
		// create Exit sub menu
		MenuItem mReset = new MenuItem("Reset");     
		// create Reset sub menu
		mExit.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {					// action on exit is
	        	timer.stop();									// stop timer
		        System.exit(0);									// exit program
		    }   
		});
		mReset.setOnAction(new EventHandler<ActionEvent>() {	
			 public void handle(ActionEvent t) {		
				 da.reset();									// Clears the ArrayList 
			 }
		});
		
								
		mFile.getItems().addAll(mReset);		// add Reset to File menu
		mFile.getItems().addAll(mExit);				// add exit to File menu
		
		Menu mHelp = new Menu("Help");							// create Help menu
		MenuItem mAbout = new MenuItem("About");				// add About sub menu
		mAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	showAbout();									// and its action to print about
            }	
		});
		mHelp.getItems().addAll(mAbout);						// add About to Help main item
		
		menuBar.getMenus().addAll(mFile, mHelp);				// set main menu with File, Help
		return menuBar;				
								
	}
	
	private HBox setButtons() {
	    Button btnStart = new Button("Start");					// create button for starting
	    btnStart.setOnAction(new EventHandler<ActionEvent>() {	
	        @Override
	        public void handle(ActionEvent event) {
	        	timer.start();									
	       }
	    });

	    Button btnStop = new Button("Pause");					//  button for stop
	    btnStop.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	           	timer.stop();									// and its action to stop the timer
	       }
	    });

	    Button btnAddDr = new Button("Add Drone");				//Adds a button to add drone
	    btnAddDr.setOnAction(new EventHandler<ActionEvent>() {
	        

	        public void handle(ActionEvent event) {
	           	da.addDrone();								
	           	drawWorld();									//resets the Drone Arena after
	       }
	        
	    });
	    Button btnAddOb = new Button("Add Obstacle");			//add Obstacle	
	    btnAddOb.setOnAction(new EventHandler<ActionEvent>()
	    {
	        
	        public void handle(ActionEvent event)
	        {
	           	da.addObstacle();							
	           	drawWorld();	
	        }
	    });
	    Button btnAddHtr = new Button("Add Hunter");			//add HunterDrone	
	    btnAddHtr.setOnAction(new EventHandler<ActionEvent>()
	    {
	        
	        public void handle(ActionEvent event)
	        {
	           	da.addHunter();								
	           	drawWorld();	
	        }
	    });
	    Button btnAddCon = new Button("Add ConsoleDrone");		//add ConsoleDrone		
	    btnAddCon.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	           	da.addConsole();								
	           	drawWorld();	
	        }
	    });
	    return new HBox(new Label("Run: "), btnStart, btnStop, new Label("Add: "), btnAddDr, btnAddOb, btnAddHtr, btnAddCon);
	}
	
	public void drawWorld () 
	{
	 	mc.clearCanvas();						
	 	da.drawArena(mc);
	}
	
	public void drawStatus() 
	{
		rtPane.getChildren().clear();					
		ArrayList<String> allIs = da.describeAll();
		for (String s : allIs) 
		{
			Label l = new Label(s); 		
			rtPane.getChildren().add(l);	// adds label	
		}	
	}
	
	public void start(Stage primaryStage) throws Exception {  //Creates the canvas and arena, sets up the GUI
		
		primaryStage.setTitle("DroneArena "); //title of the window
	    BorderPane bp = new BorderPane();
	    bp.setPadding(new Insets(10, 20, 10, 20));						

	    bp.setTop(setMenu());											

	    Group root = new Group();										
	    Canvas canvas = new Canvas( 400, 500 );
	    root.getChildren().add( canvas );
	    bp.setLeft(root);												
	
	    mc = new MyCanvas(canvas.getGraphicsContext2D(), 400, 500);		

	    da = new DroneArena(400, 500);								    // set up arena
	    drawWorld();
	    
	    timer = new AnimationTimer() {									// set up timer
	        public void handle(long currentNanoTime) {					// and its action when on
	        		da.checkItems();									// check the angle of all drones
		            da.adjustItems();								    // move all drones
		            drawWorld();										// reset the drone arena
		            drawStatus();										// indicate where drones are
	        }
	    };

	    rtPane = new VBox();			
	    // set vBox on right to list items
		rtPane.setAlignment(Pos.TOP_LEFT);	
		// set alignment
		rtPane.setPadding(new Insets(5, 75, 75, 5));
		// padding
 		bp.setRight(rtPane);											
	    bp.setBottom(setButtons());										// set bottom pane with buttons

	    Scene scene = new Scene(bp, 700, 600);	
	    
        bp.prefHeightProperty().bind(scene.heightProperty());
        
        bp.prefWidthProperty().bind(scene.widthProperty());

        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
	    Application.launch(args);			// launches the GUI

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
