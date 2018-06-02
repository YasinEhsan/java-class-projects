import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.FocusTraversalPolicy;
import java.io.File;
import java.util.Scanner;

import sun.management.counter.Variability;

public class TeamReader 
{
	public static void main(String[] args) throws Exception
	{
		String filename = "theDatabase.csv";
		File inputFile = new File(filename);
		if(!inputFile.exists())
			System.out.println("File does not exist.");
		else
		{
			Scanner input = new Scanner(inputFile);
			ArrayList<Team> theTeams = new ArrayList<Team>();
		
			input.nextLine();  //read heading line
			String rowOfData;
			String[] splitRowOfData;
			
			while (input.hasNextLine())	
			{
				rowOfData = input.nextLine();
				splitRowOfData = rowOfData.split(",");
				//System.out.println(Arrays.toString(splitRowOfData));
				String [] team = new String [3];
				for(int i =0; i < team.length; i++)
					team[i] = splitRowOfData[i];//0 1 2
				
				String [] location = new String [2];
				for(int i =0; i < location.length; i++)
					location[i] = splitRowOfData[i + 3];//3,4
					
				
				
				
				int[] stats = new int[4];
				for (int i = 0; i < stats.length; i++)
					stats[i] = Integer.parseInt(splitRowOfData[i + 5]);//5 6 7 8
					
			
				//instantiate new Student
				theTeams.add( new Team(team, location, stats)); 
				//haas to match up with constructor
			}
			
			
			
			
			Teams nflPrint = new Teams(theTeams);
			//System.out.println(nflPrint);
			System.out.println("____________________________________________________________________________________________________________________");
			
			
			
			nflPrint.orderValues(); //orders from greatest to least
			

			
			ArrayList<Team> remove = nflPrint.removeRegion("WEST");//returns teams which are located in "west"
			for(Team s: remove)
			{
				System.out.println(s);
			}
			System.out.println("____________________________________________________________________________________________________________________");
		
			
			
			ArrayList<Team> west = nflPrint.sortRegion("EaST");
			for(Team s: west)
			{
				System.out.println(s);
			}
			System.out.println("____________________________________________________________________________________________________________________");
			
			
			
			
			
	
			
		
			
				
			
			
			
			
			
		}//end else			
	}//end of main method
}
