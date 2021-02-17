package intro;
import java.util.*;
public class ValuePassing {
	public static int[] makeArray(int n) {
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = i+1;
		return arr;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int n = scan.nextInt();
		int[] arr = makeArray(n);
		for(int i: arr)
			System.out.println(i);
		for(int i=1;i<=n;i++)
			list.add(i);
		System.out.println();
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
}
