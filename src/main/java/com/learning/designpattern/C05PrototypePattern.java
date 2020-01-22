package com.learning.designpattern;

class Employee implements Cloneable {
	private int empId;
	private String empName;

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class C05PrototypePattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee(1, "Emp1");
		Employee employee1 = (Employee) employee.clone();
		System.out.println(employee.hashCode());
		System.out.println(employee1.hashCode());
		employee1.setEmpName("Emp2");
		System.out.println(employee.getEmpName());
	}
}
