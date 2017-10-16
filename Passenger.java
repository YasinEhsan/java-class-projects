import java.util.ArrayList;
public class Passenger {
	private String firstName, lastName, address, phone; 
	private ArrayList<Ticket> myTickets = new ArrayList();
	
	public Passenger(String f, String l, String add,String ph, ArrayList tick){
		firstName = f;
		lastName = l;
		setAddress(add);
		setPhone(ph);
		setMyTickets(tick);
	}
	//mutators
	public void setAddress(String add){ this.address = add; }
	public void setPhone(String phone){ this.phone = phone; }
	public void setMyTickets(ArrayList sent){ this.myTickets = sent;}
	
	//accessors
	public String getFirstName(){ return firstName; }
	public String getLastName(){ return lastName; }
	public String getAddress(){ return address; }
	public String getPhone(){ return phone; }
	public ArrayList getTickets(){ return myTickets; }
	
	//methods
	public void cancel(Ticket t){
		for(Ticket item: myTickets){
			if(item.equals(t))
				myTickets.remove(item);
		}
	}
	public ArrayList<Flight> findFlights(Airline a, String date, double time, String from){
		
	}
	public Ticket bookFlight(Flight f) {
		
	}
	public boolean holdsTicket(Ticket t) {
		
	}
	
	//toString
	public String toString(){
		return "Firstname: " + firstName
				+ "\nlastName: " + lastName
				+ "\naddress " + address
				+ "\nphone: " + phone
				+ "\ntickets: " + myTickets;
	}

}
