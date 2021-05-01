package Generic;

public class CarSample {
    public static void main(String[] args) {
        CarSample sample = new CarSample();
        sample.callBoundedMethod();
    }
    public void callBoundedMethod() {
        WildcardGeneric<Car> wildcard = new WildcardGeneric<Car>();
        wildcard.setWildcard(new Car("Wu"));
        boundedWildcardMethod(wildcard);
    }
    public void boundedWildcardMethod(WildcardGeneric<? extends Car> c) {
        Car value = c.getWildcard();
        System.out.println(value);
    }
}
