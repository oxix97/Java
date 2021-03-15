package Operator.src;

import java.math.BigDecimal;
import java.util.*;
class SalaryManager {
    public void getMonthlySalary(int yearlySalary) {
        double monthSalary = yearlySalary / 12.0;
        System.out.println("monthSalary_original : " + monthSalary);

        double calculateTax = calculateTax(monthSalary);
        System.out.println("calculateTax : " + calculateTax);

        double nationalPension = nationalPension(monthSalary);
        System.out.println("nationalPension : " + nationalPension);

        double healthTax = healthTax(monthSalary);
        System.out.println("healthTax : "+healthTax);

        double taxAll = calculateTax + nationalPension + healthTax;
        System.out.println("tax All : " + taxAll);

        monthSalary -= taxAll;
        System.out.println("monthSalary : " + monthSalary);
    }

    public double calculateTax(double monthSalary) {
        return monthSalary*(12.5/100);
    }

    public double nationalPension(double monthSalary) {
        return monthSalary*(8.1/100);
    }

    public double healthTax(double monthSalary) {
        return monthSalary*(13.5/100);
    }

}
public class SalaryCalculator{
    public static void main(String[] args) {
        int yearSalary = 20000000;
        SalaryManager manager = new SalaryManager();
        manager.getMonthlySalary(yearSalary);
    }
}