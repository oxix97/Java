public class ExceptionEx {
    public void arrayOutOfBounds() {
        int[] arr = new int[5];
        try{
            System.out.println(arr[5]);
        }catch(Exception e) {
            System.out.println("Error");
        }
        System.out.println("finish");
    }

    public void arrayOutOfBoundsTryCatch() {
        int[] arr = new int[5];
        try {
            System.out.println(arr[5]);
            System.out.println("try code");
        } catch (Exception e) {
            System.err.println("Exception");
        }
        System.out.println("finish");
    }

    public void checkVariable() {
        int[] arr = new int[5];
        try {
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println(arr.length);
        }
        System.out.println("finish");
    }

    public void multiCatch() {
        int[] arr = new int[5];
        try {
            System.out.println(arr[5]);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static void main(String[] args) {
        ExceptionEx ex = new ExceptionEx();
        ex.multiCatch();
    }
}
