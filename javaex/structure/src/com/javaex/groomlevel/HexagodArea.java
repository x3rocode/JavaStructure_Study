package javaex.structure.src.com.javaex.groomlevel;

import java.util.Scanner;

public class HexagodArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();

        float a = (float)Math.sqrt(3);
        float b = (float)Math.pow(r, 2);
        float result = (3 * a * b) / 2;

        String s = String.format("%.2f", result); 
        System.out.println(s);
        scanner.close();

    }
    
}
