package javaex.structure.src.com.javaex.firsttest;

import java.io.PushbackReader;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.print.attribute.standard.PrinterInfo;

public class MyQueue extends Memory{  //extends memory
    int front;
    

    public boolean isEmpty() {
        return front == pivot;
    }


    public boolean isFull() {  
        System.out.println(pivot);
        System.out.println(array.length);
        if(pivot == array.length) {
            return true;
        }else 
            return false;
    }
    public int size() { 
        return front-pivot;
    }

    public void shift(){
        for(int i = front; i < array.length; i++){
            array[i-1] = array[i]; 
            array[i] = 0;
        }
        front--;
        pivot--;
    }

    public void push(int value) {
        if(isFull() && front == 0) {
            System.out.println("Queue is Full");
           
        }
        else if(isFull() & front != 0)
        {
            shift();
            array[pivot++] = value;
        }
        else{
            array[pivot++] = value;
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        System.out.println(front);
        array[front] = 0;
        int popValue = array[front++];
        
  
        return popValue;
    }
}
