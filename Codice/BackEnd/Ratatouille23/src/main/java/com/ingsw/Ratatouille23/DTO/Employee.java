package com.ingsw.Ratatouille23.DTO;

public abstract class Employee extends User{
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
