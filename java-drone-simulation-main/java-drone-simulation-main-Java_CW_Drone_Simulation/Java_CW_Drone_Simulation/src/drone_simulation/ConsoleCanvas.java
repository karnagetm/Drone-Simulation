package drone_simulation;

public class ConsoleCanvas {
	
	private char[][] canvas;
	
	public void showIt(Integer x, Integer y, char drone) {
		canvas[y][x] = drone;
		return;
	}
	
	ConsoleCanvas(Integer x, Integer y){
		canvas = new char[y+2][x+2];
		
		for(int i = 0; i <=y; i++) 
		{
			canvas[i] [0] = '#';
					canvas[i] [x+1] = '#';
		}
		
		for(int i = 0; i<=x; i++)
		{
			canvas[0][i]= '#';
			
				canvas[y+1][i]= '#';
		}
			canvas[y+1][x+1]='#';		
	}
	
	
	public String writeCanvas() {
		String res = "";
		
		for(int i = 0; i<canvas.length; i++) {
			res +='\n';
			
			for(int c = 0; c<canvas[0].length; c++) {
				res+=canvas[i][c];
			}
		}
				res += '\n';
					return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
