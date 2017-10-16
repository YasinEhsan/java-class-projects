
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
		counter = 0;
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
		
	}
	
	 
	//toString
	public String toString(){
		return "ticket Number: " + ticketNumber
				+ "\nprice: " + price
				+ "\nAirline: " + myAirline
				+ "\nPassenger: " + myPassenger
				+ "\nFlight: " + myFlight
				+ "\nCounter: " + counter;
	}
}
