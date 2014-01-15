
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class Board extends JPanel implements ActionListener {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int DELAY = 60;
    private final int GAP = 85;

    String highscoreName;

	private ImageIcon iA = new ImageIcon("images/Gameover.png");

    public boolean inGame = true;
    public boolean pause = false;
    private boolean highscoreCheck = true;
    private boolean printHighScore = false;
    public boolean goToMenu = false;
	public Player johnDoe = new Player();

	private ImageIcon iC = new ImageIcon("images/BG#1.png");
	private ImageIcon iB = new ImageIcon("images/PAUSE.png");



    public Timer timer;
    //private Timer fightTimer;
	private Creep test;

	public int upgradeStage=0;
	public int upgradePhase=0;

	public Tower yourTower;

	public Manager manager;
	public boolean newGame = false;


	public int healthBar = 1;



    public Board()
    {


       	manager = new Manager();


	     setBackground(Color.white);

		 yourTower = new Tower();
		 yourTower.initImages();

	     setFocusable(true);
	     initGame();

	    johnDoe.insertName("August");
	    johnDoe.insertCash(15);


    }


    public void initGame() {


        timer = new Timer(DELAY, this);
        timer.addActionListener(manager.waves.doWave);
       // fightTimer = new Timer(100,this);
        //fightTimer.start();
        timer.start();




    }
    public void gameOver(Graphics g) {
    		if(goToMenu==true)
    		{

	    		g.drawImage(iA.getImage(), 185, 90, null);

				newGame = true;
    		}
    }

    public void paint(Graphics g) {
        super.paint(g);
		g.drawImage(iC.getImage(), 0, 0, null);
		if(!pause){

	        if (inGame) {

	        	for(int i=0; i<manager.getDefenderSize();i++)
	        	{
	                 g.drawImage((manager.getDefenderImage(i)), manager.getDefenderX(i), manager.getDefenderY(i), this);
	        		 Toolkit.getDefaultToolkit().sync();
	        	}
	        	for(int i=0; i<manager.getAttackerSize();i++)
	        	{
	                 g.drawImage((manager.getAttackerImage(i)), manager.getAttackerX(i), manager.getAttackerY(i), this);
	                 Toolkit.getDefaultToolkit().sync();
	        	}
	        	if(upgradeStage==1)
	        	{
	        		healthBar = 2;
	        		if(upgradePhase<40)
	        		{
		        		g.drawImage(yourTower.getUpgradeImage(upgradePhase),yourTower.x,yourTower.y,this);
		      			upgradePhase++;
	        		}
	        		else
	        		{
	        			yourTower.setImage(1);
	        			yourTower.upgradeTower(1);
	        			g.drawImage(yourTower.getImage(),yourTower.x,yourTower.y,this);
	        			upgradeStage=0;
	        		}
	        	}
	        	else if(upgradeStage==2)
	        	{
	        		healthBar = 3;
	        		if(upgradePhase<92)
	        		{
		        		g.drawImage(yourTower.getUpgradeImage(upgradePhase),yourTower.x,yourTower.y,this);
		      			upgradePhase++;
	        		}
	        		else
	        		{
	        			yourTower.setImage(2);
	        			yourTower.upgradeTower(2);
	        			g.drawImage(yourTower.getImage(),yourTower.x,yourTower.y,this);
	        			upgradeStage=0;
	        		}
	        	}

	        	else
	        	{
	        		g.drawImage(yourTower.getImage(),yourTower.x,yourTower.y,this);

	        		if(healthBar == 1)
					{
						g.setColor(new Color(200,0,0));
						g.fillRect(yourTower.x+50, yourTower.y+82, 50,6);
						g.setColor(new Color(30,200,30)) ;
					  	g.fillRect(yourTower.x+50, yourTower.y+82, yourTower.hp,6);

					}
					else if(healthBar == 2)
					{
						g.setColor(new Color(200,0,0));
						g.fillRect(yourTower.x+56, yourTower.y+70, 100,6);
						g.setColor(new Color(30,200,30)) ;
					  	g.fillRect(yourTower.x+56, yourTower.y+70, yourTower.hp,6);
					}
					else if(healthBar == 3)
					{
						g.setColor(new Color(200,0,0));
						g.fillRect(yourTower.x+25, yourTower.y-1,200,6);
						g.setColor(new Color(30,200,30)) ;
	        			g.fillRect(yourTower.x+25, yourTower.y -1, yourTower.hp,6);

					}
	        	}
	        }
	        else gameOver(g);
		}
		else pauseGamePaint(g);
    }


/*
 	        		if(upgradePhase>=40 && upgradePhase<92)
	        		{
	        			g.drawImage(yourTower.getUpgradeImage(upgradePhase),yourTower.x,yourTower.y,this);
		      			upgradePhase++;
	        		}*/



	public void pauseGame(){
		if(pause)
		{
			pause = false;
			manager.waves.pause=false;
		}


		else
		{
			pause = true;
			manager.waves.pause=true;
		}

	}
    public void pauseGamePaint(Graphics g) {
        String msg = "PAUSE";
        g.drawImage(iB.getImage(), 305, 170, null);
        Font small = new Font("Helvetica", Font.PLAIN, 32);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
    }

	public void printHighscore()
	{
		highscoreName = JOptionPane.showInputDialog("Game Over! Please enter name to be placed on the highscore: ");
		goToMenu=true;
	}

	public void move()
	{
		if(manager.getAttackerSize()>0 || manager.getDefenderSize()>0)
		{
			for(int i=0; i<manager.getDefenderSize();i++)
			{
				if(manager.getDefenderMovement(i)==true && manager.getDefenderFighting(i)==false)
				{
					manager.moveDefender(i,manager.getDefenderSpeed(i));
				}

			}
			for(int i=0; i<manager.getAttackerSize();i++)
			{
				if(manager.getAttackerMovement(i)==true && manager.getAttackerFighting(i)==false)
				{
					manager.moveAttacker(i,manager.getAttackerSpeed(i));
				}
			}
		}
	}

	public void createDefender(Creep test) {manager.insertDefender(test);}
	public void createAttacker(Creep test){manager.insertAttacker(test);}


    public void checkCollision()
    {
    	if(!pause){
    		/****THIS CHECKS IF DEFENDER MEETS ATTACKER ******/

        	for(int i = 0; i < manager.getDefenderSize(); i++)
        	{
        		manager.setDefenderFighting(i,false);
        		manager.resetDefenderImage(i);

				for(int j = 0; j < manager.getAttackerSize(); j++)
				{
					if(manager.getDefenderX(i)+GAP > manager.getAttackerX(j))
					{
						manager.setDefenderFighting(i,true);

						if(manager.getDefenderAttackSpeed(i) > 0)
						{
							manager.setDefenderAttackSpeed(i,1);
						}
						else
						{
								manager.defenderFire(i);

								if(manager.getAttackerHP(j) > 0)
								{
									manager.setAttackerHP(j,manager.getDefenderDamage(i));
								}
								else
								{
									johnDoe.insertScore(manager.getAttackerValue(j)*6);
									johnDoe.insertCash(manager.getAttackerValue(j));

									manager.killAttacker(j);
									manager.setDefenderFighting(i,false);
								}
								manager.resetDefenderAttackSpeed(i);
						}
					}
				}
        	}
        	/****SLUT ******/

        	/****THIS CHECKS IF ATTACKER MEETS DEFENDER ******/
        	for(int i = 0; i < manager.getAttackerSize(); i++)
        	{
        		manager.setAttackerFighting(i,false);
        		manager.resetAttackerImage(i);

				for(int j = 0; j < manager.getDefenderSize(); j++)
				{
					if(manager.getDefenderX(j)+GAP > manager.getAttackerX(i))
					{

						manager.setAttackerFighting(i,true);

						if(manager.getAttackerAttackSpeed(i) > 0)
						{
							manager.setAttackerAttackSpeed(i,1);
						}
						else
						{
							manager.attackerFire(i);
							if(manager.getDefenderHP(j) > 0)
							{
								manager.setDefenderHP(j,manager.getAttackerDamage(i));
							}
							else
							{
								manager.killDefender(j);
								manager.setAttackerFighting(i,false);
							}
							manager.resetAttackerAttackSpeed(i);
						}
					}
				}
        	}
        	/****SLUT ******/
/****CHECKS IFATTACKER MEETS TOWER*****/

        	for(int i = 0; i < manager.getAttackerSize(); i++)
        	{
					if(yourTower.x+160 > manager.getAttackerX(i))
					{
						manager.setAttackerFighting(i,true);
						manager.resetAttackerImage(i);

						if(manager.getAttackerAttackSpeed(i) > 0)
						{
							manager.setAttackerAttackSpeed(i,1);
						}
						else
						{
							manager.attackerFire(i);
							if(yourTower.hp > 0)
							{
								yourTower.hp-=(manager.getAttackerDamage(i));
								System.out.println(yourTower.hp);
							}

							else{
								printHighscore();
								inGame=false;
							}
							manager.resetAttackerAttackSpeed(i);
						}

					}
        	}


    	}
    }

    public void actionPerformed(ActionEvent e)
    {

	       if (inGame && !pause)
	       {
	        	checkCollision();
	            move();
	       }
        repaint();
    }


    }
