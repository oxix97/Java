package intro;

public class nubmerS {
	public static int count(String a) {
		int ans = 0;
		for(int i=0;i<a.length();i++)
			if(a.substring(i,i+1).equals("s"))
				ans++;
		return ans;
	}
	public static void main(String[] args) {
		String a = "cl,as,s";
		int cont = count(a);
		System.out.println(cont);
		
		String c1 = new String("C#");
		String c2 = new String("C + + ");
		
		System.out.println(c1.concat(c2)); // concat 문자 병합  
		System.out.println(c2.trim()); //trim 공백문자 제거
		
		String[] s = a.split(",");
		for(int i=0;i<s.length;i++)
			System.out.println(s[i]);
	}
}
