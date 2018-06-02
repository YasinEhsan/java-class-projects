//Yasin Ehsan
//AP JAVA Project

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PasswordGenerator
{
	private char [] options;
	private ArrayList<String> stockpile = new ArrayList<String>();//Mr. Goldman's hint
	
	public PasswordGenerator()
	{
		options = new char [68];
		
		int i = 0;
		char ch = 'A';
		for(; ch <= 'Z'; i++, ch++)
			options[i] = ch;
		
		for(ch = 'a'; ch <= 'z'; i++, ch++)
			options[i] = ch;
		
		for(ch = '0'; ch <= '9'; i++, ch++)
			options[i] = ch;
		
		options[i] = '_';
		i++;
		options[i] = '-';
		i++;
		options[i] = '$';
		i++;
		
		options[i] = '%';
		i++;
		options[i] = '#';
		i++;
		options[i] = '@';
		i++;
	}
	
	
	
	public static void main (String[] args) throws Exception
	
	{
		PasswordGenerator pg = new PasswordGenerator();
		pg.savePassword();
	}

	
	public void printOptions() //testing Purposes
	{
		for(int i = 0; i < options.length; i++)
		{
			System.out.println("Options [" + i + "] = " + options[i]);
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void savePassword() throws Exception
	{
		FileWriter fw = new FileWriter ("StoredPasswords.txt");
		for (int i =0; i < pwIndex; i++)
		{
			fw.write(stockpile.get(i) + "\n");
		}
		fw.close();
		
		PasswordGenerator pg = new PasswordGenerator();
		Scanner scan = new Scanner(System.in);
		int pwIndex = 0;
		
		try
		{
			Scanner sc = new Scanner (new File("StoredPasswords.txt"));
			while (sc.hasNext())
			{
				String str = sc.nextLine();
				stockpile.add(str);
				pwIndex++;
			}
			sc.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		boolean exitProgram = false;
		while(!exitProgram)
		{	
			int track = 0;
			while(true)
			{	
				if(pwIndex == 0)
				{		
					System.out.println();
					System.out.println("------------------------------------------------------------------------------");
					System.out.println("Please ignore the java errors. Go ahead and select an alphanumeric!");
					System.out.println("This only shows before a NEW txt file is made");
				}
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Click on any alphaNumeric to generate a new Password: ");
				System.out.println("Type 'end' to stop generating and save all recent password(s) ");
				System.out.print("---> Now, enter your choice: ");
				System.out.println();
				track++;
				
				
				String menuChoice2 = scan.next();
				if(menuChoice2.equalsIgnoreCase("end")) 
				{
					System.out.println();
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("CONGRATS, your program just ended");
					System.out.println("You just saved " + (track -1) + " UNIQUE password(s) into a txt file");
					System.out.println("Now, you have a total of " + pwIndex + " UNIQUE password(s) saved into a txt file");
					System.out.println();
					System.out.println("The txt file is stored right besides the src file (at least in Eclipse)");
					exitProgram = true;
					break; //return will quit the function, break will quit the while loop
				}
				
				
				String  password = pg.generate();
				for (int i =0; i < pwIndex; i++)
				{
					if(password == stockpile.get(i))
					{
						System.out.println("same password. try again! ");
						break;
					}
				}
				stockpile.add(password);
				pwIndex++;
				System.out.println("Password Generated: " + password);
				System.out.println();
				System.out.println();
				//return password;
			}
		}
		
		
		
		
	}
	
	public boolean isNumeric( char ch)
	{
		return ch >= '0' && ch <= '9';
	}
	
	public boolean isLowerAlpha( char ch)
	{
		return ch >= 'a' && ch <= 'z';
	}
	
	public boolean isUpperAlpha( char ch)
	{
		return ch >= 'A' && ch <= 'Z';
	}
	
	public boolean hasNumeric(char [] ch)
	{	
		for(int i = 0; i < ch.length; i++)
		{
			if(isNumeric(ch[i]))
				return true;
		}
		return false;
	}
	
	public boolean hasLowerAlpha(char [] ch)
	{	
		for(int i = 0; i < ch.length; i++)
		{
			if(isLowerAlpha(ch[i]))
				return true;
		}
		return false;
	}
	
	public boolean hasUpperAlpha(char [] ch)
	{	
		for(int i = 0; i < ch.length; i++)
		{
			if(isUpperAlpha(ch[i]))
				return true;
		}
		return false;
	}
	
	public boolean validate(char[] ch)
	{
		return hasUpperAlpha(ch) && hasLowerAlpha(ch) && hasNumeric(ch);
	}
	
	public static int getRandomNumber(int low, int high)
	{
		int options = 0;
		if(low > high)
		{
			int temp = high;
			high = low;
			low = temp;
		}
		
		options = (int)(Math.random()*(high-low +1));
		return options + low;
	}	
	
	public char getAlpha()
	{
		return options[getRandomNumber(0,51)];
	}
	
	public char getAlphaNumeric()
	{
		return options[getRandomNumber(0,61)];
	}
	
	public char getSpecialChar()
	{
		return options[getRandomNumber(62,67)];
	}
	
	public String generate()
	{
		
		boolean valid = false;
		int plength = getRandomNumber(8,12);
		char [] cpassword = new char[plength];
		while(!valid)
		{
			cpassword[0] = getAlpha();
			
			for(int i =1; i < cpassword.length; i++)
				cpassword[i] = getAlphaNumeric();
			
			int pos = getRandomNumber(1, cpassword.length -2);
			cpassword[pos] = getSpecialChar();
			valid = validate(cpassword);
		}
		
		String password = "";
		for(int i =0; i < cpassword.length; i++)
			password += cpassword[i];
	
		//storedPassword [pos2] = password;
		//pos2++;
		return password;
	}
}
