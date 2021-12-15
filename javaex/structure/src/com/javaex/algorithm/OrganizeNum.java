package com.javaex.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganizeNum {

    final static int MAX = 9999999;
    final static int MIN = 100;
    static int count;
    static ArrayList<Integer> data = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input X num : ");
		int x = scanner.nextInt();
        System.out.print("Input Y num : ");
        int y = scanner.nextInt();

        if(isInRange(x, y)){
            for(int i = x; i <= y; i++)
            {
                if(checkisOrganized(i)){
                    data.add(i);
                    count ++;
                }
            }
        }

        System.out.println(data);
        System.out.println("count : " + count);
        scanner.close();
        
    }
    public static boolean checkisOrganized(int x){
        String strNum = Integer.toString(x); 
        //ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < strNum.length() -1; i++) 
        { 
            if(strNum.charAt(i) - '0' >= strNum.charAt(i+1) - '0')
            {
                return false;
            }
        }
        return true;
    }


    
    public static boolean isInRange(int x, int y){
        if(x < MIN || x > MAX || y < x || y > MAX)
        {
            System.err.println("다시입력");
            return false;
        }
        return true;
    }
}
