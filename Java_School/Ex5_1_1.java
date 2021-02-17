package intro;

public class Ex5_1_1 {
	public static void main(String[] args) {
		int cntDivisorsOf100 = 0;
		for(int i=1;i<=100;i++)
			if(100%i==0)
				cntDivisorsOf100++;
		System.out.println("\n *"+100+"의 약수 개수: "+cntDivisorsOf100);
		int cntDivisorsOf1237 = 0;
		for(int i=1;i<=1237;i++)
			if(1237%i==0)
				cntDivisorsOf1237++;
		if(cntDivisorsOf1237==2)
			System.out.println("\n *"+1237+": 소수");
		else
			System.out.println("\n *"+1237+": 소수아님");
	}
}
