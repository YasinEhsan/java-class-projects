import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		Employee user = new Employee(); //initializes new Employee
		String file = "out.txt"; 
		PrintWriter output = null;
		FileReader fr = null;
		BufferedReader br = null;
		Random generate = new Random();
		double avSalary = 0;
		String[] names = {"Aaron", "Yasin", "Dimitri", "Escobar", "Rajesh"};
		int counter = 0;
		
		
		System.out.println("WELCOME TO STAFF REGISTRAR \nEnter your first name: ");
		user.setName(read.nextLine()); 
		System.out.println("enter Social-Security: ");
		while(true) {
			try {
				user.setSsn(chk(read.next().replaceAll("-", "")));//chk is a helper method
				break;
			}
			catch(SSNLengthException f) {
				System.out.print("WRONG LENGTH. Enter again: \n");
			}
			catch(SSNCharacterException j) {
				System.out.println("Acceptable characters: numbers 0-9 AND '-' "
						+ "\nEnter again: \n");
			}
		}
		
		System.out.println("enter salary: ");
		while(true) {
			try {
				user.setSalary(chkSalary(read.nextDouble()));
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("ENTER DIGITS ONLY. Enter again: \n"); //returns if input is non-digit
			}
			catch(Exception e) {
				System.out.println("ENTER 'POSITIVE' DIGITS ONLY. Enter again: \n");//returns if input is negative
			}
		}
		
		try {
			 output = new PrintWriter(file); //creates new file everytime program is run
			// output = new PrintWriter(new FileOutputStream(file, true));//appends new data to existing data or creates new data file
			 
			 for(int i = 0; i < 99; i++) { //generates 10 random Employees each time program runs
					output.println(new Employee(names[generate.nextInt(100) % 5], //names is string array of length 5
							(generate.nextInt(900000000) + 100000000 ) + "", //generates random 9 digit number (social-security)
							(40000 + generate.nextInt(100000)))); // generates a random salary between 40k-140k
				}
			 
			 while(true) { //adds the user data to txt file
				 output.println(user);
				 break;
			 }
			 
		}
		catch(FileNotFoundException e) {
			System.out.print("error opening file");
			System.exit(0);
		}
		finally{
			output.close();
		}
		
		//reads data
		try {
			br = new BufferedReader(new FileReader(file)); //instantiates object to read data
			String str;
			
			while((str = br.readLine()) != null) {
				counter++;
				String [] arry = str.split(" ");
				System.out.print("Employee No." + counter + "\t");
				for(int i = 0; i < arry.length; i++) {
					if(i % 2 == 1)
						System.out.print( arry[i] + "\t"); // Prints all Employee data
					else 
						System.out.print(arry[i]);
					
				}
				System.out.println();
				avSalary += Double.parseDouble(arry[5]); //sum of all the Employee Salaries
			}
				
			br.close();
		}
		catch(IOException x) {
			System.out.print("file not found");
		}
		catch(NumberFormatException e) {}
		avSalary = avSalary / counter;
		System.out.println("\n\n");
		
		if(avSalary > user.getSalary()) {
			System.out.print("Your salary is lower than others. Work harder!");
		}
		else if(avSalary < user.getSalary()) {
			System.out.print("Your salary is higher than others. Congrats!");
		}
		else {
			System.out.print("Your salary is exactly average. Just put a little more effort!");
		}
	}
	private static String chk(String ssn) throws SSNCharacterException, 
	SSNLengthException  {
		if(!(ssn.length() == 9))
			throw new SSNLengthException(); 
		if(!ssn.matches("\\d{9}"))
			throw new SSNCharacterException();
		return ssn;
	}
	private static double chkSalary(double salary) throws Exception {
		if((salary < 0))  
			throw new Exception();
		//salary.matches("\\d*(\\.\\d{1,2})?") can be used... read.Next instead of read.Double
		return salary;
	}
}
