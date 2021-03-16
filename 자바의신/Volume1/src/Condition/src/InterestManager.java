package Condition.src;

import java.util.*;
public class InterestManager{
    public double getInterestRate(int day) {
        double rate;
        if(day < 1) return 0;

        if(day<=90) rate = 0.5;
        else if(day<=180) rate = 1.0;
        else if(day<=364) rate = 2.0;
        else rate = 5.6;

        return rate;
    }

    public double calculateAmount(int day, long amount) {
        return amount + amount * getInterestRate(day)/100.0;
    }

    public void dayOnePrint(int day, long amount){
        for (int i = 1; i <= day; i++) {
            double total = calculateAmount(i,amount);
            System.out.println("day : "+i+ " | " + "amount : " + total);
        }
    }
    public void dayTenPrint(int day, long amount){
        for (int i = 1; i <= day; i+=10) {
            double total = calculateAmount(i,amount);
            System.out.println("day : "+i+ " | " + "amount : " + total);
        }
    }
    public static void main(String[] args) {
        InterestManager manager = new InterestManager();
        manager.dayOnePrint(370,1_000_000);
        System.out.println("---");
        manager.dayTenPrint(370,1_000_000);
    }
}