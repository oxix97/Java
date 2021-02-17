package intro;
class Person{
	int age;
	String country;
	public Person(int age, String country) {
		this.age = age;
		this.country = country;
	}
}
public class Class_One {
	public static void main(String[] args) {
		System.out.println("Message Out Java Program");
		Person p = new Person(20,"USA");
		CommonMethod.check(p);
	}
}