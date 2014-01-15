public class Player implements Comparable<Player> {
	String name;
	int cash;
	int score;
	int tank1;
	int tank2;
	int tank3;

    public Player() {
    }
    
    public Player(String theName, int theScore)
    {
    	name=theName;
    	score=theScore;
    }

    public void insertCash(int theCash){
    	cash += theCash;
    }

    public void insertName(String theName){
    	name = theName;
    }

    public void insertScore(int theScore){
    	score += theScore;
    }
    public int compareTo(Player p)
    {
		if(score >(p.score))
		{
			return -1;
		}
		else if(score <(p.score))
		{
			return 1;
		}
		else return 0;
	
	}
	public String scoreToString()
	{
		return score+"";
	}
	public String toString()
	{
		return name + "    " + score;
	}

}