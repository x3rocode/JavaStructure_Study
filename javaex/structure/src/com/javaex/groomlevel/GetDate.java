package com.javaex.groomlevel;

import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class GetDate {
    public static void main(String[] args) throws Exception {
        //int[] num;
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		try{
			LocalDate date = LocalDate.of(2016, a, b);
			DayOfWeek dayOfWeek = date.getDayOfWeek();
			System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());
		}catch(Exception e)
		{
			System.out.println("ERROR");
		}finally {
			scanner.close();
		}
	}
}
