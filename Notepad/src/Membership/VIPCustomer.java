package Membership;

public class VIPCustomer extends Customer {
    private int agentID;
    double saleRatio;

    public VIPCustomer(int customerID, String customerName) {
        super(customerID, customerName);
        bonusRatios = 0.05;
        saleRatio = 0.1;
        customerGrade = "VIP";
    }


    public int getAgentID() {
        return agentID;
    }
}
