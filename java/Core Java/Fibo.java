import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
* 	The Fibo class provides Output as per bellow...
*	if the user puts in 3 it will display pattern as follows:
*		 0 
*		1 1 
*	   2 3 5 
*       8 13 
*        21
*/
class Fibo{

	/**
	*	This meathod will print Fibonacci Serice
	*	in Diamond Pattern
	*/
	static void printFibo(Queue q,int n) throws Exception{

		int i,j,k;

		for (i=1; i<=n; i++) {
			for (j=n; j>=i; j--) {
				System.out.print(" ");
			}
			for (k=1; k<=i; k++) {
				System.out.print(q.remove()+" ");
			}		
			System.out.println();
		}

		for (i=n; i>=1; i--) {
			for (j=n; j>=(i-1); j--) {
				System.out.print(" ");
			}
			for (k=1; k<=(i-1); k++) {
				System.out.print(q.remove()+" ");
			}				
			System.out.println();
		}
	}

	public static void main(String[] args) {

		try{

			Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

			System.out.println("Enter Number:");	

			int n = s.nextInt();		//get the user input for Queue size

			//initlizing the Queue
			Queue<Integer> q = new LinkedList<>();

			int a1=-1,
				a2=1,
				a3;

			//creating Fibonacci Serice
			for (int f=1; f<=(n*n); f++) {
					a3 = a1 + a2;
					a1 = a2;
					a2 = a3;
					q.add(a3);		//adding elements to the Queue
				}	

			printFibo(q,n);
		}
		catch(Exception e){
			System.out.println(" * Numbers Input Only");
			e.printStackTrace();
		}
	}
}