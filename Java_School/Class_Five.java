package intro;

public class Class_Five {

	public static void main(String[] args) {
		String a = new String("Chan");
		System.out.println(compareString(a));
	}
	public static boolean compareString(String a) { // String.equals를 써야하는 이유
		if(a=="Chan") return true;
		else return false;
	}
}
