import java.util.Scanner;

/**
* 	The Spiral class provides Output as per bellow...
*	if the user puts in 5 it will display pattern as follows:
*	1  2  3  4  5
*	16 17 18 19 6
*	15 24 25 20 7
*	14 23 22 21 8
*	13 12 11 10 9
*/
class Spiral{

	/**
	*	This meathod will input the values to the array
	*	in clockwise Manner
	*/
	static void clockwiseArry(int arr[][],int n,int top,int left,int right,int bottom,int count,int direction )throws Exception{

		while(top<=bottom && left<=right){
			if (direction == 0) {
				for (int i=left; i<=right; i++) {
					arr[top][i] = count;
					count++;
				}
				direction = 1;
				top++;
			}

			if (direction == 1) {
				for (int j=top; j<=bottom; j++) {
					arr[j][right] = count;
					count++;
				}
				direction = 2;
				right--;
			}
			
			if (direction == 2) {
				for (int k=right; k>=left; k--) {
					arr[bottom][k]=count;
					count++;
				}
				direction = 3;
				bottom--;
			}

			if (direction == 3) {
				for (int m=bottom; m>=top; m--) {
					arr[m][left]=count;
					count++;
				}
				direction = 0;
				left++;
			}
		}
	}

	/**
	*	This meathod will input the values to the array
	*	in antiClockwise Manner
	*/
	static void antiClockwiseArry(int arr[][],int n,int top,int left,int right,int bottom,int count,int direction )throws Exception{

		while(top<=bottom && left<=right){
			if (direction == 0) {
				for (int i=right; i>=left; i--) {
					arr[top][i] = count;
					count++;
				}
				direction = 1;
				top++;
			}

			if (direction == 1) {
				for (int j=top; j<=bottom; j++) {
					arr[j][left] = count;
					count++;
				}
				direction = 2;
				left++;
			}

			if (direction == 2) {
				for (int k=left; k<=right; k++) {
					arr[bottom][k]=count;
					count++;
				}
				direction = 3;
				bottom--;
			}

			if (direction == 3) {
				for (int m=bottom; m>=top; m--) {
					arr[m][right]=count;
					count++;
				}
				direction = 0;
				right--;
			}
		}
	}


	/**
	*	This is the Utility Meathod to print the array
	*/
	static void printArray(int arr[][], int n){

		for (int j=0; j<n; j++) {
			for (int k=0; k<n; k++) {
				int max = length(n*n);		//max represent length of biggest element of matrix
				int len = length(arr[j][k]);		//len represent element length
				int space = max - len;		//count required space for element

				while(space > 0){		//add requre spaces to element
					System.out.print(" ");
					space--;
				}
				System.out.print(arr[j][k]+"  ");
			}
			System.out.println();
		}
	}

	/**
	*	This meathod will return lent of int Number
	*/
	static int length(int num){
		int count = (int)(Math.log10(num)+1);	//To remove loop for more optimal form
		return count;
	}

	/**
	*	This is The mani Meathod Program Executio Starts From here....
	*/
	public static void main(String[] args) {

			try{

				Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

				System.out.println("Enter Number:");	

				int input = s.nextInt();		//get the user input for array size

				if (input < 0) {		//Check for Nagative Input
					throw new IllegalArgumentException();
				}

				System.out.println("Enter values to print array in perticuler Manner");	

				System.out.println("0 -clockWise || 1 -antiClockWise");

				int print = s.nextInt();		//get the user input for array printing

				if (print < 0) {		//Check for Nagative Input
					throw new IllegalArgumentException();
				}

				int[][] arr = new int[input][input]; //2D-Array to Store And display Values

				int count = 1;		//to generate numbers for array input
				int top=0,			
					left=0,			
					right=input-1,		
					bottom=input-1;		

				int direction = 0;		/** Directions: 0 right
											    		1 down
											    		2 left
											    		3 top    */

			
				if(print == 0){	
					clockwiseArry(arr,input,top,left,right,bottom,count,direction);	
				}
				else{
					antiClockwiseArry(arr,input,top,left,right,bottom,count,direction);	
				}	


				printArray(arr,input);
			}	
			catch(IllegalArgumentException ie){
				System.out.println(" * Negative values not allowed..!!! ");
				main(null);
			}
			catch(Exception e){
				System.out.println(" * Positive Integer Numbers Only..!!");
				main(null);
			}
	}
}