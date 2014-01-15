
import javax.swing.ImageIcon;


public class Tank1 extends Creep {

 private int randomness;
 private int randomFire;
 public static int price=10;


    public Tank1()
    {
    	randomness = (int)(Math.random()*10) - 5;
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank1.png");
    	image = iC.getImage();
    	x=70;
    	y+= randomness;
    	hp=5;
    	dmg=1;
    	speed = 2;
    	delay=20;
    	attackspeed=5;
    	
    }
    public void resetImage()
    {
    	ImageIcon iC = new ImageIcon("images/Tanks/Tank1.png");
    	image = iC.getImage();
    }

    public void fireImage()
    {

		randomFire =(int)Math.ceil((Math.random()*3));

		if(randomFire==1)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1Fire1.png");
	    	image = iC.getImage();
		}
		else if(randomFire==2)
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1Fire2.png");
	    	image = iC.getImage();
		}
		else
		{
			ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1Fire3.png");
		    image = iC.getImage();
		}
    }

}