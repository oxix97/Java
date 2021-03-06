public class Checkable {

    public void checkCompareTo() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "c";

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str2.compareTo(str1));
    }

    public void checkCompare() {
        String str1 = "Check";
        String str2 = new String("Check");

        if(str1 == str2) System.out.println("str1 == str2");
        else System.out.println("str1 != str2");

        if(str1.equals(str2)) System.out.println("str1.equals str2");
        else System.out.println("!str1.equals str2");
    }

    public static void main(String[] args) {
        Checkable checkable = new Checkable();
        checkable.checkCompareTo();
    }
}