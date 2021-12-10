package javaex.structure.src.com.javaex.firsttest;

public class MyStack extends Memory {


    @Override
    public void push(int num) {
        if (pivot == array.length ) {
            isFull();
        } else {
            array[pivot] = num;
            pivot++;
        }
    }
    
    @Override
    public int pop() {
        if (pivot <= 0) {
            isEmpty();
        } else {
            System.out.println("배열 값 추출:" + array[—pivot]); // 마지막 값 추출
            array[pivot] = 0; // 추출한 곳 0으로 초기화
        }
    
    }
    
    protected void isFull() {
        System.out.println("Array is full");
    
    }
    protected void isEmpty() {
        System.out.println("Array is empty");
    }
    
    
    }