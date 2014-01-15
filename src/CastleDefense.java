
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.image.*;
import java.util.Hashtable;
import java.io.*;
import java.util.StringTokenizer;
import java.applet.*;
import java.net.*;

public class CastleDefense extends JFrame implements ActionListener{
	
	private ImageIcon iA = new ImageIcon("images/Logoanimation/LOGO0.png");
	private ImageIcon iB = new ImageIcon("images/Logoanimation/LOGO1.png");
	private ImageIcon iC = new ImageIcon("images/Logoanimation/LOGO2.png");
	private ImageIcon iD = new ImageIcon("images/Logoanimation/LOGO3.png");
	private ImageIcon iE = new ImageIcon("images/Logoanimation/LOGO4.png");
	private ImageIcon iF = new ImageIcon("images/Logoanimation/LOGO5.png");
	private ImageIcon iG = new ImageIcon("images/Logoanimation/LOGO6.png");
	private ImageIcon iH = new ImageIcon("images/Logoanimation/LOGO7.png");
	private ImageIcon iI = new ImageIcon("images/Logoanimation/LOGO8.png");
	private ImageIcon iJ = new ImageIcon("images/Logoanimation/LOGO9.png");
	private ImageIcon iK = new ImageIcon("images/Logoanimation/LOGO10.png");

	
	
	/* Buttons */
	
	JButton startBtn,greenBtn,redBtn,blueBtn,cheatBtn,optionBtn;
	JButton tank1Btn,tank2Btn,tank3Btn, upgradeBtn, pauseBtn;

	JLabel tank1Lbl,tank2Lbl,tank3Lbl;
	JLabel colorLbl, soundLbl, receiptLbl, creditsLbl,highscoreLbl,rulerLbl,helpLbl;
	JLabel tank1costLbl,tank2costLbl,tank3costLbl;
	JLabel tank1CD, tank2CD, tank3CD;
	JLabel scoreLbl, cashLbl, cashLbl2;
	
	JTextArea highscoreTxt = new JTextArea();

	JButton creditBtn, highscoreBtn, helpBtn, backBtn, sendBtn3;

	/* Ints */
	private final int HEIGHT = 700;
	private final int WIDTH = 1000;
	private final int BTNWIDTH = 115;
	private final int BTNHEIGHT = 122;

	private int moneyTick = 1;

	private int autoMoney = 10;
	private int tank1CooldownConst = 10;
	private int tank2CooldownConst = 20;
	private int tank1Cooldown = 10;
	private int tank2Cooldown = 20;
	private int tank3Cooldown = 50;
	private int cantAfford=0;
	private int towerUpgrade=1;

	
	/* Booleans */
	private boolean tank1IsOnCooldown = false;
	private boolean tank2IsOnCooldown = false;
	private boolean tank3IsOnCooldown = false;
	private boolean loadingScreen = true;
	private boolean pause = false;
	private boolean highscoreCheck = false;
	
	private Background background;
	public Board board;
	private HighScore highscore;
	private Player player;

	JSlider soundLevel = new JSlider(JSlider.HORIZONTAL, 0, 100, 70);
	
	Tank1 tank1;
	Tower tower;
	private Timer cooldownTimer;

	private AudioClip backgroundMusic;
	

