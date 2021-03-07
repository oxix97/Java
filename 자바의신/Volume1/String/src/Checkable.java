public class Checkable {

    public static void main(String[] args) {
        Checkable checkable = new Checkable();
        checkable.checkReplace();
    }

    public void checkReplace() {
        String str = "You know I can paint the world sitting there in black and gold";

        System.out.println(str.replace('a','A')); // 1
        System.out.println(str.replace("You","WE")); // 2
        System.out.println(str.replaceAll(" ","/")); // 3
        System.out.println(str.replaceFirst(" ","/")); //4
    }
    public void checkTrim() {
        String[] strs = {" a", "b ", "  ,", "  c", "d    "};

        for (String str : strs) {
            System.out.println("[" + str.trim() + "] ");
        }
    }

    public void checkSplit() {
        String str = "You know I can paint the world sitting there in black and gold";
        String[] arr = str.split(" ");

        for (String temp : arr) {
            System.out.println(temp);
        }
    }

    public void checkLastIndexOf() {
        String str = "Java Programming is funny";

        System.out.println(str.lastIndexOf('m'));
        System.out.println(str.lastIndexOf("m"));
        System.out.println(str.lastIndexOf('m', 20));
        System.out.println(str.lastIndexOf("m", 20));
        System.out.println(str.lastIndexOf('z'));
    }

    public void checkIndexOf() {
        String str = "Java Programming is funny";
        System.out.println(str.indexOf('m'));
        System.out.println(str.indexOf("m"));
        System.out.println(str.indexOf('m', 20));
        System.out.println(str.indexOf("m", 20));
        System.out.println(str.indexOf('z'));
    }

    public void checkAddress(String[] address) {
        int begin = 0, end = 0, mid = 0;

        String beginStr = "서울";
        String endStr = "동";
        String midStr = "구로";

        for (String str : address) {
            if(str.startsWith(beginStr)) ++begin;
            if(str.contains(midStr)) ++mid;
            if(str.endsWith(endStr)) ++end;
        }
        System.out.println("Starts with " + beginStr + " count is " + begin);
        System.out.println("Contains "+midStr + " count is "+mid);
        System.out.println("Ends with " + endStr + " count is " + end);
    }

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

}