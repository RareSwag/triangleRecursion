// Jaden Heinle
import java.awt.*;
import javax.swing.*;
public class hw_05 extends JFrame 
{
	int x0 = 250, y0 =0,
	x1 = 0, y1 = 500,
	x2 = 500, y2 = 500;
	
	
	//sets up window 
	public hw_05()
	{
		super("Triangles In Triangles!");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//Calls recursive function
	public void paint(Graphics g)
	{
		findTriangles(g, 5, x0, y0, x1, y1, x2, y2);
		
	}
	
	//Recursive function
	public void findTriangles(Graphics g, int number, int x0, int y0, int x1, int y1, int x2, int y2)
	{
		//Draws the final triangle and ends the recursion
		if(number == 0)
		{
			drawTriangle(g, number, x0, y0, x1, y1, x2, y2);
		}
		else
		{
			// Finds the needed points for the new triangles
			int x3 = (x0 + x1)/2, y3 = (y0 + y1)/2;
			int x4 = (x1 + x2)/2, y4 = (y1 + y2)/2;
			int x5 = (x0 + x2)/2, y5 = (y0 + y2)/2;
			
			//Calls itself with new values
			findTriangles(g, number-1, x0, y0, x3, y3, x5, y5);
			findTriangles(g, number-1, x3, y3, x1, y1, x4, y4);
			findTriangles(g, number-1, x5, y5, x4, y4, x2, y2);
		}
	}
	
	// Draws triangles
	public void drawTriangle(Graphics g, int number, int x0, int y0, int x1, int y1, int x2, int y2)
	{
		int x[]={x0,x1,x2};
		int y[]={y0,y1,y2};
		// Changes the color based on the level we are on
		if(number%2 == 0)
			g.setColor(Color.black);
		else
			g.setColor(Color.white);
		g.fillPolygon(x,y,3);
	}
	
	// runs the program first
	public static void main(String[] args)
	{
		new hw_05();
	}
}