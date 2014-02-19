import java.util.Random;

public class CS430HW3_Quicksort {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program is a quicksort algorithms implementation.");
		System.out.println("A list of random interger numbers will be atuomatic generated.");
		System.out.println("Then quicksort method will be applied to the list.");
		System.out.println("This procedure will be repeated FIVE times with a differnt size of list.");
		System.out.println("List sizes are 2500000,5000000,10000000,20000000,40000000 and 80000000");
		System.out.println("Time will be recorded during sorting process.");
		System.out.println("For a certain size, sorting process will be repeated FIVE times to get the average sorting time.");
		System.out.println("-----------------------------------------------");
	
		
		int initSize = 2500000;
		int size = initSize;
		for (int i = 0 ; i <= 5 ; i ++){
			
			int[] results = randomIntArray(size);
			
			long startTime = System.currentTimeMillis();
			
			quickSort(results,0,size-1);
			
			long endTime = System.currentTimeMillis();

			System.out.println("Array size is: "+size);
			System.out.println("Sorting time is: "+ (endTime-startTime)+ "milliseconds.");
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
	static void quickSort(int[] temp2, int startIndex , int endIndex){
		if (startIndex < endIndex){
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