	public CastleDefense(){
		
		tank1 = new Tank1();
		tower = new Tower();
		
		setSize(WIDTH, HEIGHT);
		
		background = new Background("images/Background#1.png");
		background.setLayout(null);	
		setContentPane(background);
		

		
		/*Button instantiation */
		creditBtn = new JButton("Credit");
		highscoreBtn = new JButton("Highscore");
		helpBtn = new JButton(new ImageIcon("images/buttons/PostItHelp.png"));
		backBtn = new JButton(new ImageIcon("images/buttons/MenuMarker.png"));
		sendBtn3 = new JButton("BAD MOFO DOT");
		redBtn = new JButton(new ImageIcon("images/OptionsColor/RED.png"));
		blueBtn = new JButton(new ImageIcon("images/OptionsColor/BLUE.png"));
		greenBtn = new JButton(new ImageIcon("images/OptionsColor/GREEN.png"));
		cheatBtn = new JButton("");
		tank1Btn = new JButton(new ImageIcon("images/buttons/TankBtn1_3.png"));
		tank2Btn = new JButton(new ImageIcon("images/buttons/TankBtn2_3.png"));
		tank3Btn = new JButton(new ImageIcon("images/buttons/TankBtn3_3.png"));
		upgradeBtn = new JButton(new ImageIcon("images/buttons/upgradeTower1.png"));
		
		startBtn = new JButton(new ImageIcon("images/buttons/PostITstart.png"));
		optionBtn = new JButton(new ImageIcon("images/buttons/PostItoptions.png"));
		creditBtn = new JButton(new ImageIcon("images/buttons/PostItcredits.png"));
		highscoreBtn = new JButton(new ImageIcon("images/buttons/PostItHighscore.png"));
		pauseBtn = new JButton(new ImageIcon("images/buttons/pauseBtn.png"));
		
		/* Label instantiation */
		scoreLbl = new JLabel("");
		cashLbl = new JLabel("");
		cashLbl2 = new JLabel("");
		colorLbl = new JLabel(new ImageIcon("images/ChooseC.png"));
		soundLbl = new JLabel(new ImageIcon("images/sounds.png"));
		tank1costLbl = new JLabel("");
		tank2costLbl = new JLabel("");
		tank3costLbl = new JLabel("");
		tank1Lbl = new JLabel("");
		tank2Lbl = new JLabel("");
		tank3Lbl = new JLabel("");
 		rulerLbl = new JLabel(new ImageIcon("images/ruler.png"));
 		receiptLbl = new JLabel(new ImageIcon("images/Receipt.png"));
 		helpLbl = new JLabel(new ImageIcon("images/Tutorial_utkast1.png"));
    	creditsLbl = new JLabel(new ImageIcon("images/CreditsBG.png"));
		tank1CD = new JLabel("");
		tank2CD = new JLabel("");
		tank3CD = new JLabel("");
		

		startBtn.setBounds(350,50,BTNWIDTH,BTNHEIGHT);
		optionBtn.setBounds(650,150,BTNWIDTH,BTNHEIGHT);
		creditBtn.setBounds(260,444,BTNWIDTH,BTNHEIGHT);
		highscoreBtn.setBounds(550,418,BTNWIDTH,BTNHEIGHT);
		helpBtn.setBounds(350,240,BTNWIDTH,BTNHEIGHT);
		redBtn.setBounds(550,230,100,100);
		blueBtn.setBounds(700,250,100,100);
		greenBtn.setBounds(850,250,100,100);
		soundLevel.setBounds(550,100,400,BTNHEIGHT/2);
		soundLevel.setBounds(610,83,290,100);
		cheatBtn.setBounds(738,26,20,20);

		colorLbl.setBounds(0,240,600,158);

		soundLbl.setBounds(200,110,400, BTNHEIGHT/2);
		tank1CD.setBounds(50,496,100,100);
		tank2CD.setBounds(150,496,100,100);
		tank3CD.setBounds(250,496,100,100);
		
        tank1Lbl.setBounds(687,265,100,100);
        tank2Lbl.setBounds(687,281,100,100);
        tank3Lbl.setBounds(687,297,100,100);
        tank1costLbl.setBounds(870,265,100,100);
        tank2costLbl.setBounds(870,281,100,100);
        tank3costLbl.setBounds(870,297,100,100);

		scoreLbl.setBounds(860,180,100,100);
        cashLbl.setBounds(860,208,100,100);
        cashLbl2.setBounds(30,408,100,100);

        receiptLbl.setBounds(745,30,271,450);
        helpLbl.setBounds(0,0,1000,700);
        tank1Btn.setBounds(50,490,100,90);
        tank2Btn.setBounds(150,490,100,90);
        tank3Btn.setBounds(250,490,100,90);

        rulerLbl.setBounds(510,100,500,100);
        upgradeBtn.setBounds(480,490,155,125);

        creditsLbl.setBounds(100,40,800,480);
		backBtn.setBounds(800,600,200,60);
		


		// Rollovers 
		
		startBtn.setRolloverIcon(new ImageIcon("images/buttons/PostITstartDown.png"));
		optionBtn.setRolloverIcon(new ImageIcon("images/buttons/PostItoptionsDown.png"));
		creditBtn.setRolloverIcon(new ImageIcon("images/buttons/PostItcreditsDown.png"));
		highscoreBtn.setRolloverIcon(new ImageIcon("images/buttons/PostItHighscoreDown.png"));
		helpBtn.setRolloverIcon(new ImageIcon("images/buttons/PostItHelpDown.png"));
		backBtn.setRolloverIcon(new ImageIcon("images/buttons/MenuMarkerDown.png"));
		pauseBtn.setRolloverIcon(new ImageIcon("images/buttons/pauseBtn_hover.png"));

		
		redBtn.setRolloverIcon(new ImageIcon("images/OptionsColor/REDDown.png"));
		blueBtn.setRolloverIcon(new ImageIcon("images/OptionsColor/BLUEDown.png"));
		greenBtn.setRolloverIcon(new ImageIcon("images/OptionsColor/GREENDown.png"));
		

        tank1Btn.setDisabledIcon(new ImageIcon("images/buttons/TankBtn1_notAvail.png"));
        tank2Btn.setDisabledIcon(new ImageIcon("images/buttons/TankBtn2_notAvail3.png"));
        tank3Btn.setDisabledIcon(new ImageIcon("images/buttons/TankBtn3_notAvail3.png"));

        tank3Btn.setRolloverIcon(new ImageIcon("images/buttons/tankBtn3_hover.png"));
		tank2Btn.setRolloverIcon(new ImageIcon("images/buttons/tankBtn2_hover.png"));
		tank1Btn.setRolloverIcon(new ImageIcon("images/buttons/tankBtn1_hover.png"));
		upgradeBtn.setRolloverIcon(new ImageIcon("images/buttons/upgradeTower1_hover.png"));

		background.add(optionBtn);
      	background.add(startBtn);
        background.add(creditBtn);
        background.add(highscoreBtn);
        background.add(helpBtn);
        
        
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("0") );
		labelTable.put( new Integer( 100 ), new JLabel("100") );
		soundLevel.setLabelTable( labelTable );
		soundLevel.setOpaque(false);
		soundLevel.setPaintLabels(true);
		
