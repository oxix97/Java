package intro;
import java.lang.Character.Subset;
import java.util.*;
class Subject{
	private String s_name;
	private String grade;
	int point;
	public Subject(String s_name, int point) {
		super();
		this.s_name = s_name;
		this.point = point;
	}
	public String getGrade() {
		if(point >=80 && point <=100) return "A+";
		else if(point>=60 && point<80) return "A";
		else return "B";
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
class Student{
	private String name;
	private int s_num;
	public Student(String name, int s_num) {
		super();
		this.name = name;
		this.s_num = s_num;
	}
}
public class Study {
	public static void main(String[] args) {
		Student s = new Student("LEE",201655040);
		Subject sub = new Subject("객체",100);
	}
}
