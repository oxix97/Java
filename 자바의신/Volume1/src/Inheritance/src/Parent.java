package Inheritance.src;

public class Parent {
    public Parent(String name) {
        System.out.println("Parent Name : " + name);
    }

    public Parent(Inheritance obj) {
        System.out.println("InheritanceParent Constructor");
    }

    public Parent() {

    }

    public void printName() {
        System.out.println("Parent printName()");
    }
}