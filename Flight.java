import java.util.ArrayList;
public class Flight {
	private static int counter;
	private String flightNumber, seats, filledSeats, flightLength, 
	date, originAirport, destination, departureTime; 
	private Airline airline;
	private ArrayList<Ticket> tickets;
	
	public Flight(String a, String b, String c, String d, String e,
			String f, String g, String h, ArrayList ar){
		setFlightNumber(a);
		setSeats(b);
		setFilledSeats(c);
		setFlightLength(d);
		setDate(e);
		setOriginAirport(f);
		setDestination(g);
		setDeparturnTime(h);
		setTickets(ar);
		counter = 0;
	}
	
	//mutators
	public void setFlightNumber(String sent){ flightNumber = sent;}
	public void setSeats(String sent){ seats = sent;}
	public void setFilledSeats(String sent){ filledSeats = sent;}
	public void setFlightLength(String sent){ flightLength = sent;}
	public void setDate(String sent){ date = sent;}
	public void setOriginAirport(String sent){ originAirport = sent;}
	public void setDestination(String sent){ destination = sent;}
	public void setDeparturnTime(String sent){ departureTime = sent;}
	public void setTickets(ArrayList t){ tickets = t;}
	public void setCounter(int x){counter = x;}	
	
	//accessors
	public String getFlightNumber(){ return flightNumber; }
	public String getSeats(){  return seats;}
	public String getFilledSeats(){ return filledSeats;}
	public String getFlightLength(){ return flightLength;}
	public String getDate(){ return date;}
	public String getOriginAirport(){ return originAirport;}
	public String getDestination(){ return destination;}
	public String getDeparturnTime(){ return departureTime;}
	public ArrayList getTickets(){ return tickets;}
	public int getCounter(){ return counter;}
	
	//methods
	public boolean matches(String d, double t, String from) {
		
	}
	public boolean hasSpace() {
		
	}
	public void addTicket(Ticket t) {
		
	}
	public boolean holdsTicket(Ticket ticket) {
		
	}
	public void remove(Ticket ticket) {
		
	}
	public double getCost() {
		
	}
	
	//toString
	public String toString(){
	return "your flight Number: " + flightNumber
			+ "\nseats: " + seats
			+ "\nflightLength: " + flightLength
			+ "\nfilledSeats: " + filledSeats
			+ "\ndate: " + date
			+ "\noriginal Airport: " + originAirport
			+ "\ndestination: " + destination
			+ "\ndepartureTime: " +  departureTime
			+ "\ntickets: " + tickets
			+ "\ncounter: " + counter;
	}

}
