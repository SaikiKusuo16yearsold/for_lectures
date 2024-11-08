package pro.sky.skyprospringdemo.model;

import java.util.Objects;

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


    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и тип
        Employee employee = (Employee) obj; // Приведение типа
        return departmentNumber == employee.departmentNumber &&
                salary == employee.salary &&
                Objects.equals(fullname, employee.fullname); // Сравнение полей
    }


    public int hashCode() {
        return Objects.hash(fullname, departmentNumber, salary); // Уникальный хэш на основе полей
    }

}



