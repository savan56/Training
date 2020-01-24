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
class Spi{

	/**
	*	This meathod will input the values to the array
	*	in clockwise Manner
	*/
	static void clockwiseArry(int arr[][],int n,int top,int left,int right,int bottom,int count,int direction,int firstL, int bottomRow, int rightCol )throws Exception{

		while(top<=bottom && left<=right){		//This loop will cover all the rows and coloumns

			if (direction == 0) {

				int left_ref = left;		//refrance variable for left value
				int top_copy = top+1;		//refrance variable for top value

				for (int i=0; i< ((2*(n - firstL)) - 1); i++) {		//Loop to add element to the top row and right coloum 
					
					if (left_ref<=right) {		//Add elements to top row	
						arr[top][left_ref]=count;
						count++;
						left_ref++;
					}
					else if(top_copy<=bottom){		//add elements to right coloumn
						
						arr[top_copy][right]=count;
						count++;
						top_copy++;
					}
				}
				firstL += 2;
				direction = 1;
				top++;
				right--;
			}
			
			if (direction == 1) {

				int right_copy = right;		//refrance variable for right value
				int bottom_copy = bottom-1;		//refrance variable for bottom value

				for (int j=((n-bottomRow)+(n-rightCol)); j>0; j--) {		//Loop to add element to the bottom row and left coloum 

						if (right_copy>=left) {		//Add element to bottom row
							arr[bottom][right_copy]=count;
							count++;
							right_copy--;	
						}
						else if(bottom_copy>=top){		//Add element to left coloumn
							arr[bottom_copy][left]=count;
							count++;
							bottom_copy--;
						}
					}
					direction = 0 ;
					bottom--;
					left++;
					bottomRow +=2;
					rightCol +=2;
			}
		}
	}

	/**
	*	This meathod will input the values to the array
	*	in antiClockwise Manner
	*/
	static void antiClockwiseArry(int arr[][],int n,int top,int left,int right,int bottom,int count,int direction,int firstL, int bottomRow, int rightCol )throws Exception{

		while(top<=bottom && left<=right){		//This loop will cover all the rows and coloumns

			if (direction == 0) {

				int right_copy = right;		//refrance variable for right value
				int top_copy = top+1;		//refrance variable for top value
				

				for (int j=((2*(n - firstL)) - 1); j>0; j--) {		//Loop to add element to the top row and left coloum 

						if (right_copy>=left) {		//Add element to top row
							arr[top][right_copy]=count;
							count++;
							right_copy--;	
						}
						else if(top_copy<=bottom){		//Add element to left coloumn
							arr[top_copy][left]=count;
							count++;
							top_copy++;
						}
					}
					direction = 1;
					left++;
					top++;
					firstL += 2;
			}

			if (direction == 1) {

				int left_copy = left;		//refrance variable for left value
				int bottom_copy = bottom-1;		//refrance variable for bottom value

				
				for (int i=0; i< ((n-bottomRow)+(n-rightCol)); i++) {		//Loop to add element to the bottom row and right coloum 
					
					if (left_copy<=right) {		//Add elements to bottom row	

						arr[bottom][left_copy]=count;
						count++;
						left_copy++;
					}
					else if(bottom_copy>=top){		//add elements to right coloumn
						
						arr[bottom_copy][right]=count;
						count++;
						bottom_copy--;
					}
				}
				direction = 0;
				bottom--;
				right--;
				bottomRow +=2;
				rightCol +=2;
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

				int firstL = 0;			// These Variables are used to 
				int bottomRow = 1;		//	manage the For loop 
				int rightCol = 2;		//	iteratios
			
				if(print == 0){	
					clockwiseArry(arr,input,top,left,right,bottom,count,direction,firstL,bottomRow,rightCol);	
				}
				else{
					antiClockwiseArry(arr,input,top,left,right,bottom,count,direction,firstL,bottomRow,rightCol);	
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