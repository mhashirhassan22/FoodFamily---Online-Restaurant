package com.models;


public class Salesman extends Staff{
    
    private int Salary;
    
    public Salesman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salesman(int id, String firstName, String lastName, String email, String password, String userName,
			String contactNo,int salary) {
		super(id, firstName, lastName, email, password, userName, contactNo);
		Salary=salary;
	}

	public boolean dispSalesman(){
        
        return true;
    }
    
    public boolean generateReport(){
        
        return true;
    }

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}
    
    
    
    
    
}
