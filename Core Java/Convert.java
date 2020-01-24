import java.util.Scanner;

/**
*	This Class Converter will Convert Decimal Number To nay Base number...
*/
class Convert{

	/**
	*	This meathod will Perform Conversion Operation
	*/
	static String numberConverter(double num, int base, int num_of_digit){

		String sub = "";		//Empty String to Store The results

		int decimalNumber = (int)num;		// Fetch the integral part of decimal number

		double fractional = num - decimalNumber;  	// Fetch the fractional part decimal number 

		while( decimalNumber > 0){

			sub += resultnum(decimalNumber % base);
			decimalNumber = decimalNumber/base;
		}

		StringBuilder sb = new StringBuilder();		//String Builder Object Creation

		sb.append(sub);		//Store result To StingBuilder

		sb.reverse();		//reverse String And Return

		String result = sb.toString();		//initlize The Integral Part of the output

		result += ('.');		// Append point before appending fractional part 

		while (num_of_digit >= 0) 
		{ 
			num_of_digit--;
			
			fractional *= base; 		// Find next bit in fraction 
			int fract_element = (int) fractional; 

			result += resultnum(fract_element);
		}

		return result;
	}

	/**
	*	This is the Utility Meathod To Deside The number or Alphabat
	*	 for The resultent number
	*/
	static char resultnum(int num){

		if(num>=0 && num<=9){
			return (char)(num+48);
		}
		else{
			return (char)(num - 10 + 65);
		}
	}

	/**
	*	This is The mani Meathod Program Executio Starts From here....
	*/
	public static void main(String[] args) {
		int ans;
		do{
			try{
				Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

				System.out.println("Enter Decimal Number:");	

				double decimalNumber = s.nextDouble();		//get the user input for Decimal Number

				System.out.println("Enter Base To Convert:");	

				int base = s.nextInt();		//get the user input for base to convert number

				System.out.println("Enter Number Of Element Expected After '.':");	

				int num_of_digit = s.nextInt();		//get the user input for Element Expected After '.'

				System.out.println("The Converted Number with Base "+"'"+base+"'"+" is "+numberConverter(decimalNumber,base,num_of_digit));

				System.out.println("Continue(0 -Yes||1 -No)");
        		ans = s.nextInt();
			}
			catch(Exception e){
				System.out.println(" * Positive Integer Numbers Only..!!");
				ans = 0;
			}
		}while(ans == 0);
	}

}