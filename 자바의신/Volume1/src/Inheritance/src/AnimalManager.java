package Inheritance.src;

class Animal{
    String name;
    String kind;
    int legCount;
    int iq;
    boolean hasWing;

    public Animal() {}

    public Animal(String name, String kind, int legCount, int iq, boolean hasWing) {
        this.name = name;
        this.kind = kind;
        this.legCount = legCount;
        this.iq = iq;
        this.hasWing = hasWing;
    }

    public void move() {};

    public void eatFood() {};
}
class Dog extends Animal{
    String owner;

    public Dog(){};

    public Dog(String name, String kind, int legCount, int iq, boolean hasWing, String owner) {
        super(name, kind, legCount, iq, hasWing);
        this.owner = owner;
    }

    @Override
    public void move() {
        System.out.println("Dog move");
    }

    @Override
    public void eatFood() {
        System.out.println("Dog eats food");
    }
}

class Cat extends Animal{
    private String owner;

    public Cat () {}

    public Cat(String name, String kind, int legCount, int iq, boolean hasWing, String owner) {
        super(name, kind, legCount, iq, hasWing);
        this.owner = owner;
    }

    @Override
    public void move() {
        System.out.println("Cat move");
    }

    @Override
    public void eatFood() {
        System.out.println("Cat eats food");
    }
}
public class AnimalManager{
    public static void main(String[] args) {
        Dog dog = new Dog("WHITE","dog",4,78,false,"Chan");
        Cat cat = new Cat();

        dog.move();
        dog.eatFood();
        System.out.println(dog.owner);
        System.out.println("-----------");
        cat.move();
        cat.eatFood();

    }
}
