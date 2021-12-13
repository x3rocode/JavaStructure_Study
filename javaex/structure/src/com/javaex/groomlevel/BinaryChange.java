package javaex.structure.src.com.javaex.groomlevel;

import java.util.Scanner;

public class BinaryChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String a = Integer.toBinaryString(num);
        int reuslt = 0;
        for(int i = 0; i < a.length(); i++ )
        {
            if(a.charAt(i) == '1'){
                ++reuslt;
            }
        }
        System.out.printf("%d",reuslt);
        scanner.close();
    }
}
