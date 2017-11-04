import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
public class Airline {
	private ArrayList<Flight> flights; 
	private ArrayList<String> nations;
	private String name;
	 
	
	public Airline(String sentName){
		flights = new ArrayList<>();
		nations = new ArrayList<>();
		setName(sentName);
		
		String[] countries = Locale.getISOCountries();
		for (String country : countries) {
			Locale obj = new Locale("en", country);
			nations.add(obj.getDisplayCountry());
		}
	}
	
	//mutators
	public void setFlights(ArrayList sent){ flights = sent;}
	public void setName(String name){ this.name = name; }
	
	//accessors
	public ArrayList getFlights(){ return flights; }
	public String getName(){ return name; }
	public ArrayList getNations(){return nations;}
	
	//methods
	public void cancel(Ticket t){
		issueRefund(t);
	}
	public void issueRefund(Ticket t) {
		System.out.println( name + " refunds $" + t.getPrice()  + " to " 
	+ t.getPassenger().getFirstName() + " " + t.getPassenger().getLastName());
	}
	public ArrayList<Flight> findFlights(String date, double time, String origin){
		ArrayList<Flight> list = new ArrayList<>();
		for(Flight x: flights){
			if(x.matches(date, time, origin) && x.hasSpace())
					list.add(x);
			}
		return list;
	}
	public Ticket book(Passenger p, Flight f) {
		if(f.hasSpace()){
			Ticket newTicket = new Ticket(f.getCost(), this, p, f);
			f.addTicket(newTicket);
			return newTicket;
		}
		return null;
	}
	public double cost(Flight f) {
		return 400 + f.getFilledSeats()*3;
	}
	public void createFlight(double time, int numSeats, String from, String to) {
		Flight x = new Flight( numSeats, "TBD", "TBD", from, to, time, this);
		flights.add(x);
	}
	public void generate(){
		int counter = 0;
		for(int day = 1; day <= 31; day++){
			for(int hour = 0; hour <= 23; hour++){
				for(int i =0; i < nations.size(); i++){
					createFlight(setMinutes(hour), random(75) + 100, "Dubai", nations.get(i));
					flights.get(counter).setDate("10." + day + ".17" );
					counter++;
					createFlight(setMinutes(hour), random(75) + 100, nations.get(i), "Dubai");
					flights.get(counter).setDate("10." + day + ".17" );
					counter++;
				}
			}
		}
	}
	public void reservedPassengers(int x){
		for(int i = 0; i < x; i++){
			Passenger reserve = new Passenger(Integer.toString(i), "0", "resereved","vip");
			reserve.bookFlight(flights.get(random(flights.size())));
		}
	}
	
	
	//helper Methods
	private int random(int x){
		Random r = new Random();
		return (int)(r.nextInt(x));
	}
	private double setMinutes(double hour){
		DecimalFormat format = new DecimalFormat("0.00");
		return Double.parseDouble(format.format(hour + (double)random(60) / 100));
	}
	private int floor(double x){
		return (int)Math.floor(x);
	}
	
	
	
	//toString
	public String toString(){
		StringBuilder sb = new StringBuilder("");
		for(Flight x: flights){
			sb.append(x.toString() + "\n");
		}
		return sb.toString();
	}
	
}
