import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Formatter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
public class Main {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		Airline delta = new Airline("Emirates");
		
		
		
		delta.generate();//generates a flight every hour each day in October both ways
		delta.reservedPassengers(1000000); //creates x numbers of randomly generated passengers
		//System.out.println(delta.toString()); //prints out all possible flights (372,000)
		
		
		aesthetic(24);
		System.out.println("\n  Welcome to Emirates");
		aesthetic(24);
		System.out.println("\n");
		System.out.println("Ready to book your international flights. Enter your first and last name please: ");
		String firstName = read.next();
		String lastName = read.next();
		System.out.println("Type your address on one line please: ");
		read.nextLine();
		String add = read.nextLine();
		System.out.println("Type your phone number on one line please: ");
		String phone = read.nextLine();
		
		
		Passenger user = new Passenger(firstName, lastName, add, phone); 
		ArrayList <Ticket> tickets = user.getTickets();
		
		System.out.println("Ready to book your flights between Dubai and the world for October 2017 ");
		System.out.println("Do you want to book or cancel a flight? Answer Yes oR No:");
		String response = read.next();
		
		while(response.equalsIgnoreCase("yes")){
				System.out.println("\nYou will now enter some travel info...");
				aesthetic(45);
				System.out.println("\nIf your comming to Dubai from another country, Enter the FIRST LETTER of the departing country OR..."
						+ "\nIf your departing from Dubai to another country, Enter 'Dubai' OR..."
						+ "\nEnter '-1' to cancel flight(s)");
				String response2 = read.next();
				
				
				if(response2.equalsIgnoreCase("-1")){
					System.out.println("Here are the tickets you have booked:");
					
					for(int i = 0; i < tickets.size(); i++){
						System.out.println((i + 1) + " " + user.toString2() 
						+ tickets.get(i).toString());//wrongToString
					}
					System.out.println("type the number of the ticket you want to cancel");
					int cancel = Integer.parseInt(read.next());
					tickets.get(cancel - 1).cancel();
					
					System.out.println("Do you want to book or cancel a flight? Answer Yes oR No:");
					response = read.next();
				}
				
				
				else if(response2.equalsIgnoreCase("dubai")){
					String start = "";
					boolean chk = false;
					ArrayList <String> nations = delta.getNations();
					
					System.out.println("\nYour flight from Dubai is almost underway...");
					System.out.println("Enter first letter from destination country");
					start = read.next();
					
					for(String x:nations ){
						if(x.substring(0,1).equalsIgnoreCase(start)){
							System.out.println(x);
						}	
					}
					
					System.out.println("\nWhich of the above countries will you depart from:");
					read.nextLine();
					String response3 = read.nextLine();
					for(String x: nations){
						if(response3.trim().equalsIgnoreCase(x)){
							start = x;
							chk = true;
						}
					}
					if(!chk)
						break;
					else{
						System.out.println("Enter the day in oct you want to fly: ");
						int day = read.nextInt();
						String date = "10." + Integer.toString(day) + ".17";
						System.out.println("Enter an hour you would like to fly (Range 0-23): ");
						int time = read.nextInt();
						System.out.println("\nAvailable Flights: ");
						
						
						ArrayList <Flight> flights = delta.findFlights(date, time, "Dubai");
						for(int i = 0; i < flights.size(); i++)
							if(flights.get(i).getDestination().equalsIgnoreCase(start))
								System.out.println(flights.get(i).toString());
						
						System.out.println("type the number of flight you wish to book");
						int flightNum = read.nextInt();
						boolean booking = false;
						for(int j = 0; j < flights.size(); j++){
							if(flights.get(j).getFlightNumber() == flightNum){
								user.bookFlight(flights.get(j));
								System.out.println("Successfully booked ticket!");
								booking = true;
							}
						}
						if(!booking)
							wrongInput();

						System.out.println("Do you want to book or cancel a flight? Answer Yes oR No:");
						response = read.next();
					}
				}
				else{
					String dest = "";
					boolean chk = false;
					ArrayList <String> nations = delta.getNations();
					
					
					for(String x:nations ){
						if(x.substring(0,1).equalsIgnoreCase(response2)){
							System.out.println(x);
						}	
					}
					
					System.out.println("\nEnter one of the countries above:");
					read.nextLine();
					String response3 = read.nextLine();
					for(String x: nations){
						if(response3.trim().equalsIgnoreCase(x)){
							dest = x;
							chk = true;
						}
					}
					if(!chk)
						break;
					else{
						System.out.println("Enter the day in oct you want to fly: ");
						int day = read.nextInt();
						String date = "10." + Integer.toString(day) + ".17";
						System.out.println("Enter an hour you would like to fly (Range 0-23): ");
						int time = read.nextInt();
						System.out.print("\nAvailable Flights: ");
						
						
						ArrayList <Flight> flights = delta.findFlights(date, time, dest);
						System.out.println(flights.size());
						for(int i = 0; i < flights.size(); i++)
							System.out.println(flights.get(i).toString());
						
						System.out.println("type the number of flight you wish to book");
						int flightNum = read.nextInt();
						boolean booking = false;
						for(int j = 0; j < flights.size(); j++){
							if(flights.get(j).getFlightNumber() == flightNum){
								user.bookFlight(flights.get(j));
								System.out.println("Successfully booked ticket!");
								booking = true;
							}
						}
						if(!booking)
							System.out.println("You entered wrong");

						System.out.println("Do you want to book or cancel a flight? Answer Yes oR No:");
						response = read.next();
					}
					
				}		
		}
		if(response.equalsIgnoreCase("no")){
			System.out.println("thank you for booking with Delta");
			System.out.println("here is a list of your bookings");
			for(Ticket x: tickets)
				System.out.println(user.toString2() + x.toString());
		}
		else{
			wrongInput();
		}
	}
	
	public static void wrongInput(){
		System.out.println("YOU ENTERED WRONG");
	}
	public static void aesthetic(int n){
		for(int i = 0; i < n; i++)
			System.out.print("*");
	}
}
