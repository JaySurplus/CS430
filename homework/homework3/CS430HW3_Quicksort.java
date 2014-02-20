import java.util.*;
public class CS430HW3_Quicksort {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program is a quicksort algorithms implementation.");
		System.out.println("A list of random interger numbers will be atuomatic generated.");
		System.out.println("Then quicksort method will be applied to the list.");
		System.out.println("This procedure will be repeated FIVE times with a differnt size of list.");
		System.out.println("User assign an inital size value, then this size will be enlarged 2 times for each loop.");
		System.out.println("Time will be recorded during sorting process.");
		System.out.println("-----------------------------------------------");
	
		System.out.println("Please enten an initial size value (recommend 2500000):");
		Scanner in = new Scanner(System.in);

		int initSize = in.nextInt(); // This is the place you choose an initial size.
		int size = initSize;
		for (int i = 0 ; i <= 5 ; i++){
			
			int[] results = randomIntArray(size);
			
			long startTime = System.currentTimeMillis();
			//Quick Sort
			quickSort(results,0,size-1);
				
			long endTime = System.currentTimeMillis();

			System.out.println("Array size is: "+size);
			System.out.println("Sorting time is: "+ (endTime-startTime)+ " milliseconds.");
			System.out.println();
			size = size*2;
		}
	}
	
	//Instance method to  
	static int[] randomIntArray(int arrayLength){
		//Random rand = new Random();
		int[] array = new int[arrayLength];
		for (int k =0; k<arrayLength ;k++){
			array[k] =(int) (Math.random()*arrayLength);
			//System.out.println(array[i]);               //To test whether the randomIntArray() method working or not.
		}
		return array;
	}
	
	//Implement quicksort
	static void quickSort(int[] temp, int startIndex , int endIndex){
		if (startIndex < endIndex){
			int[] temp2 = temp;
			int q = partition(temp2, startIndex, endIndex);
			quickSort(temp2,startIndex,q-1);
			quickSort(temp2,q+1,endIndex);
		}
	}
	
	//Implement partition
	static int partition(int[] array, int startIndex, int endIndex){
		int x = array[endIndex];
		int i = startIndex - 1;
		for (int j = startIndex ; j < endIndex ; j++ ){
			if (array[j] < x ){
				i ++ ;
				//Switch array[i] with array[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			
			
		}
		//Switch array[i+1] with array[endIndex]
		int temp = array[i+1];
		array[i+1] = array[endIndex] ;
		array[endIndex] = temp ;
		return i+1;
	}

}

