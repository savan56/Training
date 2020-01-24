import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
* 	The Insert class Perform Insertion Sort On Array...
*/
class Ins{


	/**
	*	This meathod will Sort the array 
	*/
	static void sort(List list){ 
        for(int element=1;element<list.size();element++){
            
            int key = (int)list.get(element);
            
            for(int element2= element-1; element2>=0; element2--){
                if(key<(int)list.get(element2)){
                    
                    list.set(element2+1,list.get(element2));		/* Shifting Each Element to its right as key is 
                    									less than the existing element at current index */
                    
                    
                    if(element2==0){			// Special case scenario when all elements are less than key,so placing key value at 0th Position 
                        list.set(0, key);				 
                    }
                }else{
                    
                    list.set(element2+1,key);				/* Putting Key value after element at current index as Key
                    								   value is no more less than the existing element at current index */

                    break;			// You need to break the loop to save un necessary iteration
                }
            }
        }
	}

	/**
	*	This meathod will Insert The Element In Array At Perticuler Positon
	*/
	static void addNumber(List list,int number,int insposition){
		System.out.println("addNumber Meathod");
	
		list.add(insposition-1,number);
	}

	/**
	*	This meathod will delete The Element In Array From a Perticuler Positon
	*/
	static void delNumber(List list,int delposition){
		System.out.println("in delNumber");

		list.remove(delposition-1);
	}

	/**
	*	This is the Utility Meathod to print the array
	*/
	static void print(List list){

		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println(" ");

	}

	/**
	*	This is The mani Meathod Program Executio Starts From here....
	*/
	public static void main(String[] args) {

			boolean done = false;
		do{
			try{

				List<Integer> list = new ArrayList<Integer>();		//Defalut list Initliztoin 
				list.add(1);
				list.add(9);
				list.add(5);
				list.add(1);
				list.add(3);
				list.add(7);
				list.add(8);
				list.add(6);

				Scanner s = new Scanner(System.in);		//Scanner Clsaa Object

				System.out.println("Enter :-\n 1. Print List\n 2. Add Element\n 3. Remove Element\n 4. Insertion Sort\n 5. Exit");

				int input = s.nextInt();		//get the user input for Array size

				switch(input)
				{
					// Case 1 : To printing the List 
					case 1:											
						System.out.println("The Default List:");
						print(list);
						break;

					//Case 2 : To Add Element To the list
					case 2:
						System.out.println("Enter Number To Insert:");	

						int number = s.nextInt();		//element to insert exixsting array
						
						System.out.println("Enter Position For Insertion:");	

						int insposition = s.nextInt();		//position to insert element in exixsting array

						addNumber(list,number,insposition);

						System.out.println("List After Element inserted:");

						print(list);	

						sort(list);

						System.out.println("Sorted List After Element inserted:");

						print(list);
						break;

					//Case 3 : To Remove Element From The List
					case 3:
						System.out.println("Enter Position To Delete Element:");	

						int delposition = s.nextInt();		//position from delete element in exixsting array

						System.out.println("List before Deletion:");

						print(list);	

						delNumber(list,delposition);

						System.out.println("List After Deletion:");

						print(list);

						sort(list);

						System.out.println("Sorted List After Deletion:");

						print(list);
						break;

					//Case 4 : To Perform The Insertion operation
					case 4:
						sort(list);
						System.out.println("List After Insertion Sort Performed");
						print(list);
						break;	

					//Case 5 : To Get Out Of TheLoop Of Code Execution
					case 5:
						done = true;
						break;	

					//Defalut Case To Manage User Input
					default:
						System.out.println("Please Selct Apropriat Option");		
						break;
				}
			}
			catch(Exception e){
				System.out.println(" * Positive Integer Numbers Only..!!");
			}
		}while(!done);
		
	}
}