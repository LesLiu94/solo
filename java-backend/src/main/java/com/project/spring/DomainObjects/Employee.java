package com.project.spring.DomainObjects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Comparator;
import java.util.Date;

@Entity
@Table(schema = "employeesschema", name = "employees")
public class Employee{

    @Column(name = "emp_no")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private int empNo;

    @Column(name = "birth_date")
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    private String birthDate;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(name = "gender")
    @NotBlank
    private char sex;

    @Column(name = "hire_date")
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date hireDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no",insertable=false,updatable=false)
    @NotBlank
    private Salary salary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no",insertable=false,updatable=false)
    @NotBlank
    private Title title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no",insertable=false,updatable=false)
    @NotBlank
    private DepartmentManager departmentManager;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no",insertable=false,updatable=false)
    @NotBlank
    private DepartmentEmployee departmentEmployee;

    @Override
    public String toString(){
        String resultString = String.join(" ",this.firstName, this.lastName, this.birthDate);
        return resultString;
    }

    //Getters and Setters

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public DepartmentManager getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    public DepartmentEmployee getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }
}
