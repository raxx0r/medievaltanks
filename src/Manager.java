

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.Image;

public class Manager {

	public Vector<Creep> defender;
	public static Vector<Creep> attacker;

	public Waves waves;

    public Manager()
    {
    	defender = new Vector<Creep>();
    	attacker = new Vector<Creep>();
    	waves = new Waves();
    }
///Places creeps in vector
    public  void insertDefender (Creep c){defender.add(c);}
    public static void insertAttacker (Creep c){attacker.add(c);}

///Return image
	public Image getDefenderImage(int i){return defender.get(i).getImage();}
	public Image getAttackerImage(int i){return attacker.get(i).getImage();}

///SKJUT
	public void defenderFire(int i){defender.get(i).fireImage();}
	public void attackerFire(int i){attacker.get(i).fireImage();}

	public void resetDefenderImage(int i){defender.get(i).resetImage();}
	public void resetAttackerImage(int i){attacker.get(i).resetImage();}


///Size of vector
    public int getDefenderSize(){return defender.size();}
    public int getAttackerSize(){return attacker.size();}

///Move defender/attacker
    public void moveDefender(int i,double b){defender.get(i).x+=b;}
    public void moveAttacker(int i,double b){attacker.get(i).x+=b;}

///Return x/y positions
    public int getDefenderX(int i){return defender.get(i).x;}
    public int getDefenderY(int i){return defender.get(i).y;}
    public int getAttackerX(int i){return attacker.get(i).x;}
	public int getAttackerY(int i){return attacker.get(i).y;}

///Places attacker/defender on given position (Isnt used?)
	public void setDefenderX(int i, int position){defender.get(i).x = position;}
    public void setDefenderY(int i, int position){defender.get(i).x = position;}
	public void setAttackerX(int i, int position){attacker.get(i).x = position;}
    public void setAttackerY(int i, int position){attacker.get(i).x = position;}

///Removes creep from vector
    public void killDefender(int i){defender.remove(i);}
    public void killAttacker(int i){attacker.remove(i);}

///Return true/false if the creep is moving
    public boolean getDefenderMovement(int i){return defender.get(i).movement;}
    public boolean getAttackerMovement(int i){return attacker.get(i).movement;}

///Stops the creep
    public void stopDefenderMovement(int i){defender.get(i).movement=false;}
    public void stopAttackerMovement(int i){attacker.get(i).movement=false;}

/// The creep starts to move.
    public void moveAttacker(int i){attacker.get(i).movement=false;}
	public void moveDefender(int i){defender.get(i).movement=true;}

///Return HP
    public int getDefenderHP(int i){return defender.get(i).hp;}
    public int getAttackerHP(int i){return attacker.get(i).hp;}

///Return damage
    public int getDefenderDamage(int i){return defender.get(i).dmg;}
	public int getAttackerDamage(int i){return attacker.get(i).dmg;}

///Return movementspeed
    public double getAttackerSpeed(int i){return attacker.get(i).speed;}
	public double getDefenderSpeed(int i){return defender.get(i).speed;}

///Sets hp
    public void setDefenderHP(int i, int d){defender.get(i).hp-=d;}
	public void setAttackerHP(int i, int d){attacker.get(i).hp-=d;}

///Return attackspeed
    public int getDefenderAttackSpeed(int i){return defender.get(i).attackspeed;}
	public int getAttackerAttackSpeed(int i){return attacker.get(i).attackspeed;}

///Sets attackspeed
    public void setDefenderAttackSpeed(int i,int a){defender.get(i).attackspeed-=a;}
    public void setAttackerAttackSpeed(int i,int a){attacker.get(i).attackspeed-=a;}

///Resets attackspeed
    public void resetAttackerAttackSpeed(int i){attacker.get(i).attackspeed=attacker.get(i).delay;}
    public void resetDefenderAttackSpeed(int i){defender.get(i).attackspeed=defender.get(i).delay;}

///Return true/false depending if creeps are fighting or not
    public boolean getDefenderFighting(int i){return defender.get(i).fighting;}
    public boolean getAttackerFighting(int i){return attacker.get(i).fighting;}

///Sets t/f if creeps are fighting
    public void setDefenderFighting(int i, boolean b){defender.get(i).fighting=b;}
    public void setAttackerFighting(int i, boolean b){attacker.get(i).fighting=b;}

///Return delay
    public int getDefenderDelay(int i){return defender.get(i).delay;}
    public int getAttackerDelay(int i){return attacker.get(i).delay;}

    public int getAttackerValue(int i){return attacker.get(i).value;}

}