package javaex.structure.src.com.javaex.groomlevel;
import java.util.Scanner;

public class Bracket {
    public static void main(String[] args) {
        int num_big_left=0;
        int num_big_right=0;
        int num_middle_left=0;
        int num_middle_right=0;
        int num_small_left=0;
        int num_small_right=0;
        Scanner scan = new Scanner(System.in);
        String str=scan.next();
        char[] char_arr = new char[str.length()];
        for(int i=0;i<str.length();i++){
            switch(str.charAt(i)){
                case '{': num_big_left+=1;
                    break;
                case '}': num_big_right+=1;
                    break;
                case '[': num_middle_left+=1;
                    break;
                case ']': num_middle_right+=1;
                    break;
                case '(': num_small_left+=1;
                    break;
                case ')': num_small_right+=1;
                    break;
            }
        }
        if((num_big_left==num_big_right)&&(num_middle_left==num_middle_right)&&(num_small_left==num_small_right)){
            System.out.println("통과");
        }else{
            System.out.println("불합격");
        }
    }
}
