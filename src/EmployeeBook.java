public class EmployeeBook {

    private final Employee[] employeeList;

    //region Базовый
    public void printEmployeesList(){
        for (Employee employee : employeeList) {
            if (employee != null) {
            System.out.println(employee);
            }
        }
    }
    public double calculateTotalSalary(){
        double sumSalary = 0;
        for (Employee employee : employeeList) {
            if (employee != null) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;

        for (Employee employee : employeeList) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;

        for (Employee employee : employeeList) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public double calculateAverageSalary(){
        int countEmployees = 0;
        for (Employee employee : employeeList) {
            if (employee != null) {
                countEmployees++;
            }
        }
        if (countEmployees != 0) {
            return calculateTotalSalary() / countEmployees;
        }
        return 0;
    }

    public void printFullNameAllEmployees(){
        for (Employee employee : employeeList) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
    //endregion

    //region Трудный
    public void indexSalary(int percent) {
        for (Employee employee : employeeList) {
            if (employee != null) {
                double currentSalary=employee.getSalary();
                employee.setSalary(currentSalary + currentSalary * percent / 100);
            }
        }
    }

    public Employee findEmployeeWithMinSalaryByDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalaryByDepartment = null;

        for (Employee employee : employeeList) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalaryByDepartment = employee;
            }
        }
        return employeeWithMinSalaryByDepartment;
    }

    public Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalaryByDepartment = null;

        for (Employee employee : employeeList) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalaryByDepartment = employee;
            }
        }
        return employeeWithMaxSalaryByDepartment;
    }

    public double calculateTotalSalaryByDepartment(int department){
        double sumSalary = 0;
        for (Employee employee : employeeList) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    public double calculateAverageSalaryByDepartment(int department){
        int countEmployees = 0;
        for (Employee employee : employeeList) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployees++;
            }
        }
        if (countEmployees != 0) {
            return calculateTotalSalaryByDepartment(department) / countEmployees;
        }
        return 0;
    }

    public void indexSalaryByDepartment(int department, int percent) {
        for (Employee employee : employeeList) {
            if (employee != null && employee.getDepartment() == department) {
                double currentSalary=employee.getSalary();
                employee.setSalary(currentSalary + currentSalary * percent / 100);
            }
        }
    }

    public void printEmployeesListByDepartment(int department){
        for (Employee employee : employeeList) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф.И.О.: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }
    public void findEmployeesWithSalaryFewer(double salary) {
        for (Employee employee : employeeList) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф.И.О.: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }
    public void findEmployeesWithSalaryMore(double salary) {
        for (Employee employee : employeeList) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф.И.О.: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }
    //endregion

    //region Очень сложно
    public EmployeeBook(Employee employee) {
        this.employeeList = new Employee[10];
        this.employeeList[findFreeIndex()] = employee;
    }
    private int findFreeIndex() {
        for(int i = 0; i < employeeList.length; i++){
            if(employeeList[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void deleteEmployee(int id){
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getId() == id) {
                this.employeeList[i] = null;
            }
        }
    }

    public void deleteEmployee(String fullName){
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getFullName().equals(fullName)) {
                this.employeeList[i] = null;
            }
        }
    }
    public void addEmployee(Employee employee){
        this.employeeList[findFreeIndex()] = employee;
    }
    public void changeSalary(String fullName, double salary){
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getFullName().equals(fullName)) {
                this.employeeList[i].setSalary(salary);
            }
        }
    }

    public void changeDepartment(String fullName, int department){
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getFullName().equals(fullName)) {
                this.employeeList[i].setDepartment(department);
            }
        }
    }

    public void getDepartmentAndEmployeesFullNames(){
        int maxDepartment = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getDepartment() > maxDepartment){
                maxDepartment = employeeList[i].getDepartment();
            }
        }
        for (int i = 1; i <= maxDepartment; i++){
            System.out.println("Отдел " + i);
            this.printEmployeesListByDepartment(i);
        }
    }

    //endregion
}
