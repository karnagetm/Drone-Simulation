package droneGUI;

public abstract class Item {   //Abstract class of which, all subsequent Items are based on
	
	protected double x, y, rad;		// position and size of Item
	protected char col;				// used to set colour
	static int ItemCounter = 0;		// gives item unique number to find
	protected int ItemID;			
	
	
	Item() {
		this(100, 100, 10);   
	}
	
	Item (double ix, double iy, double ir) {
				x = ix;
				y = iy;
				rad = ir;
					ItemID = ItemCounter++;								
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getRad() { return rad; }
	public void setXY(double nx, double ny) {
		x = nx;
		y = ny;
	}
	
	
	public int getID() {return ItemID; } //identity of item
	
	public void drawItem(MyCanvas mc) {
		mc.showCircle(x, y, rad, col);
	}
	
	protected String getStrType() {
		return "Item";
	}
	
	public String toString() {
		return getStrType() + " "+ ItemID +" at "+Math.round(x)+", "+Math.round(y); //return string describing Item
	}
	
	protected abstract void checkItem(DroneArena da); // checks items in arena
	
	protected abstract void adjustItem(); // adjusts items 
	
	public boolean hitting(double ox, double oy, double or) 
	{
		return (ox-x)*(ox-x) + (oy-y)*(oy-y) < (or+rad)*(or+rad);
	}		
	public boolean hitting (Item oItem)
	{
		return hitting(oItem.getX(), oItem.getY(), oItem.getRad());
	}
}

