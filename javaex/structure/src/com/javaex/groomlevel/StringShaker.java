package javaex.structure.src.com.javaex.groomlevel;
import java.util.Scanner;

public class StringShaker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		int length = input.length();
		
		String result = "";

		for (int i = 0; i < length; i++) {
			int j = (length - 1) - i;
			if (i < j) {
				
				char front = input.charAt(i);
				char back = input.charAt(j);

				result += front + "" + back + "";
			}

			else if (i == j) {
				char current = input.charAt(i);
				result += current + "";
			}
			else {
				break;
			}
		}

		System.out.println(result);
    }
    
}
