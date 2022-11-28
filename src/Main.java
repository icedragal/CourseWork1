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
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeWithMaxSalary());
        System.out.println("Средння зарплата в месяц: " + calculateAverageSalary());
        System.out.println();
        System.out.println("=========== Список Ф.И.О. сотрудников ===========================================");
        printFullNameAllEmployees();
        System.out.println();
        System.out.println("=========== Индексация ЗП ===========================================");
        indexSalary(10);
        System.out.println("=========== Список сотрудников после индексации===========================================");
        printEmployeesList();
        System.out.println("Сотрудник с максимальной зарплатой по отделу: " + findEmployeeWithMaxSalaryByDepartment(1));
        System.out.println("Сотрудник с минимальной зарплатой по отделу: " + findEmployeeWithMinSalaryByDepartment(1));
        System.out.println("Сумма затрат на зарплаты в месяц по отделу: " + calculateTotalSalaryByDepartment(1));
        System.out.println("Средння зарплата в месяц по отделу: " + calculateAverageSalaryByDepartment(2));
        System.out.println();
        System.out.println("=========== Индексация ЗП по отделу ===========================================");
        indexSalaryByDepartment(1,10);
        System.out.println("=========== Список сотрудников после индексации===========================================");
        printEmployeesList();
        System.out.println();
        System.out.println("=========== Список сотрудников по отделу ===========================================");
        printEmployeesListByDepartment(1);
        System.out.println();
        System.out.println("=========== Список сотрудников c ЗП меньше ===========================================");
        findEmployeesWithSalaryFewer(40000);
        System.out.println();
        System.out.println("=========== Список сотрудников c ЗП больше ===========================================");
        findEmployeesWithSalaryMore(40000);
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

    private static void indexSalary(int percent) {
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null) {
                double currentSalary=employee.getSalary();
                employee.setSalary(currentSalary + currentSalary * percent / 100);
            }
        }
    }

    private static Employee findEmployeeWithMinSalaryByDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalaryByDepartment = null;

        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalaryByDepartment = employee;
            }
        }
        return employeeWithMinSalaryByDepartment;
    }

    private static Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalaryByDepartment = null;

        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalaryByDepartment = employee;
            }
        }
        return employeeWithMaxSalaryByDepartment;
    }

    private static double calculateTotalSalaryByDepartment(int department){
        double sumSalary = 0;
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    private static double calculateAverageSalaryByDepartment(int department){
        int countEmployees = 0;
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployees++;
            }
        }
        if (countEmployees != 0) {
            return calculateTotalSalaryByDepartment(department) / countEmployees;
        }
        return 0;
    }

    private static void indexSalaryByDepartment(int department, int percent) {
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getDepartment() == department) {
                double currentSalary=employee.getSalary();
                employee.setSalary(currentSalary + currentSalary * percent / 100);
            }
        }
    }

    private static void printEmployeesListByDepartment(int department){
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф.И.О.: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }
    private static void findEmployeesWithSalaryFewer(double salary) {
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф.И.О.: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }
    private static void findEmployeesWithSalaryMore(double salary) {
        for (Employee employee : EMPLOYEES_LIST) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф.И.О.: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }
}