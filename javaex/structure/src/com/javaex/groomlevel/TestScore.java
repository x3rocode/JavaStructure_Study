package javaex.structure.src.com.javaex.groomlevel;

import java.util.Scanner;

public class TestScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String score = scanner.next();
        int result = 0;
        int hap = 0;

        for(int i = 0; i < score.length(); i ++)
        {
            if(score.charAt(i) == 'o')
            {
                hap += ++result;
            }
            else{
                result = 0;
            }
        }

        System.out.println(hap);
        scanner.close();
    }
    
}
