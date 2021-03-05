public class StringNullEx {
    public boolean nullCheck(String data) {

        if (data == null)
            return true;

        else
            return false;
    }

    public static void main(String[] args) {
        StringNullEx ex  = new StringNullEx();
        ex.nullCheck(null);
    }
}
