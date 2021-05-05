package Membership;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer();
        customerLee.setCustomerName("Chan");
        customerLee.setCustomerID(1111001);
        customerLee.bonusPoint=500;
        System.out.println(customerLee.showInfo());


        VIPCustomer vipCustomerKim = new VIPCustomer();
        vipCustomerKim.setCustomerName("oxix");
        vipCustomerKim.setCustomerID(9999001);
        vipCustomerKim.bonusPoint = 15000;
        System.out.println(vipCustomerKim.showInfo());
    }
}
