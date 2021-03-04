public class Calculator {

    public void printDivide(double d1, double d2) throws Exception {
        if(d2==0)throw new Exception("Second value can't be Zero");
        System.out.println(d1/d2);

    }

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        try {
            calculator.printDivide(1,2);
            calculator.printDivide(1,0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
