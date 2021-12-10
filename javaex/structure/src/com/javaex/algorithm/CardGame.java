package javaex.structure.src.com.javaex.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

    static ArrayList<Integer> data = new ArrayList<Integer>();
    static ArrayList<Integer> front = new ArrayList<Integer>();
    static ArrayList<Integer> back = new ArrayList<Integer>();
    final static int MAX = 9;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose = 1;
        while(choose == 1){
            selectCart();
            sort();
            split();
            System.out.println(data);
            System.out.println(front);
            System.out.println(back);
            if(isBabyGin())
            {
                System.out.println("BABYGIN!!!");
                System.out.print("Try Again? 1 yes 2 no : ");
                choose = scanner.nextInt();
            }
            else{
                System.out.println("LOSE..");
                System.out.print("Try Again? 1 yes 2 no : ");
                choose = scanner.nextInt();
            }
            data.clear();
            front.clear();
            back.clear();
        }

        scanner.close();
        
    }

    public static void selectCart(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input 6 Numbers! : ");
        int a = scanner.nextInt();
        splitNum(a);
       
    }

    public static void splitNum(int a){
        String strNum = Integer.toString(a); 
        for (int i = 0; i < strNum.length(); i++) 
        { 
            if(strNum.length() > MAX){
                System.out.println("0~9사이 숫자만 입력");
                break;
            }
            data.add(strNum.charAt(i) - '0');
            //System.out.println(data.get(i));
           
        }
    }

    public static boolean isBabyGin(){
        int a = 0;
        if(isTriple(front))
        {
            if(isTriple(back))
            {
                a++;
            }
            a++;
        }
        if(isRun(front))
        {
            if(isRun(back))
            {
                a++;
            }
            a++;
        }

        if(a >= 2)
        {
            return true;
        }
        return false;
    }

    public static void split(){
        for(int i = 0; i < 6; i ++)
        {
            if(i <= 2){
                front.add(data.get(i));
            }else{
                back.add(data.get(i));
            }
        }
    }

    public static boolean isRun(ArrayList<Integer> arr){
        int a = 0;
        for(int i = 0; i < 2; i ++)
        {
            if(arr.get(i) + 1 == arr.get(i + 1))
            {
                a++;
            }
        }
        if(a == 2)
        {
            System.out.println("연속");
            System.out.println(arr);
            return true;
           
        }
        return false;
    } 

    public static boolean isTriple(ArrayList<Integer> arr){
        int a = 0;
        for(int i = 0; i < 2; i ++)
        {
            if(arr.get(i) == arr.get(i + 1))
            {
                a++;
            }
        }
        if(a == 2)
        {
            System.out.println("동일");
            System.out.println(arr);
            return true;
        }
        return false;
    }

    public static void sort(){
        int tmp;
        for(int i = 0; i<data.size(); i++) 
        {
             for(int j = i+1; j<data.size(); j++) 
             { 
                if(data.get(i) > data.get(j)) { 
                    tmp = data.get(i);
                    data.set(i,data.get(j)); 
                    data.set(j, tmp); 
                } 
            } 
        } 

    }
    
}
