package practice;

import java.util.Locale;

public class UseStringMethods {

    public static void main(String[] args) {
        UseStringMethods methods = new UseStringMethods();

        String str = "The String class represents character strings.";
        String findStr = "string";
        methods.printWords(str);
        methods.findString(str,findStr);
        methods.findAnyCaseString(str,findStr);
        methods.countChar(str,'s');
        methods.printContainWords(str,"ss");
    }

    public void printContainWords(String str, String findStr) {
        String[] strs = str.split(" ");

        for (String data : strs) {
            if(data.contains(findStr))
                System.out.println(data + " contains " + findStr);
        }
    }

    public void countChar(String str, char c) {
        char[] arr = str.toCharArray();
        int count = 0;
        for (char data : arr) {
            if (c == data) {
                ++count;
            }
        }
        System.out.println("char '" + c + "' count is " + count);
    }

    public void findAnyCaseString(String str, String findStr) {
        System.out.println(findStr +" is appeared at "+str.toLowerCase().indexOf(findStr));
    }

    public void findString(String str, String findStr) {
        System.out.println(findStr +" is appeared at "+str.indexOf(findStr));
    }

    public void printWords(String str) {
        String[] strs = str.split(" ");

        for (String data : strs) {
            System.out.println(data);
        }
    }
}
