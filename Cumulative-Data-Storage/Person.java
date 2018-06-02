
public class Person {
	
	private String name;
	public Person() {
		name = "no name yet";
	}
	public Person(String h) {
		name = h;
	}
	public void setName(String f) {
		name = f;
	}
	public String getName() {
		return name;
	}
	public void writeOutput() {
		System.out.println("name: " + name);
	}
	public boolean hasSameName(Person x) {
		return this.equals(x);
	}


}