		tank1CD.setFont(new Font("Calibri", Font.BOLD, 50));
		tank1CD.setForeground(new Color(154,0,0));
		tank1CD.setHorizontalAlignment(JLabel.CENTER);
		
		tank2CD.setFont(new Font("Calibri", Font.BOLD, 50));
		tank2CD.setForeground(new Color(154,0,0));
		tank2CD.setHorizontalAlignment(JLabel.CENTER);
		
		tank3CD.setFont(new Font("Calibri", Font.BOLD, 50));
		tank3CD.setForeground(new Color(154,0,0));
		tank3CD.setHorizontalAlignment(JLabel.CENTER);

        tank2Btn.setEnabled(false);
        tank3Btn.setEnabled(false);

		tank1Lbl.setHorizontalAlignment(JLabel.RIGHT);
		tank2Lbl.setHorizontalAlignment(JLabel.RIGHT);
		tank3Lbl.setHorizontalAlignment(JLabel.RIGHT);

		tank1costLbl.setHorizontalAlignment(JLabel.RIGHT);
		tank2costLbl.setHorizontalAlignment(JLabel.RIGHT);
		tank3costLbl.setHorizontalAlignment(JLabel.RIGHT);

		upgradeBtn.setDisabledIcon(new ImageIcon("images/buttons/upgradeTower1_notAvail.png"));


