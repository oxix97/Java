public class OperatorClass {
    public static String operator (int point) {
        return point >= 80 ? "Pass" : "Nonpass";
    }
    public static void main(String[] args) {
        System.out.println(operator(85));
        System.out.println(operator(75));
    }
}
