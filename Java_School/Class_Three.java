package intro;

public class Class_Three {
	public static void main(String[] args) {
		C c = new C();
		B b = new B(1);
	}
}
class A{
	int a;
	public A(int a) {
		super();
		this.a = a++;
		System.out.println("Class A"+a);
	}
	public A() {
		System.out.println("Class A");
	}
}
class B extends A{
	public B() {
		System.out.println("Class B");
	}
	public B(int a) {
		super(a);
		System.out.println("Class B"+a);
	}
}
class C extends B{
	public C() {
		System.out.println("Class C");
	}
}