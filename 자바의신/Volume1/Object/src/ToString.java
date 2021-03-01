public class ToString {
    public static void main(String[] args) {
        ToString string = new ToString();
        string.toStringMethod(string);
    }

    public void toStringMethod(Object obj) {
        System.out.println(this);
        System.out.println(toString());
        System.out.println("plus " + this);
    }

    @Override
    public String toString() {
        return "ToString Class";
    }
}