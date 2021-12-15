package com.javaex.firsttest;

import java.util.Arrays;


public class BubbleSort {
    public static void main(String[] args) {
        int data[] = {90, 78, 100, 30, 55};
        sort(data);
    }

    public static void sort(int[]data)
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
        System.out.println(Arrays.toString(data));
    }
    
    public static void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
