package intro;
import java.util.*;
public class biggestNum {
	public static int maxx(int[] arr) {
		int max = 0;
		for(int i=0;i<arr.length;i++)
			if(max<=arr[i]) max = arr[i];
		return max;
	}
	static int getMax(int a,int b,int c) {
		int max = a>b ? a:b;
		max = max>c ? max : c;
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {3,5,1};
		int a = 3;
		int b = 5;
		int c = 1;
		System.out.println(maxx(arr)); //Arrays.sort(arr)가 더 나음
		System.out.println(getMax(a,b,c));
	}
}
