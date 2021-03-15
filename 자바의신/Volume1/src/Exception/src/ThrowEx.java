package Exception.src;

public class ThrowEx {
    public void throwException(int num) throws Exception{
        if (num > 12) {
            throw new Exception("Number is over than 12");
        }
        System.out.println("number is " + num);
    }
    public static void main(String[] args) throws Exception {
        ThrowEx ex = new ThrowEx();
        ex.throwException(13);
    }
}
