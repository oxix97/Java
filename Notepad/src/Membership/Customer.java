package Membership;

public class Customer {
    private int customerID;
    private String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatios;

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;

        customerGrade = "Sliver";
        bonusRatios = 0.01;
    }

    public int calPrice(int price) {
        bonusPoint += price * bonusRatios;
        return price;
    }

    public String showInfo() {
        return customerName+" 님의 등급 : "+customerGrade+" | bonus point : "+bonusPoint;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
