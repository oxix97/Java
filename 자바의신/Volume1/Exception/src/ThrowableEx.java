public class ThrowableEx {
    public void throwable() {
        int[] arr = new int[5];
        try {
            arr = null;
            System.out.println(arr[5]);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            System.out.println(throwable.toString());
            throwable.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ThrowableEx ex = new ThrowableEx();
        ex.throwable();
    }
}