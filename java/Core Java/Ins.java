import java.util.*;

/**
* 	The Insert class Perform Insertion Sort On Array...
*/
class Ins{


	/**
	*	This meathod will Sort the array 
	*/
	static void sort(List list){ 
        for(int i=1;i<list.size();i++){
            
            int key = (int)list.get(i);
            
            for(int j= i-1;j>=0;j--){
                if(key<(int)list.get(j)){
                    
                    list.set(j+1,list.get(j));		/* Shifting Each Element to its right as key is 
                    									less than the existing element at current index */
                    
                    
                    if(j==0){			// Special case scenario when all elements are less than key,so placing key value at 0th Position 
                        list.set(0, key);				 
                    }
                }else{
                    
                    list.set(j+1,key);				/* Putting Key value after element at current index as Key
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

	public static void main(String[] args) {
		try{
				boolean done = false;
			do{

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

				int n = s.nextInt();		//get the user input for Array size

				switch(n)
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
			}while(!done);
		}
		catch(Exception e){
			System.out.println(" * Numbers Input Only");
			e.printStackTrace();
		}
	}
}