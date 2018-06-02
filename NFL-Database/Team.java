
public class Team
{
	public String [] team;
	private String [] location;
	private int[] stats; //rushing yards, passing yards and total points
	
	public Team(String [] team, String  [] location,  int [] stats)
	{
		this.team = team;
		this.location = location;
		this.stats = stats;
	}
	
	//accessors
	//team string
	public String getTeamName()
	{
		return team[0];
	}
	public String getInitials()
	{
		return team[1];
	}
	public String getStadium()
	{
		return team[2];
	}
	
	
	//location string
	public String getConference()
	{
		return location[0];
	}
	public String getRegion()
	{
		return location[1];
	}
	
	//stats int array
	public double getPassing()//also converts ints into doubles for later calculations
	{
		return stats[0];
	}
	public double getRushing()
	{
		return stats[1];
	}
	public double getPoints()
	{
		return stats[2];
	}
	public int getCapacity()
	{
		return stats[3];
	}
	
	
	//calculations
	public double totalYards()
	{
		return getRushing() + getPassing();
	}
	
	//a total of 16 games are played in the NFL season
	public double pg()// average points per game
	{
		return getPoints()/16;
	}
	public double rpg()// average rushing yards per game
	{
		return getRushing()/16;
	}
	public double ppg() // average passing yards per game
	{
		return getPassing()/16;
	}
	
	
	public String toString()// called from position for visual pleasure
	{
		return  team[0] +" ("+ team[1] +") Stadium: "+ team[2] 
				+" || location: "+ location[0] +" "+ location[1] 
				+" ||  totalYards: " + totalYards() +" || ppg: "+ pg() +" || rushing yards pg: "+ rpg() +" || passing yards pg: "+ 
				ppg();
	}
}
