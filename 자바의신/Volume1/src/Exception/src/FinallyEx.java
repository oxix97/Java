package Exception.src;

public class FinallyEx {
    public void finallyExample() {
        int[] arr = new int[5];
        try {
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println(arr.length);
        }finally {
            System.out.println("finally");
        }
        System.out.println("Done");
    }
    public static void main(String[] args) {
        FinallyEx ex = new FinallyEx();
        ex.finallyExample();
    }
}
