package com.javaex.exercise;

import javax.sql.rowset.spi.SyncResolver;

public class Exercise4 {

    public static void main(String[] args) {
        int number = 100;
        int result;

        result = number + 10;

        System.out.printf("덧셈 연산의 결과 - %d\n", result);
        result = number - 10;
        System.out.printf("뺄샘 연산의 결과 - %d\n", result);
        result = number * 10;
        System.out.printf("곱셈 연산의 결과 - %d\n", result);
        result = number / 10;
        System.out.printf("나눗셈 연산의 결과 - %d\n", result);
    }
    
}
