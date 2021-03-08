public class InnerClassEx {
    public static void main(String[] args) {
        InnerClassEx ex = new InnerClassEx();
        ex.makeInnerObject();
    }

    public void makeInnerObject() {
        OutOfInner outOfInner = new OutOfInner();
        OutOfInner.Inner inner = outOfInner.new Inner();
        inner.setValue(123);
        System.out.println(inner.getValue());
    }
}
