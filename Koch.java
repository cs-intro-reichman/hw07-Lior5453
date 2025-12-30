/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch 
{
	public static void main(String[] args) 
	{
		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.
        

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// 	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//       Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		
		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) 
	{
		// stop case for when finished making n curves
		if (n == 0)
		{
			// Drawing First stage then ending
			StdDraw.line(x1, y1, x2, y2);	
			return;
		}		

		// Setting new vaules, then drawing it and sending it to the recusively function
		double xKodkod = ((Math.sqrt(3) / 6) * (y1 - y2) + 0.5 * (x1 + x2));
		double yKodkod = ((Math.sqrt(3) / 6) * (x2 - x1) + 0.5 * (y1 + y2));
		double xStartCurve = x1 + (x2 - x1) / 3.0;
		double yStartCurve = y1 + (y2 - y1) / 3.0;
		double xEndCurve = x1 + 2 * (x2 - x1) / 3.0;
		double yEndCurve = y1 + 2  * (y2 - y1) / 3.0;

		StdDraw.line(x1, y1, xStartCurve, yStartCurve);
		StdDraw.line(xStartCurve, yStartCurve, xKodkod, yKodkod);
		StdDraw.line(xKodkod, yKodkod, xEndCurve, yEndCurve);
		StdDraw.line(xEndCurve, yEndCurve, x2, y2);

		// Removing the line between the start of curve to end of curve
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(xStartCurve, yStartCurve, xEndCurve, yEndCurve);
		StdDraw.setPenColor(StdDraw.BLACK);

		curve(n - 1, x1, y1, xStartCurve, yStartCurve);
		curve(n - 1, xStartCurve, yStartCurve, xKodkod, yKodkod);
		curve(n - 1, xKodkod, yKodkod, xEndCurve, yEndCurve);
		curve(n - 1, xEndCurve, yEndCurve, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) 
	{
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		// Initializing the 3 corners in the snow flake
		double x1 = 0.2;
		double y1 = 0.4;
		double x2 = 0.9;
		double y2 = 0.4;
		double x3 = (x1 + x2) / 2.0;
		double y3 = y1 + (Math.sqrt(3) * (x2 - x1) / 2.0);

		// Calling the 3 seprate
		curve(n, x2, y2, x1, y1);
    	curve(n, x1, y1, x3, y3);
    	curve(n, x3, y3, x2, y2);
	}
}