        pauseBtn.setBounds(850,463,120,96);
		scoreLbl.setHorizontalAlignment(JLabel.RIGHT);
		cashLbl.setHorizontalAlignment(JLabel.RIGHT);
        scoreLbl.setFont(new Font("Courier", Font.BOLD, 20));
        cashLbl.setFont(new Font("Courier", Font.BOLD, 20));
        cashLbl2.setFont(new Font("Courier", Font.BOLD, 20));

		tank1Lbl.setFont(new Font("Courier", Font.BOLD, 13));
        tank2Lbl.setFont(new Font("Courier", Font.BOLD, 13));
        tank3Lbl.setFont(new Font("Courier", Font.BOLD, 13));
        tank1costLbl.setFont(new Font("Courier", Font.BOLD, 13));
        tank2costLbl.setFont(new Font("Courier", Font.BOLD, 13));
        tank3costLbl.setFont(new Font("Courier", Font.BOLD, 13));

	

		//Highscore
		highscore = new HighScore();
		highscoreLbl = new JLabel("Highscore");
		highscoreTxt.setBounds(WIDTH/2-200,130,500,500);
		highscoreLbl.setBounds(WIDTH/2-80,50,300,100);
		highscoreTxt.setFont(new Font("Courier", Font.BOLD, 24));
		highscoreLbl.setFont(new Font("Courier", Font.BOLD, 24));
		highscoreTxt.setBackground(Color.white);
		highscoreLbl.setBackground(Color.white);
		highscoreTxt.setOpaque(false);

		highscore.readHighScore();
       
		addListeners();


		//Fixa borders på knappar
		removeBtnBorder(startBtn);
		removeBtnBorder(optionBtn);
		removeBtnBorder(creditBtn);
		removeBtnBorder(highscoreBtn);
		removeBtnBorder(helpBtn);
		removeBtnBorder(backBtn);
		removeBtnBorder(tank1Btn);
		removeBtnBorder(tank2Btn);
		removeBtnBorder(tank3Btn);
		removeBtnBorder(upgradeBtn);
		removeBtnBorder(pauseBtn);
		removeBtnBorder(redBtn);
		removeBtnBorder(greenBtn);
		removeBtnBorder(blueBtn);
		removeBtnBorder(cheatBtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setTitle("Castle Defense");
        setResizable(false);
        setVisible(true);


	}

	public void	addListeners(){

		startBtn.addActionListener(this);
		optionBtn.addActionListener(this);
		creditBtn.addActionListener(this);
		highscoreBtn.addActionListener(this);
		helpBtn.addActionListener(this);
		backBtn.addActionListener(this);
		upgradeBtn.addActionListener(this);
		pauseBtn.addActionListener(this);
		tank1Btn.addActionListener(this);
		tank2Btn.addActionListener(this);
		tank3Btn.addActionListener(this);
		cheatBtn.addActionListener(this);
	}
	
