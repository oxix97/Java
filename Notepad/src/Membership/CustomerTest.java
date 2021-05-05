package Membership;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer(1111001,"Chan");
        customerLee.bonusPoint=500;
        System.out.println(customerLee.showInfo());


        VIPCustomer vipCustomerKim = new VIPCustomer(9999001,"oxix");
        vipCustomerKim.bonusPoint = 15000;
        System.out.println(vipCustomerKim.showInfo());
    }
}
