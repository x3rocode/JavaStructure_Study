package com.javaex.groomlevel;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        int count = 0;					// 입력받을 숫자의 개수 
		int[] num;						// 입력받을 숫자 
		//int numMax = 0;					// 최대값 
        int start = 0;
        int end = 0;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
		// 입력받을 숫자 개수 입력받기
		count = scanner.nextInt();
		num = new int[count];	

		for (int i = 0 ; i < count ; i++) {
			num[i] = scanner.nextInt();		
		}

		start = scanner.nextInt();
        end = scanner.nextInt();

        for (int i = start ; i <= end ; i++){
				sum += num[i-1];
		}
		

        System.out.println(sum);
        scanner.close();

	}
    
}
