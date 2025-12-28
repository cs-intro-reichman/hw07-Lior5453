/** Computes the binomial(n,k) function. */
public class Binomial 
{	
    public static void main(String[] args) 
	{
		// // Uncomment the version of binomial that you want to test
 
		// Testing the basic binomial implementation:
    	// System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		// Testing the optimized binomial implementation:
		System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	// Computes the Binomial function, basic version.
	// Int max values: 2,147,483,648, Long max values: 9,223,372,036,854,775,807
	public static int binomial1(int n, int k) 
	{ 
		if (k > n) 
			return 0; 

		if (k == 0 || n == 0) 
			return 1; 

		return binomial1(n - 1, k) + binomial1(n - 1, k - 1);  
	}
	
	// Computes the Binomial function, efficiently
	public static int binomial(int n, int k) 
	{
		// Creating 2D array the size of n+1,k+1 because using values of index and not 0 
		int[][] demo = new int[n + 1][k + 1];

		// Initializing all values to -1
		for (int i = 0; i < demo.length; i++)
		{
			for (int j = 0; j < demo[i].length; j++)
			{
				demo[i][j] = -1;
			}
		}
		
		return binomial(n, k, demo);
	}

	private static int binomial(int n, int k, int[][] memo) 
	{
		if (memo[n][k] != -1) 
			return memo[n][k];

		// Base case
		if ((k > n)) 
		{
		   	memo[n][k] = 0; 
		   	return 0;
		}

		// Another base case
		if (n == 0 || k == 0) 
		{
		   	memo[n][k] = 1; 
		   	return 1;
		}

		memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}
}