package Inheritance.src;

public class ChildCasting extends ParentCasting{
    public ChildCasting(){

    }
    public ChildCasting(String name){

    }
    @Override
    public void printName() {
        System.out.println("Child Name");
    }
    public void printAge(){
        System.out.println("Child age");
    }
}
