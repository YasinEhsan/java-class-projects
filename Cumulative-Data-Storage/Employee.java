
public class Employee extends Person{
	private String ssn; //social security
	private double salary;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String ssn, double f) {
		super(name);
		this.ssn = ssn;
		salary = f;
	}
	public void setSsn(String h) {
		
		
		ssn = h;
	}
	public void setSalary(double h) {
		salary = h;
	}
	public String getSSN() {
		return ssn;
	}
	public double getSalary() {
		return salary;
	}
	public String toString(){
		return "Name: " + this.getName() + " Social-Security: " + ssn + " Salary: " + salary;
	}
	public boolean equals(Employee h){
		return this.equals(h);
	}
}
