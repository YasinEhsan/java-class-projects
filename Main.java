import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		
		
		System.out.println("Ready to book your flights. Enter your first and last name please: ");
		String firstName = read.next();
		String lastName = read.next();
		
		System.out.println("Type your address on one line please: ");
		read.nextLine();
		String add = read.nextLine();
		
		System.out.println("Type your phone number on one line please: ");
		String phone = read.nextLine();
		
		System.out.println("Ready to book your flights between Kennedy and Laguardia for October 2017 ");
		System.out.println("Do you want to book or cancel a flight? Answer Yes of No:");
		String response = read.next();
		
		if (response.equalsIgnoreCase("yes")){
			System.out.println("Enter C to cancel, K for a flight from Kennedy or L for a flight from Laguardia ");
			String response2 = read.next();
			
			if(response2.equalsIgnoreCase("k")){
				System.out.println(firstName + lastName + add + phone + response);
			}
			else if(response2.equalsIgnoreCase("c")){
				
			}
			else{
				
			}
			
		}
		else if(response.equalsIgnoreCase("no")){
			
		}
		else{
			System.out.println("YOU ENTERED WRONG");
		}
	
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
	}

}
