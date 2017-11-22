package by.gsu.lab4;

import java.io.Serializable;

public class Explorer implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final double BASE_VALUE = 21;
	private String name;
	private int category;
	private String position;

	public Explorer(final String name, final int category, final String position) throws ExplorerException{
		super();
		if (name.length()<=0){
			 throw new ExplorerException("Explorer name should consist of at least 2 symbols", name);
		}
		if (category <= 0 || category >=9){
			throw new ExplorerException("Invalid category, it should be in range from 1 to 9", category);
		}
		if (position.length()<=0){
			 throw new ExplorerException("Explorer position should consist of at least 2 symbols, register doesn't matter", position);
		}
		this.name = name;
		this.category = category;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		double salary = 0;
		switch (this.position.toLowerCase()) {
		case "junior":
			salary = BASE_VALUE * 1.1 * this.category;
			break;
		case "senior":
			salary = BASE_VALUE * 1.5 * this.category;
			break;
		case "deputy":
			salary = BASE_VALUE * 2 * this.category;
			break;
		case "chief":
			salary = BASE_VALUE * 2.5 * this.category;
			break;
		default:
			throw new IllegalArgumentException("Invalid employee position: " + position);
		}
		return salary;
	}

	@Override
	public String toString() {
		return "Explorer [name=" + name + ", category=" + category + ", position=" + position + ", salary()="
				+ getSalary() + "]";
	}

}
