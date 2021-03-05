import java.io.UnsupportedEncodingException;

public class StringEx {

    public void convert16() {
        try{
            String korean = "한글";
            byte[] arr = korean.getBytes("UTF-16");
            printByteArray(arr);
            String korean2 = new String(arr,"UTF-16");
            System.out.println(korean2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convert() {
        try {
            String korean = "한글";

            byte[] arr1 = korean.getBytes();

            for (byte data : arr1) {
                System.out.print(data + " ");
            }
            System.out.println();
            String korean2 = new String(arr1);
            System.out.println(korean2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printByteArray(byte[] arr) {
        for (byte data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringEx ex = new StringEx();
        ex.convert16();
    }
}
