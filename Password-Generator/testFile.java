import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class testFile 
{
	
	public static void savePassword(String str) throws Exception
	{
		FileWriter fw = new FileWriter ("password.txt");
		fw.write(str + "\n");
		fw.close();
	}
	
	public static void main (String[] args) throws Exception
	
	{
		PasswordGenerator pg = new PasswordGenerator();
		Scanner scan = new Scanner(System.in);
		
	
		int pwIndex = 0;
		//String [] storedPassword = new String [pwIndex];
		ArrayList<String> storedPassword = new ArrayList<String>();
		
		
		try
		{
			Scanner sc = new Scanner (new File("password.txt"));
			System.out.println("_________________");
			while (sc.hasNext())
			{
				String str = sc.nextLine();
				
				storedPassword.add(str);
				pwIndex++;
			}
			sc.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		boolean exitProgram = false;
		
		for (int j=0; j<100; j++) {
		
		while(!exitProgram)
		{
		
			while(true)
			{
				
				System.out.println("Type 'yes' to Generate new Password: ");
				System.out.println(" Type  'quit' to stop generating  ");
				System.out.print("----> Now, type your choice: ");
				System.out.println();
				
				
				//int menuChoice = scan.nextInt();
				//String menuChoice2 = scan.next();
				String menuChoice2 = "yes";
				
				if(menuChoice2.equalsIgnoreCase("end")) 
				{
					System.out.println("Your program just ended");
					exitProgram = true;
					break; //return will quit the function
				}
				String password = pg.generate();
				
				
				for (int i =0; i < pwIndex; i++)
				{
					if(password == storedPassword.get(i))
					{
						System.out.println("*****same password. try again! ");
						break;
					}
				}
				storedPassword.add(password);
				pwIndex++;
				System.out.println(password);	
			}
		}
		
		}
		
		
		FileWriter fw = new FileWriter ("password.txt");//keeps appending
		for (int i =0; i < pwIndex; i++)
		{
			fw.write(storedPassword.get(i) + "\n");
		}
		fw.close();
		
	}
}
