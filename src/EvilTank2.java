
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.*;

public class EvilTank2 extends Creep {

	private int randomness;
	private int randomFire;

    public EvilTank2()
    {
    	randomness = (int)(Math.random()*10) - 5;
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank2Evil.png");
    	image = iC.getImage();
    	x=800;
    	y+= randomness - 15;
    	hp=25;
    	speed=-1;
    	dmg=3;
    	delay=50;
    	attackspeed=5;
    	value=40;
    }
    public void resetImage()
    {
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank2Evil.png");
    	image = iC.getImage();
    }

    public void fireImage()
    {

		randomFire =(int)Math.ceil((Math.random()*3));

		if(randomFire==1)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank2EvilFire1.png");
	    	image = iC.getImage();
		}
		else if(randomFire==2)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank2EvilFire2.png");
	    	image = iC.getImage();
		}
		else
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank2EvilFire3.png");
		    image = iC.getImage();
		}
    }
}