package pro.sky.skyprospringdemo.model;

public class Employee {
    private String fullname;
    private int departmentNumber;
    private int salary;
    static int id = 1;
    private int idDevelopers;

    public Employee(String fullname, int departmentNumber, int salary) {
        this.fullname = fullname;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
        this.idDevelopers = id;
        id = id + 1;

    }

    public String getFullname() {
        return fullname;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.idDevelopers;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String toString() {
        return "Фио сотрудника " + getFullname() + " номер департамента " + departmentNumber + " зарплата " +
                getSalary() + " кго id " + idDevelopers;
    }

    public boolean equals(Employee employee) {
        return this.fullname.equals(employee.getFullname()) && this.departmentNumber == employee.getDepartmentNumber()&&
                this.salary == employee.getSalary();
    }

    public int hashCod() {
        return this.hashCode();
    }

}