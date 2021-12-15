package com.javaex.groomlevel;

import java.util.Scanner;

public class BunhaeHap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;
        
        for(int i = 0; i < N; i++) {
            int number = i;
            int sum = 0;
            
            while(number != 0) {
                sum += number % 10;	
                number /= 10;
            }
    
            if(sum + i == N) {
                result = i;
                break;
            }
        }	
        System.out.println(result);	
        scanner.close();

    }
}
