package com.learning.designpattern;

import java.util.Calendar;
import java.util.Date;

class Employee implements Cloneable {
	private int empId;
	private String empName;
    private Date joiningDate;

	public Employee(int empId, String empName,Date joiningDate) {
		this.empId = empId;
		this.empName = empName;
		this.joiningDate = joiningDate;
	}

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
	protected Employee clone() throws CloneNotSupportedException {
		return (Employee) super.clone();
	}
}

public class C05PrototypePattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee(1, "Emp1", new Date());
		Employee employee1 = employee.clone();
		System.out.println(employee.hashCode());
		System.out.println(employee1.hashCode());

		employee1.setEmpName("Emp2");
		System.out.println(employee.getEmpName());

        Calendar myCal = Calendar.getInstance();
        myCal.set(Calendar.YEAR, 2021);
        myCal.set(Calendar.MONTH, 6);
        myCal.set(Calendar.DAY_OF_MONTH, 30);
        Date date = myCal.getTime();
        employee1.setJoiningDate(date);
        System.out.println(employee.getJoiningDate());


	}
}
