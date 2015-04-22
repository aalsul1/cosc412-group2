package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public abstract class Employee {
    
    protected String firstName, lastName, employeeID;
    
    public Employee() {}
    public Employee(String fn, String ln, String id) {
        this.firstName = fn;
        this.lastName = ln;
        this.employeeID = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmpID() {
        return employeeID;
    }    
}
