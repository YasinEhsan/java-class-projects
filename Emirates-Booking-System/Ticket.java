
public class Ticket {
	private static int counter;
	private int ticketNumber;
	private double price;
	private Airline myAirline;
	private Passenger myPassenger;
	private Flight myFlight;
	
	public Ticket(double p, Airline a, Passenger pass, Flight f){
		counter++;
		ticketNumber = counter;
		setPrice(p);
		setAirline(a);
		setPassenger(pass);
		setFlight(f);
	}
	
	//mutators
	public void setPrice(double p){ price = p;}
	public void setAirline(Airline a){ myAirline = a;}
	public void setPassenger(Passenger p){ myPassenger = p; }
	public void setFlight(Flight f){ myFlight = f;}
	public void setCounter(int counter){ this.counter = counter;}
	
	//accessors
	public int getTicketNumber(){ return ticketNumber;}
	public double getPrice(){ return price;}
	public Airline getAirline(){ return myAirline;}
	public Passenger getPassenger(){ return myPassenger; }
	public Flight getFlight(){ return myFlight ;}
	public int getCounter(){ return counter;}
	
	//methods
	public void cancel(){
		myPassenger.cancel(this);
		myFlight.remove(this);
		myAirline.cancel(this);
	}
	
	//toString
	public String toString(){
		return  myAirline.getName() + " "
				+ myFlight.getFlightNumber() + " " 
				+ myFlight.getDate() + " " 
				+ myFlight.getDeparturnTime() + " from "
				+ myFlight.getOriginAirport() + " to "
				+ myFlight.getDestination() + " ticket cost "
				+ price +" \t Booked tickets: "
				+ myFlight.getTickets().size() + " / "
				+ myFlight.getSeats() + " seats";
	}
}
