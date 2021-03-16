package intro;

public class CommonMethod {
	static void check(Person p) {
		boolean adult = false;
		if(p.country.equals(Constant.USA)) {
			if(p.age >= Constant.hold_USA)
				adult = true;
		}
		else if(p.country.equals(Constant.KOR)) {
			if(p.age>=Constant.hold_KOR)
				adult = true;
		}
		if(adult) System.out.println("adult");
		else System.out.println("not adult");
	}
}
