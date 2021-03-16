package End;

public class CalculateSalary {

    final int OWNER = 1;
    final int MANAGER = 2;
    final int DESIGNER = 3;
    final int ARCHITECT = 4;
    final int DEVELOPER = 5;

    public long getSalaryIncrease(Employee employee) {
        long salary = 0;
        switch (employee.getType()) {
            case OWNER:
                salary = (employee.getSalary() * 5) / 100; break;
            case MANAGER:
                salary = (employee.getSalary() * 110) / 100; break;
            case DESIGNER:
                salary = (employee.getSalary() * 120) / 100; break;
            case ARCHITECT:
                salary = (employee.getSalary() * 130) / 100; break;
            case DEVELOPER:
                salary = employee.getSalary() * 2; break;
        }
        return salary;
    }

    public void calculateSalaries() {
        Employee[] employees = {
                new Employee("LeeDaeRi",OWNER,1_000_000_000),
                new Employee("KimManager",MANAGER,100_000_000),
                new Employee("WhangDesign",DESIGNER,70_000_000),
                new Employee("ParkArchi",ARCHITECT,80_000_000),
                new Employee("LeeDevelop",DEVELOPER,60_000_000)
        };

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " = " + getSalaryIncrease(employee));
        }
    }

    public static void main(String[] args) {
        CalculateSalary salary = new CalculateSalary();
        salary.calculateSalaries();
    }
}
