package intro;
import java.util.*;
public class StringArray {
	public static String checkAttendance(String[] name) {
		String temp = "";
		for(int i=0;i<name.length;i++)
			temp = temp.concat("-"+name[i]);
		return temp.substring(1);
	}
	public static String[] makeEach(String attendance) {
		return attendance.split("-");
	}
	public static void main(String[] args) {
		String[] s = {"경영웅","김민우","김현명","김우진"};
		String result = checkAttendance(s);
		System.out.println(result);
		
		String[] each = makeEach(result);
		for(String i: each)
			System.out.println(i);
	}
}