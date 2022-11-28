public class Main {
    private static final Employee[] EMPLOYEES_LIST = new Employee[10];
    public static void main(String[] args) {
        EMPLOYEES_LIST[0] = new Employee("Иванов Иван Иванович", 1, 22_000);
        EMPLOYEES_LIST[1] = new Employee("Петров Петр Петрович", 1, 22_500);
        EMPLOYEES_LIST[2] = new Employee("Сидоров Сидор Сидорович", 2, 25_000);
        EMPLOYEES_LIST[3] = new Employee("Башмачкин Акакий Акакиевич", 2, 29_000);
        EMPLOYEES_LIST[4] = new Employee("Коробочка Настасья Петровна", 3, 30_000);
        EMPLOYEES_LIST[5] = new Employee("Чичиков Павел Иванович", 3, 35_000);
        EMPLOYEES_LIST[6] = new Employee("Ненужный Федор Петрович", 1, 9_000);
        EMPLOYEES_LIST[7] = new Employee("Нужный Степан Захарович", 1, 40_000);
        EMPLOYEES_LIST[8] = new Employee("Чутьменееважный Борис Сергеевич", 5, 42_000);
        EMPLOYEES_LIST[9] = new Employee("Важный Олег Семенович", 1, 52_000);
        System.out.println("=========== Список сотрудников ===========================================");
        printEmployeesList();
        System.out.println();
        System.out.println("Сумма затрат на зарплаты в месяц: " + calculateTotalSalary() + " ₽");
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeWithMinSalary());
        System.out.println();
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeWithMaxSalary());
        System.out.println();
        System.out.println("Средння зарплата в месяц: " + calculateAverageSalary());
        System.out.println();
        System.out.println("=========== Список Ф.И.О. сотрудников ===========================================");
        printFullNameAllEmployees();
    }
    private static void printEmployeesList(){
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    private static double calculateTotalSalary(){
        double sumSalary = 0;
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    private static Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;

        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;

        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageSalary(){
        int countEmployees = 0;
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null) {
                countEmployees++;
            }
        }
        if (countEmployees != 0) {
            return calculateTotalSalary() / countEmployees;
        }
        return 0;
    }

    private static void printFullNameAllEmployees(){
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}