package intro;
import java.util.*;
public class overroading {
	static String printString(String input, int n) {
		return input.substring(n);
	}
	static String printString(String input,int x, int y) {
		return input.substring(x,y);
	}
	public static void main(String[] args) {
		String input = "YOU KNOW I CAN PAINT THE WORLD";
		System.out.println(printString(input,10));
		System.out.println(printString(input,5,10));
	}
}
