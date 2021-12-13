package javaex.structure.src.com.javaex.groomlevel;
import java.util.Scanner;

public class OddorEven {
    public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		
		if(a % 2 == 1)
		{
			System.out.println("odd");
		}
		else if(a % 2 == 0)
		{
			System.out.println("even");
		}
        scanner.close();

	}
}
