package com.javaex.firsttest;

public class First {
    
    private int a;
    private int b;
    public static void main(String[] args) {
        First aa = new First();
        First bb = new First(10);
        First cc = new First(20, 30);

        System.out.println(aa.getA()+"\t" + aa.getB());  //0,0
        System.out.println(bb.getA()+"\t" + bb.getB());  //10,0
        System.out.println(cc.getA()+"\t" + cc.getB()); //20, 3
    }

    First(){
        a = b = 0;
        //this(a,0);
    }

    First(int a){
        this.a = a;
        b = 0;
        // this(a,0);
       
    }

    First(int a, int b){
        this.a = a;
        this.b = b;
    }

    int getA(){
        return this.a;
    }

    int getB(){
        return this.b;
    
    }
    
}
