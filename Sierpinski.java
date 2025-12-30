/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski 
{	
	public static void main(String[] args) 
	{
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) 
	{
		// Initilaizing values for big first triangle - max size 1*1
		double x1 = 0.1;
		double y1 = 0.1;
		double x2 = 0.9;
		double y2 = 0.1;
		double x3 = 0.5;
		double y3 = 0.9; 

		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) 
	{
		// stop case for when finished making n triangles
		if (n == 0) 
			return;

		// Drawing current triangle
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);

		// Setting new values for each corner of middle of each line
		double x12 = (x1 + x2) / 2.0;
		double y12 = (y1 + y2) / 2.0;
		double x23 = (x2 + x3) / 2.0;
		double y23 = (y2 + y3) / 2.0;
		double x31 = (x3 + x1) / 2.0;
		double y31 = (y3 + y1) / 2.0; 

		// Drawing the new traingles in the each of the 3 corners
		sierpinski(n-1, x12, x23, x2, y12, y23, y2);
		sierpinski(n-1, x1, x31, x12, y1, y31, y12);
		sierpinski(n-1, x31, x3, x23, y31, y3, y23);
	}
}