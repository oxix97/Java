package ReferenceType.src;

public class ReferenceString {
    String name;
    public ReferenceString(){};
    public ReferenceString(String name) {
        this.name = name;
    }
    public void printName(){
        ReferenceString reference1 = new ReferenceString("chan");
        System.out.println(reference1.name);

        ReferenceString reference2 = new ReferenceString("oxix");
        System.out.println(reference1.name);
    }
    public static void main(String[] args) {
        ReferenceString reference = new ReferenceString();
        reference.printName();
    }
}
