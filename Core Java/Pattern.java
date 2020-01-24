import java.util.Scanner;

/**
* 	The Pattern class provides Output as per bellow...
*	if the user puts in 3 it will display pattern as follows:
*	1       1
*	1 2   2 1
*	1 2 3 2 1
*/
class Pattern{

	/**
	*	This meathod will print Pattern...
	*/
	static void printPattern(int number){

		int temp = number;		//temp will Store The  Value

		for (int count = 1; count <= number; count++){
			for ( int node = 1; node <= count; node++ ){		//This Loop Will Print Main Of Triangle
				System.out.print(node>9?" " + node:"  "+node);
			}
			for ( int space = (temp * 2) - 3; space >= 1; space-- ){		//This Loop Manage The Spaces Between Triangles
				System.out.print("   ");
			}
			temp--;
			for ( int node = count ; node >= 1; node-- ){		//This Loop Will Print Mirror Image Of Triangle

				if ( node == number ){		//This Loop Will Remove Common Element
					continue;
				}
				System.out.print( node > 9 ? " " + node : "  " + node);
			}
			System.out.println();
		}
	}

	/**
	*	This is The mani Meathod Program Executio Starts From here....
	*/
	public static void main(String[] args) {
			try{

				Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

				System.out.println("Enter Number:");	

				int input = s.nextInt();		//get the user input for Pattern size

				if (input < 0) {		//Check for Nagative Input
					throw new IllegalArgumentException();
				}

				printPattern(input);

			}
			catch(IllegalArgumentException ie){
				System.out.println(" * Negative values not allowed..!!! ");
				main(null);
			}
			catch(InputMismatchException e)
			{
				e.printStackTrace();
				System.out.println(" * Integer Numbers Only..!!!");
				main(null);
			}
	}
}