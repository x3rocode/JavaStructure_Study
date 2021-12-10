package javaex.structure.src.com.javaex.firsttest;
abstract public class Memory {
    protected int[] array = new int[5];
    protected int pivot=0;
    abstract void push(int num);
    abstract int pop();
 }