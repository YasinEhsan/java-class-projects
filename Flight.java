import java.util.ArrayList;
public class Flight {
	private static int counter;
	private int filledSeats, seats, flightNumber;
	private double departureTime;
	private String  flightLength, 
	date, originAirport, destination; 
	private Airline airline;
	private ArrayList<Ticket> tickets;
	
	public Flight(double time, int numSeats, String from, String to){
		departureTime = time;
		seats = numSeats;
		originAirport = from;
		destination = to;
	}
	
	
	public Flight(int seats, String length, String date,
			String from, String to, double time, Airline airline){
		tickets = new ArrayList<>();
		counter++;
		setFlightNumber(counter);
		setSeats(seats);
		setFilledSeats(0);
		setFlightLength(length);
		setDate(date);
		setOriginAirport(from);
		setDestination(to);
		setDepartureTime(time);
		setAirline(airline);
	}
	
	//mutators
	public void setFlightNumber(int sent){ flightNumber = sent;}
	public void setSeats(int sent){ seats = sent;}
	public void setFilledSeats(int sent){ filledSeats = sent;}
	public void setFlightLength(String sent){ flightLength = sent;}
	public void setDate(String sent){ date = sent;}
	public void setOriginAirport(String sent){ originAirport = sent;}
	public void setDestination(String sent){ destination = sent;}
	public void setDepartureTime(double sent){ departureTime = sent;}
	public void setTickets(ArrayList t){ tickets = t;}
	public void setCounter(int x){counter = x;}	
	public void setAirline(Airline x){airline = x;}
	
	//accessors
	public int getFlightNumber(){ return flightNumber; }
	public int getSeats(){  return seats;}
	public double getFilledSeats(){ return filledSeats;}
	public String getFlightLength(){ return flightLength;}
	public String getDate(){ return date;}
	public String getOriginAirport(){ return originAirport;}
	public String getDestination(){ return destination;}
	public double getDeparturnTime(){ return departureTime;}
	public ArrayList getTickets(){ return tickets;}
	public int getCounter(){ return counter;}
	public Airline getAirline(){return airline;}
	
	//methods
	public boolean matches(String date, double time, String origin) {//ewoyugfdwiwfgdwhiugvdfhjsaiwLHFVDHDWQfgjsadwjhjgd
			if(getDate().equals(date) && getOriginAirport().equalsIgnoreCase(origin))
				if(getDeparturnTime() >= (time - 4) && getDeparturnTime() <= (time + 4))
					return true;	
		return false;
	}
	public boolean hasSpace() {
		return filledSeats < seats;
	}
	public void addTicket(Ticket t) {
		filledSeats++;
		tickets.add(t);
	}
	public boolean holdsTicket(Ticket ticket) {
		for(Ticket x: tickets)
			if(x.equals(ticket))
				return true;
		return false;
	}
	public void remove(Ticket ticket){
		if(tickets.remove(ticket))
			filledSeats--;
	}
	public double getCost() {
		return airline.cost(this);
	}
	
	//toString
	public String toStringold(){
	return "your flight Number: " + flightNumber
			+ " seats: " + seats
			+ " flightLength: " + flightLength
			+ " filledSeats: " + filledSeats
			+ " date: " + date
			+ " original Airport: " + originAirport
			+ " destination: " + destination
			+ " departureTime: " +  departureTime
			+ " tickets: " + tickets;
	}
	
	public String toString(){
		return  airline.getName() + " "
				+ flightNumber + " on " 
				+ date + " at " 
				+ departureTime + " from "
				+ originAirport + " to "
				+ destination + " ticket cost "
				+ getCost() +" \t Booked tickets: "
				+ tickets.size() + " / "
				+ seats + " seats";
	}

}
