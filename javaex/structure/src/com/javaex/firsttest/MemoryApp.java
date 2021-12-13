package javaex.structure.src.com.javaex.firsttest;

import java.util.Scanner;

public class MemoryApp {

   public static void main(String[] args) {
      Memory mq = new MyQueue();
      Memory ms = new MyStack();
      
      Scanner sc = new Scanner(System.in);
      
      while(true) {
         
         System.out.println("1번 스택  2번 큐  3번 break");
         
         int num = sc.nextInt();
         
         // Stack
         if(num == 1) {
            while(true) {
               System.out.println("1. Push  2. Pop  3. break");
               sc = new Scanner(System.in);
               int num2 = sc.nextInt();
               
               if(num2 == 1) {
                  sc = new Scanner(System.in);
                  System.out.println("수를 입력하세요.");
                  int input_num = sc.nextInt();
                  
                  ms.push(input_num);
               } else if (num2 == 2) {
                  ms.pop();
                  break;
               } else {
                  break;
               }
               sc.close();
            }
            
         } else if(num == 2) { // Queue
            while(true) {
               System.out.println("1. Push  2. Pop  3. break");
               sc = new Scanner(System.in);
               int num2 = sc.nextInt();
               
               if(num2 == 1) {
                  sc = new Scanner(System.in);
                  System.out.println("수를 입력하세요.");
                  int input_num = sc.nextInt();
                  
                  mq.push(input_num);
                  sc.close();
               } else if (num2 == 2) {
                  mq.pop();
                  break;
               } else {
                  break;
               }
            }
         } else {
            //return;
         }
         sc.close();
      }
     
   }

}