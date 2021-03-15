package NestedClass.src;

public class NestClassEx {
    public static void main(String[] args) {
        NestClassEx ex = new NestClassEx();
        ex.makeStaticNestedObject();
    }

    public void makeStaticNestedObject() {
        OutOfStatic.StaticNested staticNested = new OutOfStatic.StaticNested();
        staticNested.setValue(123);
        System.out.println(staticNested.getValue());
    }
}
