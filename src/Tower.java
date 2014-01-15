

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;

public class Tower extends Creep {

	public boolean movement= false;
	public Image[] upgrade1 = new Image[92];
	public Image tempImage;
	public static int price1 = 300;
	public static int price = 60;

    public Tower()
    {
    	x=-7;
    	y=165;
    	hp=50;
    	ImageIcon iC = new ImageIcon("images/castle1.png");
    	image = iC.getImage();
    }

    public void initImages()
    {
    	int space=0;
    	for (int i=0;i<10;i++)
    	{
    		String s = "images/Animation 1-2/"+i+".png";

    		ImageIcon iC = new ImageIcon(s);

    		tempImage = iC.getImage();

    		for(int j=0;j<4;j++)
    		{
    			upgrade1[space]=tempImage;
    			space++;
    		}
    	}

    	for (int i=0;i<13;i++)
    	{
    		String s = "images/Animation 2-3/"+i+".png";

    		ImageIcon iC = new ImageIcon(s);

    		tempImage = iC.getImage();

    		for(int j=0;j<4;j++)
    		{
    			upgrade1[space]=tempImage;
    			space++;
    		}
    	}
    }

    public void upgradeTower(int stage)
    {
    	if (stage==1)
    	{
 			hp=100;
    	}
    	else if (stage==2)
    	{
 			hp=200;
    	}
    }

    public Image getUpgradeImage(int i)
    {
    	System.out.println(i);
    	return upgrade1[i];
    }
    public void setImage(int stage)
    {
    	if(stage==1)
    	{
    	ImageIcon iC = new ImageIcon("images/castle2.png");
    	image = iC.getImage();
    	}
    	if(stage==2)
    	{
    	ImageIcon iC = new ImageIcon("images/castle3.png");
    	image = iC.getImage();
    	}
    }





}