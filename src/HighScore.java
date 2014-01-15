import java.io.*;
import java.util.*;
import javax.swing.*;

public class HighScore {

	public Vector<Player> highscore;

    public HighScore() 
    {
    	highscore = new Vector<Player>();
    }
	

    public void addPlayer(Player p)
    {
    	highscore.add(p);
    }
    public void showMe()
    {
    	for(int i=0; i<highscore.size();i++)
    	{
    		System.out.println(highscore.get(i).name+" "+highscore.get(i).score);
    	}
    }
    public void sortHighscore()
    {
    	Collections.sort(highscore);
    }
    
   	public void printHighscore()
   {
			try{
					PrintWriter utFil = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt")));
		
					for (int i=0;i<highscore.size();i++)
					{
						utFil.println(highscore.get(i).toString());
					}
					
					utFil.close();
				}
			catch(IOException e)
			{
				System.err.println("Det blev nog fel med filen!");
			}
	}
    
	public void readHighScore()
	{		                 
    	try {
    		String line="";		
	    		BufferedReader infile = new BufferedReader
	                               		(new FileReader("highscore.txt"));
	            while ((line = infile.readLine()) != null)
	            {
	            	StringTokenizer st = new StringTokenizer(line);
	
	            	String theName =st.nextToken();
	            	String theScore =st.nextToken();
	            	
	            	int intScore = Integer.parseInt(theScore);	            	
	            	Player thePlayer = new Player(theName, intScore);
	            	
		         	addPlayer(thePlayer);
	            }
			}catch (IOException e)  
			{
			}
			//highscore.showMe();
	}
}
