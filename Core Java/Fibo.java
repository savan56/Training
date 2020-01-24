import java.util.Scanner;
import java.util.LinkedList;

/**
* 	The Fibo class provides Output as per bellow...
*	if the user puts in 3 it will display pattern as follows:
*		 0 
*      1    1 
*    2    3    5 
*      8   	13
*        21
*/
class Fibo{

	/**
	*	This meathod will print Fibonacci Serice
	*	in Diamond Pattern
	*/
	static void printFibo(LinkedList list,int n,int len) throws Exception{

		int before = len;		//Initlize the value of 'l' to 'before'

		for (int upper_row=1; upper_row<=n; upper_row++) {		//This loop to manage The Upper rows
			for (int space=n; space>=upper_row; space--) {		//Manage the space to Print Upper 'Diamond'

				while(before >0){
					System.out.print(" ");
					before--;
				}
				before = len;
			}
			for (int before_space=1; before_space<=upper_row; before_space++) {		//Manage space before the element 
				while(before >=0){
					System.out.print(" ");
					before--;
				}
				before = len;

				System.out.print(list.remove());		//print the element

				if (!list.isEmpty()) {

					int after = before - (length((int)list.get(0)));		// count the space require after the element

					while(after > 0){		//print the spaces after element
						System.out.print(" ");
						after --;
					}
				}
			}		
			System.out.println();
		}

		for (int lower_row=n; lower_row>=1; lower_row--) {		//This loop to manage The Lower rows
			for (int space=n; space>=(lower_row-1); space--) {		//Manage the space to Print Upper 'Diamond' 

				while(before >0){
					System.out.print(" ");
					before--;
				}
				before = len;		
			}
			for (int before_space=1; before_space<=(lower_row-1); before_space++) {		//Manage space before the element 

				while(before >=0){
					System.out.print(" ");
					before--;
				}
				before = len;

				System.out.print(list.remove());		//print the element

				if (!list.isEmpty()) {

					int after = before - (length((int)list.get(0)));		// count the space require after the element		

					while(after > 0){		//print the spaces after element
						System.out.print(" ");
						after --;
					}	
				}
			}				
			System.out.println();
		}
	}

	/**
	*	This meathod will return lent of int Number
	*/
	static int length(int num){

		// int count = 0;

		// while(n != 0){
		// 	n = n/10;
		// 	count++;
		// }
		// return count;

		int count = (int)(Math.log10(num)+1);	//To remove loop for more optimal form

		return count;
	}

	/**
	*	This is The mani Meathod Program Executio Starts From here....
	*/
	public static void main(String[] args) {
		int ans;
		do{
			try{

				Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

				System.out.println("Enter Number:");	

				int input = s.nextInt();		//get the user input for Queue size

				if (input > 0) {
					//initlizing the Queue
					LinkedList<Integer> list = new LinkedList<Integer>();

					int first=-1,
						second=1,
						next,
						len=0;

					//creating Fibonacci Serice
					for (int f=1; f<=(input*input); f++) {
							next = first + second;
							first = second;
							second = next;
						list.add(next);		//adding elements to the Queue
					}	

					if (!list.isEmpty()) {
						len = length(list.getLast());	//Get the last element from Fibonacci Serice	
					}

					printFibo(list,input,len);
				}
				else{		//Check for Nagative Input
					throw new IllegalArgumentException();
				}

				System.out.println("Continue(0 -Yes||1 -No)");
        		ans = s.nextInt();
			}
			catch(IllegalArgumentException ie){
				System.out.println(" * Negative values not allowed..!!! ");
				ans = 0;
			}
			catch(Exception e){
				System.out.println(" * Integer Numbers Only..!!");
				ans=0;
			}
		}while(ans == 0);
	}
}