package droneGUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


public class MyCanvas {
	private int xCanvasSize = 600;
	private int yCanvasSize = 600;
	private GraphicsContext gc;
	
	public MyCanvas(GraphicsContext g, int xcs, int ycs) { 
		xCanvasSize = xcs;
		yCanvasSize = ycs;
		gc = g;
	}
	
	public int getXCanvasSize() {  //this gets the size of x in the canvas
    		return xCanvasSize;
    }

	 public int getYCanvasSize() {  //this gets the size of yCanvas 
	    	return yCanvasSize;
	    }

	     //clears the canvas
	    public void clearCanvas() {
			gc.clearRect(0,  0,  xCanvasSize,  yCanvasSize);		
	    }
	 
	   
	    private Color colFromChar (char c){ // this changes char c to the real colour used
			Color ans = Color.RED;
			switch (c) {
			case 'y' :	ans = Color.WHITE;
						break;
			case 'w' :	ans = Color.YELLOW;
						break;
			case 'r' :	ans = Color.BLACK;
						break;
			case 'g' :	ans = Color.PURPLE;
						break;
			case 'b' :	ans = Color.BLUE;
						break;
			case 'o' :	ans = Color.PINK;
						break;
			}
			return ans;
		}
	    		public void setFillColour (Color c) {
	    			gc.setFill(c);
	    		}
	
	    		public void showCircle(double x, double y, double rad, char col) { //show the Item at position x,y
	    		 	setFillColour(colFromChar(col));		
	    		 	// set the colour
	    			gc.fillArc(x-rad, y-rad, rad*2, rad*2, 0, 360, ArcType.ROUND);	// makes drones circular     
	    		}
	    	
	
	
	
	
	
	
	
	
	

}
