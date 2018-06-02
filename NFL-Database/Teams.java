
import java.util.ArrayList;
public class Teams 
{
	private ArrayList<Team> nfl;
	
	public Teams(ArrayList<Team> theTeams)
	{
		nfl = theTeams;
	}
	
	/* tried to select only certain columns: errors exist!! 
	public String[] getTeamInfo()
	{
		int count = 0;
		for(int i = 0; i < nfl.size(); i ++)
			count++;
		
		String [] batch = new String[count];
		
		for(int i = 0; i < nfl.size(); i ++)
			batch[i] = batch[nfl.get(i).getTeamName()];
		return batch;
	}
	*/
	
	
	public ArrayList<Team> sortConference(String con)
	{
		ArrayList<Team> batch = new ArrayList<Team>();
		for(Team s: nfl)
		{
			if(s.getConference().equalsIgnoreCase(con))
			{
				batch.add(s);
			}
		}
		return batch;
	}
	public ArrayList<Team> sortRegion(String re)// this method is same as the one above just different parameter
	{
		ArrayList<Team> batch = new ArrayList<Team>();
		for(Team s: nfl)
		{
			if(s.getRegion().equalsIgnoreCase(re))
			{
				batch.add(s);
			}
		}
		return batch;
	}
	public ArrayList<Team> removeRegion(String re)// removes desired region WORKS FINNALY 
	{
		ArrayList<Team> refineRegion = new ArrayList<Team>(); //a list of 32 teams

		for(Team s: nfl)
		{
			if (!s.getRegion().equalsIgnoreCase(re)) //the golden line!
			{
				refineRegion.add(s);
			}
		}
		return refineRegion;
	}
	
	
	public void  orderValues()
	{
		for(int currentIndex =0; currentIndex < nfl.size(); currentIndex++ )
		{
			//int currentIndex = 0;
			int largestIndex = currentIndex;
			for(int i = currentIndex + 1; i <nfl.size(); i++)
			{
				if ( nfl.get(largestIndex).totalYards() < nfl.get(i).totalYards())
					largestIndex = i;
				
			}
			swap(currentIndex, largestIndex);
		}
	}
	public void swap(int a, int b)
	{
		Team temp = nfl.get(a);
		nfl.set(a, nfl.get(b));
		nfl.set(b, temp);
	}
	
	
	public String toString()
	{
		String output = "";
		for (Team t: nfl)
		{
			output += t.toString() + "\n";
		}
		return output;
	}

}
