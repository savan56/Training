import java.util.*;

/**
*	This Class Converter will Convert Decimal Number To nay Base number...
*/
class Convert{

	/**
	*	This meathod will Perform Conversion Operation
	*/
	static String numberConverter(int decimalNumber, int base){

		String s = "";		//Empty String to Store The results

		while( decimalNumber > 0){

			s += resultnum(decimalNumber % base);
			decimalNumber = decimalNumber/base;
		}

		StringBuilder sb = new StringBuilder();

		sb.append(s);

		return new String (sb.reverse());
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
		Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

		System.out.println("Enter Decimal Number:");	

		int decimalNumber = s.nextInt();		//get the user input for Decimal Number

		System.out.println("Enter Base To Convert:");	

		int base = s.nextInt();		//get the user input for base to convert number

		System.out.println("The Converted Number with Base "+"'"+base+"'"+" is "+numberConverter(decimalNumber,base));
	}

}