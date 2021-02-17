package intro;
class Point{
	private int a;
	private int b;
	public Point(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}
public class ClassFive {

	public static void main(String[] args) {
		Point p  = new Point(1,2);
		Point p2 = new Point(1,2);
		paint(p);
		paint(p2);
		
	}
	public static void paint(Object obj) {
		System.out.println(obj.getClass().getName());
	}
}