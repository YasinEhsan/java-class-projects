import java.util.ArrayList;
public class Airline {
	private ArrayList<Flight> flights = new ArrayList();
	private String name;
	
	public Airline(ArrayList sentFlights, String sentName){
		setFlights(sentFlights);
		setName(sentName);
	}
	
	//mutators
	public void setFlights(ArrayList sent){ flights = sent;}
	public void setName(String name){ this.name = name; }
	
	//accessors
	public ArrayList getFlights(){ return flights; }
	public String getName(){ return name; }
	
	//methods
	public void cancel(Ticket t){
		
	}
	public void issueRefund(Ticket t) {
		
	}
	public ArrayList<Flight> findFlights(String date, double time, String origin){
		
	}
	public Ticket book(Passenger p, Flight f) {
		
	}
	public double cost(Flight f) {
		
	}
	public void createFlight(double time, int numSeats, String from, String to) {
		
	}
	//toString
	public String toString(){
		return "flights: " + flights
				+ "\nname: " + name;
	}
}
