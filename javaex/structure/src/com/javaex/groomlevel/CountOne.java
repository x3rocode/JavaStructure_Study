package javaex.structure.src.com.javaex.groomlevel;

import java.util.Scanner;

public class CountOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int a = Integer.bitCount(num);

        int decimal = Integer.parseInt(Integer.toString(num),16);
        int b = Integer.bitCount(decimal);

        System.out.printf("%d %d",a, b);
        scanner.close();

    }
    
}
