

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.*;

public class EvilTank1 extends Creep {

	private int randomness;
	private int randomFire;

    public EvilTank1()
    {
    	randomness = (int)(Math.random()*10) - 5;
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank1Evil.png");
    	image = iC.getImage();
    	x=770;
    	y+= randomness;
    	hp=5;
    	speed=-2;
    	dmg=1;
    	delay=20;
    	attackspeed=5;
    	value=15;
    }

    public void resetImage()
    {
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank1Evil.png");
    	image = iC.getImage();
    }

    public void fireImage()
    {

		randomFire =(int)Math.ceil((Math.random()*3));

		if(randomFire==1)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1EvilFire1.png");
	    	image = iC.getImage();
		}
		else if(randomFire==2)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1EvilFire2.png");
	    	image = iC.getImage();
		}
		else
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1EvilFire3.png");
		    image = iC.getImage();
		}
    }
}