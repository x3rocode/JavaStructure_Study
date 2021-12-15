package com.javaex.firsttest;
import java.util.Arrays;
import java.util.Random;


class Test{

    public int [] data;
    int result = 0;
    
    Test(){
        data = getRandNum();
    }
    public int[] getRandNum(){
        Random rand = new Random();
        int [] data = new int[100];   

        for(int i = 0; i < 99; i++){
            int intValue = (int)(rand.nextInt(200)+1);
            data[i] = intValue;
            for(int j = 0; j < i; j++) 
            { 
                if(data[i]==data[j]) { 
                    i--; 
                    break;
                }
            }
           
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

    public int partition(int[] data, int first, int last) {
		
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

    public int binarySearch(int[] data, int num, int low, int high){
       
        int mid;
		result++;
		if(low <= high) {
			mid = (low + high) / 2;
			if(num == data[mid]) { 
				return mid;
			} else if(num < data[mid]) {
				return binarySearch(data, num ,low, mid - 1);
			} else if(num > data[mid]){
				return binarySearch(data, num, mid + 1, high);
			}
		}
		return -1; 
    }
}

public class RandSortTest {
        public static void main(String[] args) {

        Test test  = new Test();
        System.out.println("정렬 전 : " + Arrays.toString(test.data));
        // test.insertionSort(test.data);
        // test.bubbleSort(test.data);
        test.quickSort(test.data, 0, test.data.length - 1);
        System.out.println( "정렬 후 : " + Arrays.toString(test.data));
        int num = test.binarySearch(test.data, 10, 0, test.data.length);
        if(num == -1)
        {
            System.out.println("없음!");
        }
        else{
            System.out.println( num + 1 + "번째에 있음");
            System.out.println( test.result + "번만에 찾음" );
        }
        
    }
}
