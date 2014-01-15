
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.*;

public class Tank2 extends Creep {

 private int randomness;
 private int randomFire;
 public static int price=50;


    public Tank2()
    {
    	randomness = (int)(Math.random()*10) - 5;
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank2.png");
    	image = iC.getImage();
    	x=70;
    	y+= randomness;
    	hp=25;
    	dmg=3;
    	speed = 1;
    	delay=30;
    	attackspeed=5;
    	price=50;
    }
    public void resetImage()
    {
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank2.png");
    	image = iC.getImage();
    }

    public void fireImage()
    {

		randomFire =(int)Math.ceil((Math.random()*3));

		if(randomFire==1)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank2Fire1.png");
	    	image = iC.getImage();
		}
		else if(randomFire==2)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank2Fire2.png");
	    	image = iC.getImage();
		}
		else
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank2Fire3.png");
		    image = iC.getImage();
		}
    }

}