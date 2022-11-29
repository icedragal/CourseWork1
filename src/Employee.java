public class Employee {
    private static int counter = 1;
    private String fullName;
    private int department;
    private double salary;
    private int id;


    public Employee(String fullName, int department, double salary){
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = counter;
        counter ++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Ф.И.О.: " + fullName +
                ", отдел: " + department +
                ", зарплата: " + salary;
    }
}