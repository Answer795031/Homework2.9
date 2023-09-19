package pro.sky.homework_2_9;

import java.util.Objects;
import java.lang.Math;
import java.util.Random;

public class Employee {

    private final String fullName;
    private final int passportNumber;
    private final int salary;
    private final int departmentId;

    public Employee(String fullName, int passportNumber, int salary, int departmentId) {

        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", passportNumber=" + passportNumber +
                ", salary=" + salary +
                ", department=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return passportNumber == employee.passportNumber &&
                salary == employee.salary &&
                departmentId == employee.departmentId &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, passportNumber, salary, departmentId);
    }

    public String getFullName() {
        return fullName;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }
}