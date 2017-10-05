package by.gsu.lab1;
import by.gsu.lab1.Employee;

public class Runner {
	public static void main(String[] args){
		Employee[] employeeList = {
			new Employee("Papich", 20000f, false),
			new Employee("ViKa", 15000.34f, false),
			new Employee("Nevalny", 63421.23f, true),
			new Employee("Azazlo", 1000000f, false),
			new Employee("Landstop", 750762.09f, false),
			new Employee("GabeN", 322000000.64f, true),
			new Employee("M. GOD", 16000000f, false),
			new Employee("NiteSniper", 451400f, true),
			new Employee("Kaci", 130987f, true),
			new Employee("Sir Action", 211000f, false)
		};
		float avgSalary = 0;
		int kids = 0;
		for(int i=0;i<employeeList.length;i++){
			avgSalary+=employeeList[i].getSalary();
			if(employeeList[i].isKids()){
				kids++;
			}
		}
		avgSalary=avgSalary/employeeList.length;
		System.out.format("Avarage salary: %.0f%n", avgSalary);
		System.out.println("Amount of employee with children: " + kids);
		
	}

}
