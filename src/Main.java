public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Иванов Иван Иванович", 1, 22_000);
        Employee employee2 = new Employee("Петров Петр Петрович", 1, 22_500);
        Employee employee3 = new Employee("Сидоров Сидор Сидорович", 2, 25_000);
        Employee employee4 = new Employee("Башмачкин Акакий Акакиевич", 2, 29_000);
        Employee employee5 = new Employee("Коробочка Настасья Петровна", 3, 30_000);
        Employee employee6 = new Employee("Чичиков Павел Иванович", 3, 35_000);
        Employee employee7 = new Employee("Ненужный Федор Петрович", 1, 9_000);
        Employee employee8 = new Employee("Нужный Степан Захарович", 1, 40_000);
        Employee employee9 = new Employee("Чутьменееважный Борис Сергеевич", 5, 42_000);
        Employee employee10 = new Employee("Важный Олег Семенович", 1, 52_000);
        EmployeeBook eb = new EmployeeBook(employee1);
        eb.addEmployee(employee2);
        eb.addEmployee(employee3);
        eb.addEmployee(employee4);
        eb.addEmployee(employee5);
        eb.addEmployee(employee6);
        eb.addEmployee(employee7);
        eb.addEmployee(employee8);
        eb.addEmployee(employee9);
        eb.addEmployee(employee10);
        eb.changeSalary("Важный Олег Семенович",0);
        eb.changeDepartment("Важный Олег Семенович",1);
        eb.indexSalary(10);
        eb.calculateTotalSalary();
        eb.printEmployeesList();
        System.out.println();
        eb.printEmployeesListByDepartment(1);
        eb.getDepartmentAndEmployeesFullNames();
    }

}