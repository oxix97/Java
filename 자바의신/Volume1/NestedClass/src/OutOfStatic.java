public class OutOfStatic {

    static class StaticNested {
        private int value = 0;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        OutOfStatic.StaticNested  ex = new OutOfStatic.StaticNested();
        System.out.println(ex.getClass());
    }
}
