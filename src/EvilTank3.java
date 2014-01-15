
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.*;

public class EvilTank3 extends Creep {

	private int randomness;
	private int randomFire;

    public EvilTank3()
    {
    	randomness = (int)(Math.random()*10) - 5;
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank3Evil.png");
    	image = iC.getImage();
    	x=800;
    	y+= randomness;
    	hp=70;
    	speed=-1;
    	dmg=11;
    	delay=50;
    	attackspeed=5;
    	value=100;
    }

    public void resetImage()
    {
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank3Evil.png");
    	image = iC.getImage();
    }

    public void fireImage()
    {

		randomFire =(int)Math.ceil((Math.random()*3));

		if(randomFire==1)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank3EvilFire1.png");
	    	image = iC.getImage();
		}
		else if(randomFire==2)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank3EvilFire2.png");
	    	image = iC.getImage();
		}
		else
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank3EvilFire3.png");
		    image = iC.getImage();
		}
    }
}