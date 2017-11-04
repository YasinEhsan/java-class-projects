import java.util.ArrayList;
public class Passenger {
	private String firstName, lastName, address, phone; 
	private ArrayList<Ticket> myTickets;
	

	public Passenger(String f, String l, String add,String ph){
		myTickets = new ArrayList<>();
		firstName = f;
		lastName = l;
		setAddress(add);
		setPhone(ph);
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
			if(item.equals(t)) {
				myTickets.remove(item);
				break;
			}
		}
		//t.cancel();
	}
	public ArrayList<Flight> findFlights(Airline a, String date, double time, String from){//hihrlkashfgkljakdwhfgdwlflsakfhbksalfbhkslafhgsk
		return a.findFlights(date, time, from);
	}
	public Ticket bookFlight(Flight f) {
		Ticket t = f.getAirline().book(this, f);
		if(t != null){
			myTickets.add(t);
			return t;
		}
		return null;
	}
	public boolean holdsTicket(Ticket t) {
		for(Ticket item: myTickets)
			if(item.equals(t))
				return true;
		return false;
	}
	public void addTicket(Ticket t){
		myTickets.add(t);
	}
	
	//toString
	public String toString(){
		return "Firstname: " + firstName
				+ "\nlastName: " + lastName
				+ "\naddress " + address
				+ "\nphone: " + phone
				+ "\ntickets: " + myTickets;
	}
	
	public String toString2(){
		return firstName + " "
				+ lastName + " booked ";
	}

}
