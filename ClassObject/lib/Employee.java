package ClassObject.lib;

public class Employee {
    private String name;
    private int id;
    private String department;
    private double salary;
    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "Tech Corp.";
    private static double totalSalary = 0.0;

    public Employee() {
        this.name = "Unknown";
        this.id = nextId++;
        this.department = "Unknown";
        this.salary = 0.0;
        employeeCount++;
        totalSalary += salary;
    }

    public Employee(String name, int id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
        employeeCount++;
        totalSalary += salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }  

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
        totalSalary += salary;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
    public static double getTotalSalary() {
        return totalSalary;
    }
    public static double getAverageSalary() {
        if (employeeCount == 0) {
            return 0.0;
        }
        return totalSalary / employeeCount;
    }
    public void increaseSalary(double percentage) {
        if(percentage < 0) {
            System.out.println("Invalid percentage. Salary increase must be a positive value.");
            return;
        }
        double increaseAmount = salary * (percentage / 100);
        setSalary(salary + increaseAmount);        
    }
    public void changeCompanyName(String newName) {
        this.companyName = newName;
    }


    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 1001, "HR", 50000);
        Employee emp2 = new Employee("Bob", 1002, "IT", 60000);
        Employee emp3 = new Employee("Charlie", 1003, "Finance", 55000);

        emp1.displayInfo();
        System.out.println();
        emp2.displayInfo();
        System.out.println();
        emp3.displayInfo();
        System.out.println();
         System.out.println("Total Employees: " + Employee.getEmployeeCount());
        System.out.println("Total Salary: $" + Employee.getTotalSalary());
        System.out.println("Average Salary: $" + Employee.getAverageSalary());
        //chanege salary of emp1
        emp1.setSalary(52000);
        System.out.println("After updating salary of " + emp1.getSalary() + ":");
        System.out.println("Total Salary: $" + Employee.getTotalSalary());
        
        emp1.changeCompanyName("Global Tech Inc."); 
        System.out.println("Company Name: " + Employee.companyName);
        //trường hợp nếu không goi getAverageSalary() từ object mà gọi trực tiếp từ class thì sẽ không cần tạo đối tượng Employee
        //vì phương thức getAverageSalary() là phương thức static, nó thuộc về class chứ không thuộc về đối tượng cụ thể nào. Do đó, bạn có thể gọi trực tiếp phương thức này từ class mà không cần tạo đối tượng Employee nào cả. Ví dụ:
        System.out.println("Average Salary (called from class): $" + Employee.getAverageSalary());

        emp2.increaseSalary(10); // Tăng lương của Bob lên 10%
        System.out.println("After increasing salary of " + emp2.getName() + ":"+ emp2.getSalary());
        System.out.println("Total Salary: $" + Employee.getTotalSalary());
    }
}
