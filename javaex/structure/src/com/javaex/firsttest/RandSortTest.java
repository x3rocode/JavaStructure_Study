package javaex.structure.src.com.javaex.firsttest;
import java.util.Arrays;
import java.util.Random;


class Test{

    public int [] data;
    

    Test(){
        data = getRandNum();
    }
    public int[] getRandNum(){
        Random rand = new Random();
        int [] data = new int[100];   

        for(int i = 0; i < 99; i++){
            int intValue = (int)(rand.nextInt(100)+1);
            data[i] = intValue;
        }
        return data;
    }

    public void insertionSort(int[]data)
    {
        for(int i = 1; i < data.length; i ++)
        {
            int val = data[i];
            int j = i - 1;

            while(j >= 0 && val < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j +  1] = val;
        }
        System.out.println("insertion sort : " + Arrays.toString(data));
    }

    public void quickSort(int[]data, int low, int high)
    {
        if(low >= high) {
			return;
		}
		
		int pivot = partition(data, low, high);	
		quickSort(data, low, pivot - 1);
		quickSort(data, pivot + 1, high);
        System.out.println("quick sort : " + Arrays.toString(data));
    }

    public void bubbleSort(int[]data)
    {   
        for(int i = 1; i < data.length; i++) {
			boolean isswapped = false;	

			for(int j = 0; j < data.length - i; j++) {
				if(data[j] > data [j + 1]) {
					swap(data, j, j + 1);
					isswapped = true;
				}
			}
			if(isswapped == false) {
				break;
			}
		}
        System.out.println("bubble sort : " + Arrays.toString(data));
    }
    
    public void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private int partition(int[] data, int first, int last) {
		
		int low = first;
		int high = last;
		int pivot = data[first];

		while(low < high) {
			while(data[high] > pivot && low < high) {
				high--;
			}
			while(data[low] <= pivot && low < high) {
				low++;
			}
            if(low < high){
                swap(data, low, high);
            }

		}
		
		swap(data, first, low);
		return low;
	}
}

public class RandSortTest {
        public static void main(String[] args) {

        Test test  = new Test();
        System.out.println("val arr : " + Arrays.toString(test.data));
        test.insertionSort(test.data);
        test.bubbleSort(test.data);
        test.quickSort(test.data, 0, test.data.length - 1);
    }
}
