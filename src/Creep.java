
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;

public class Creep extends JPanel  {

	public int x;
    public int y;
    public int hp;
    public int dmg;
    public int delay;
    public int attackspeed;
    public double speed;
    public boolean movement= true;
    public boolean fighting=false;
    public Image image;

    public int value;
    public int price;

    public Creep()
    {
    	value = 5;
    	delay = 5;
    	y=330;
    }

    public Image getImage()
    {
    	return image;
    }

    public void fireImage()
    {
		ImageIcon iC = new ImageIcon("images/Tanks/FIRE/Tank1Fire1.png");
    	image = iC.getImage();
    }

    public void resetImage(){}

}
