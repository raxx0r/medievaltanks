
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.*;

public class Tank3 extends Creep {

 private int randomness;
 private int randomFire;
 public static int price=200;
 
 


    public Tank3()
    {
    	randomness = (int)(Math.random()*10) - 5;
    	ImageIcon iC = new ImageIcon(this.getClass().getResource(("Tanks/Tank3.png")));
    	image = iC.getImage();
    	x=70;
    	y+= randomness;
    	hp=150;
    	dmg=10;
    	speed = 1;
    	delay=40;
    	attackspeed=5;
    	price=200;
    }

    public void resetImage()
    {
    	ImageIcon iC = new ImageIcon(this.getClass().getResource(("Tanks/Tank3.png")));
    	image = iC.getImage();
    }

    public void fireImage()
    {

		randomFire =(int)Math.ceil((Math.random()*3));

		if(randomFire==1)
		{
			ImageIcon iC = new ImageIcon(this.getClass().getResource(("Tanks/FIRE/Tank3Fire1.png")));
	    	image = iC.getImage();
		}
		else if(randomFire==2)
		{
			ImageIcon iC = new ImageIcon(this.getClass().getResource(("Tanks/FIRE/Tank3Fire2.png")));
	    	image = iC.getImage();
		}
		else
		{
			ImageIcon iC = new ImageIcon(this.getClass().getResource(("Tanks/FIRE/Tank3Fire3.png")));
		    image = iC.getImage();
		}
    }

}