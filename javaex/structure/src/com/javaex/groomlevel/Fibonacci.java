package javaex.structure.src.com.javaex.groomlevel;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hap = 0;
        int a = scanner.nextInt();
		for (int i = 1; i <= a; i++) {
			hap += fibo(i);
		}
        System.out.println(hap);
        scanner.close();

    }

    public static int fibo(int n) {
		if (n <= 1){
            return n;
        }else{
            return fibo(n-2) + fibo(n-1);
        } 
	}   
}