	public void removeBtnBorder(JButton btn){
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));


	}
	
	//Borja har

	public void actionPerformed(ActionEvent e){


		if(e.getSource() == startBtn){
			if(!pause){
				background.removeAll();
				board = new Board();
				background.add(tank1Lbl);
				background.add(tank2Lbl);
				background.add(tank3Lbl);

				background.add(cheatBtn);

				background.add(tank1CD);
				background.add(tank2CD);
				background.add(tank3CD);

				background.add(tank1costLbl);
				background.add(tank2costLbl);
				background.add(tank3costLbl);
				board.setBounds(0,0,810,610);
				background.add(scoreLbl);
				background.add(cashLbl);
				background.add(cashLbl2);
				background.add(receiptLbl);
				background.add(board);

				background.add(tank1Btn);
				background.add(tank2Btn);
				background.add(tank3Btn);


				background.add(upgradeBtn);
				background.add(pauseBtn);

				receiptLbl.repaint();
				background.repaint();
				board.setOpaque(false);
				cooldownTimer = new Timer(100,this);
	       		cooldownTimer.start();

			}
			else{

				background.removeAll();
				board.setBounds(0,0,810,610);
				background.add(tank1Lbl);
				background.add(tank2Lbl);
				background.add(tank3Lbl);
				background.add(tank1costLbl);
				background.add(tank2costLbl);
				background.add(tank3costLbl);
				background.add(scoreLbl);
				background.add(cashLbl);
				background.add(cashLbl2);
				background.add(receiptLbl);
				background.add(board);

				background.add(cheatBtn);
				background.add(tank1Btn);
				background.add(tank2Btn);
				background.add(tank3Btn);
				background.add(backBtn);

				background.add(tank1CD);
				background.add(tank2CD);
				background.add(tank3CD);

				background.add(upgradeBtn);
				background.add(pauseBtn);
				pauseBtn.setText("Resume");
				receiptLbl.repaint();
				background.repaint();
				board.setOpaque(false);
			}
		}

		if(e.getSource() == optionBtn){
			background.removeAll();

       		background.add(redBtn);
       		background.add(greenBtn);
       		background.add(blueBtn);
       		background.add(colorLbl);
       		background.add(soundLevel);
       		background.add(soundLbl);
       		background.add(rulerLbl);
			background.add(backBtn);
       		background.repaint();

		}

		if(e.getSource() == backBtn){
			background.removeAll();
			background.add(startBtn);
       		background.add(optionBtn);
       		background.add(creditBtn);
       		background.add(highscoreBtn);
       		background.add(helpBtn);
			background.repaint();
		}

		if(e.getSource() == creditBtn){
			background.removeAll();
			background.add(creditsLbl);
			background.add(backBtn);
			background.repaint();
		}

		if(e.getSource() == helpBtn){
			background.removeAll();
			background.add(backBtn);
			background.add(helpLbl);
			background.repaint();
		}

		if(e.getSource() == highscoreBtn){
			background.removeAll();
			background.add(highscoreTxt);
			background.add(highscoreLbl);
			background.add(backBtn);
			highscoreShow();

			highscoreTxt.setVisible(true);
			background.repaint();

		}
		if(e.getSource() == cheatBtn)
		{
			board.johnDoe.cash += 100;
		}


		if(e.getSource() == pauseBtn){
			board.pauseGame();

			if(!pause){
				pauseBtn.setText("Resume");
				pause = true;
				pauseBtn.setIcon(new ImageIcon("images/buttons/resumeBtn.png"));
				pauseBtn.setRolloverIcon(new ImageIcon("images/buttons/resumeBtn_hover.png"));
				background.add(backBtn);
				background.repaint();
			}
			else{
				pauseBtn.setText("Pause");
				pause = false;
				pauseBtn.setIcon(new ImageIcon("images/buttons/pauseBtn.png"));
				pauseBtn.setRolloverIcon(new ImageIcon("images/buttons/pauseBtn_hover.png"));
				background.remove(backBtn);
				background.repaint();
			}

		}


		if(e.getSource() ==  upgradeBtn){

			if (towerUpgrade==1)
			{
				if(board.johnDoe.cash>=Tower.price)
				{
					board.upgradeStage=1;
					towerUpgrade=2;
					board.johnDoe.cash-=Tower.price;
					moneyTick = 2;
					tank1CooldownConst = 5;
				//	if(board.johnDoe.cash >= Tank2.price)
				//	tank2Btn.setEnabled(true);

					tank2Btn.setDisabledIcon(new ImageIcon("images/buttons/TankBtn2_notAvail.png"));

					upgradeBtn.setIcon(new ImageIcon("images/buttons/upgradeTower2.png"));
					upgradeBtn.setRolloverIcon(new ImageIcon("images/buttons/upgradeTower2_hover.png"));
					upgradeBtn.setDisabledIcon(new ImageIcon("images/buttons/upgradeTower2_notAvail.png"));
				}
				else { cashLbl.setForeground(Color.RED); cashLbl2.setForeground(Color.RED); }

			}
			else if (towerUpgrade==2)
			{
				if(board.johnDoe.cash>=Tower.price1)
					{
						board.upgradeStage=2;
						board.johnDoe.cash-=Tower.price1;
					//	tank3Btn.setEnabled(true);
						tank2CooldownConst = 10;
						tank1CooldownConst = 2;
						moneyTick = 5;
						towerUpgrade=3;

						tank3Btn.setDisabledIcon(new ImageIcon("images/buttons/TankBtn3_notAvail.png"));

						upgradeBtn.setDisabledIcon(new ImageIcon("images/buttons/upgradeTower_notAvail.png"));
					}
				else {cashLbl.setForeground(Color.RED); cashLbl2.setForeground(Color.RED);}
			}
		}


		if(e.getSource() == tank1Btn){


				Tank1 tank1 = new Tank1();

				board.createDefender(tank1);
		//		System.out.println(tank1.price);
				board.johnDoe.cash -= tank1.price;
				board.johnDoe.tank1++;
				tank1IsOnCooldown = true;
				tank1Cooldown = tank1CooldownConst;

		}
		if(e.getSource() == tank2Btn){


			Tank2 tank2 = new Tank2();
			board.johnDoe.tank2++;
			board.createDefender(tank2);
			board.johnDoe.cash -= tank2.price;

			tank2IsOnCooldown = true;
			tank2Cooldown = tank2CooldownConst;


		}
		if(e.getSource() == tank3Btn){

			Tank3 tank3 = new Tank3();
			board.johnDoe.tank3++;
			board.createDefender(tank3);
			board.johnDoe.cash -= tank3.price;

			tank3IsOnCooldown = true;
			tank3Cooldown = 50;
		}


		if(e.getSource() == cooldownTimer) //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		{
			if(board.newGame==true)
			{


				int score = board.johnDoe.score;
				String name = board.highscoreName;


				Player newPlayer=new Player(name,score);
				highscore.addPlayer(newPlayer);
				highscore.sortHighscore();
				highscore.printHighscore();
				//highscore.showMe();

				background.remove(board);
				board.timer.stop();
				board.manager.waves.doWave=null;
				board = null;


				startBtn.removeActionListener(this);
				optionBtn.removeActionListener(this);
				creditBtn.removeActionListener(this);
				highscoreBtn.removeActionListener(this);
				helpBtn.removeActionListener(this);
				backBtn.removeActionListener(this);
				upgradeBtn.removeActionListener(this);
				pauseBtn.removeActionListener(this);
				tank1Btn.removeActionListener(this);
				tank2Btn.removeActionListener(this);
				tank3Btn.removeActionListener(this);
		//		cooldownTimer.removeActionListener(this);

				background.removeAll();

				background.add(optionBtn);
		      	background.add(startBtn);
		        background.add(creditBtn);
		        background.add(highscoreBtn);
		        background.add(helpBtn);
		        addListeners();
		        repaint();
		        cooldownTimer = null;

			}
			else
			{
				if(board.inGame)
				{

					autoMoney --;
					if(autoMoney <= 0 && board.pause==false)
					{
						board.johnDoe.cash += moneyTick;
						autoMoney = 10;
					}
				}

				scoreLbl.setText("" + board.johnDoe.score);
				cashLbl.setText("" + board.johnDoe.cash+ ".0");
				cashLbl2.setText("$" + board.johnDoe.cash+ ".0");
				tank1Lbl.setText("" + board.johnDoe.tank1);
				tank2Lbl.setText("" + board.johnDoe.tank2);
				tank3Lbl.setText("" + board.johnDoe.tank3);
				tank1costLbl.setText("" + board.johnDoe.tank1*10);
				tank2costLbl.setText("" + board.johnDoe.tank2*50);
				tank3costLbl.setText("" + board.johnDoe.tank3*200);


				cantAfford++;
				if(cantAfford>20){cantAfford=0;}
				if(cantAfford==20){cashLbl.setForeground(Color.BLACK);	cantAfford=0;cashLbl2.setForeground(Color.BLACK);}


				//TANK 1
				if(tank1IsOnCooldown)
				{
					tank1Cooldown --;
					tank1CD.setText(""+tank1Cooldown);

					if(tank1Btn.isEnabled()) tank1Btn.setEnabled(false);

					if(tank1Cooldown <= 0)
					{
						tank1CD.setText("");
						tank1IsOnCooldown = false;
					}
				}
				if(board.johnDoe.cash >= Tank1.price && tank1IsOnCooldown == false)
				{
					tank1Btn.setEnabled(true);

				}

				if(towerUpgrade == 1 && board.johnDoe.cash < Tower.price)
					upgradeBtn.setEnabled(false);
				else if(towerUpgrade == 1 && board.johnDoe.cash >= Tower.price)
					upgradeBtn.setEnabled(true);

				if(towerUpgrade == 2 && board.johnDoe.cash < Tower.price1)
					upgradeBtn.setEnabled(false);
				else if(towerUpgrade == 2 && board.johnDoe.cash >= Tower.price1)
					upgradeBtn.setEnabled(true);

				if(towerUpgrade==3)
				{
					upgradeBtn.setEnabled(false);
				}

				//TANK 2
				if(tank2IsOnCooldown)
				{
					tank2Cooldown --;

					tank2CD.setText(""+tank2Cooldown);
					if(tank2Btn.isEnabled()) tank2Btn.setEnabled(false);

					if(tank2Cooldown <= 0)
					{
						tank2CD.setText("");
						tank2IsOnCooldown = false;
					}
				}
				if(board.johnDoe.cash >= Tank2.price && tank2IsOnCooldown == false && towerUpgrade > 1)
				{
					tank2Btn.setEnabled(true);
				}

				//TANK 3

				if(tank3IsOnCooldown)
				{
					tank3Cooldown --;
					tank3CD.setText(""+tank3Cooldown);
					if(tank3Btn.isEnabled()) tank3Btn.setEnabled(false);

					if(tank3Cooldown <= 0)
					{
						tank3CD.setText("");
						tank3IsOnCooldown = false;
					}
				}
				if(board.johnDoe.cash >= Tank3.price && tank3IsOnCooldown == false && towerUpgrade > 2)
				{
					tank3Btn.setEnabled(true);
				}



			}







		}



	}


	public void highscoreShow()
	{

		try{
			highscoreTxt.setText("");
			highscoreTxt.setForeground(Color.white);
			String highScoreList="",player="", score="",line="",s="";
			String space = "                                                                ";
			int i=0,u=0;
			BufferedReader infile = new BufferedReader(new FileReader("highscore.txt"));

			while ((line = infile.readLine()) != null){

				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					player = st.nextToken();
					score = st.nextToken();
					s = String.format("%-20s%-1s%-1s",player,score,"\n");
					highscoreTxt.append(s);
				}
			}

		}
		catch(IOException a){
			System.err.println("Det blev nog fel med filen!");
		}
	}


	public void paint(Graphics g) {
		super.paint(g);


		if(loadingScreen){

			LoadingUp1(g);
			loadingScreen = false;


		}



	}


	public void LoadingUp1(Graphics g){
			try{
				int delay =50;

				g.drawImage(iA.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(2000);
				g.drawImage(iB.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iC.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iD.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iE.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iF.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iG.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iH.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iI.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iJ.getImage(), 0, 0, null);
				repaint();
				Thread.sleep(delay);
				g.drawImage(iK.getImage(), 0, 0, null);

				Thread.sleep(2500);


			}
			catch(InterruptedException ex){}

	}


	
	
	public static void main(String[] args) {
		new CastleDefense();

	}

}




