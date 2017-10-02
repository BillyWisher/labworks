package by.gsu.lab1;

public class Employee {
	private String name;
	private float salary;
	private boolean kids;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public boolean isKids() {
		return kids;
	}


	public void setKids(boolean kids) {
		this.kids = kids;
	}



	public Employee(String name, float salary, boolean kids) {
		super();
		this.name = name;
		this.salary = salary;
		this.kids = kids;
	}
	

}
