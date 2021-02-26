public class Child extends Parent{
    public Child(){
        super("Parent");
        System.out.println("Child Constructor");
    }

    @Override
    public void printName() {
        System.out.println("Child printName()");
    }
}