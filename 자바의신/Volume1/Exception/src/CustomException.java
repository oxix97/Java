public class CustomException {
    public void throwException(int num)throws MyException {
        try {
            if (num > 12) throw new MyException("Num is over than 12");

        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomException exception = new CustomException();

        try {
            exception.throwException(13);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
