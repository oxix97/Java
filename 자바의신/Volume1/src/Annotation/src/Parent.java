package Annotation.src;

public class Parent {
    public void printName() {
        System.out.println(getClass().getName());
    }

    @Deprecated
    public void noMoreUse() {
        System.out.println("NoMoreUse");
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.printName();
    }
}
