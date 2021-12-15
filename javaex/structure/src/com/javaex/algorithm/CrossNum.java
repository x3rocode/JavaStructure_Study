package com.javaex.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class CrossNum {

    static ArrayList<Integer> data = new ArrayList<Integer>();
    public static void main(String[] args) {
               ArrayList<String> a = new ArrayList<>();
        a.add("dfdf");
        a.add("dddd");

        System.out.println(a.toString());
        //printResult();
    }

    public static String makeMin(int a){
       splitNum(a);
       sort();
       checkFirstisZero();
       String result = "";

       for (int i = 0; i < data.size(); i++) 
       { 
           result += data.get(i);
       }
       data.clear();
       return result;
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

    public static void checkFirstisZero(){
        int num = 0;
        if(data.get(0) == 0)
            {
                for(int j = 0; j < data.size(); j++)
                {
                    if(data.get(j) != 0)
                    {
                        num = j;
                        break;
                    }
                }
                Collections.swap(data, 0, num);

            }

    }

    public static void splitNum(int a){
        String strNum = Integer.toString(a); 
        for (int i = 0; i < strNum.length(); i++) 
        { 
            data.add(strNum.charAt(i) - '0');
            //System.out.println(data.get(i));
        }
    }

    public static void printResult(){
        for(int i = 1000; i <= 9999; i++)
        {
            String result = makeMin(i);
            System.out.printf("%d\t%s\n",i, result);
        }
    }
    
}

