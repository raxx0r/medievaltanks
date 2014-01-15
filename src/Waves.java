
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;

public class Waves{

	//public Creep[][] waves = new Creep[10][10];
	public Vector<Creep> wave = new Vector<Creep>();
	public Vector<Creep> wavea = new Vector<Creep>();
	public Vector<Creep> wave1 = new Vector<Creep>();
	public Vector<Creep> wave2 = new Vector<Creep>();
//	public Vector<Creep> wave2 = new Vector<Creep>();
	public Vector<Creep> wave3 = new Vector<Creep>();
	public Vector<Creep> wave4 = new Vector<Creep>();
	public Vector<Creep> wave5 = new Vector<Creep>();
	public Vector<Creep> wave6 = new Vector<Creep>();
	public Vector<Creep> wave6a = new Vector<Creep>();
	public Vector<Creep> wave6b = new Vector<Creep>();
	public Vector<Creep> wave6c = new Vector<Creep>();
	public Vector<Creep> wave6d = new Vector<Creep>();
	public Vector<Creep> wave7 = new Vector<Creep>();
	public Vector<Creep> wave8 = new Vector<Creep>();
	public Vector<Creep> waveEmpty = new Vector<Creep>();
	public Vector<Creep> wave7_3 = new Vector<Creep>();
	public Vector<Creep> wave7_4 = new Vector<Creep>();



	public Vector<Vector> wavesVector = new Vector<Vector>();

	public Timer spawnTimer;
	private int i = 0;
	private int j = 0;
	private int tick = 0;

	private int waveCooldown = 20;
	private int waveCooldownConst = 20;

	public boolean pause=false;
	public ActionListener doWave;

	public Waves()
	{

		//Manager manager = new Manager();

		doWave = new waveListener();
		wavea.add(new EvilTank1());
		wavea.add(new EvilTank1());




		wave.add(new EvilTank1());
		wave.add(new EvilTank1());
		wave.add(new EvilTank1());
		wave.add(new EvilTank1());

		wave.add(new EvilTank2());


		wave1.add(new EvilTank1());
		wave1.add(new EvilTank1());
		wave1.add(new EvilTank1());
		wave1.add(new EvilTank1());
		wave1.add(new EvilTank1());
		wave1.add(new EvilTank2());


		wave2.add(new EvilTank2());
		wave2.add(new EvilTank1());
		wave2.add(new EvilTank1());
		wave2.add(new EvilTank1());
		wave2.add(new EvilTank1());
	//	wave2.add(new EvilTank2());
	//	wave2.add(new EvilTank2());


		wave3.add(new EvilTank2());
		wave3.add(new EvilTank1());
		wave3.add(new EvilTank2());
		wave3.add(new EvilTank1());
		wave3.add(new EvilTank1());
		wave3.add(new EvilTank1());
		wave3.add(new EvilTank2());
	//	wave3.add(new EvilTank2());
		wave3.add(new EvilTank2());

		wave4.add(new EvilTank1());
		wave4.add(new EvilTank1());
		wave4.add(new EvilTank3());
	//	wave4.add(new EvilTank2());
		wave4.add(new EvilTank2());


		wave5.add(new EvilTank2());
		wave5.add(new EvilTank1());
		wave5.add(new EvilTank1());
		wave5.add(new EvilTank1());
		wave5.add(new EvilTank1());
		wave5.add(new EvilTank1());
		wave5.add(new EvilTank2());
		wave5.add(new EvilTank2());
		wave5.add(new EvilTank3());

		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());
		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());
		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());
		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());

			wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());
		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());
		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());
		wave6.add(new EvilTank2());
		wave6.add(new EvilTank3());

			wave6a.add(new EvilTank2());
		wave6a.add(new EvilTank3());
		wave6a.add(new EvilTank2());
		wave6a.add(new EvilTank3());
		wave6a.add(new EvilTank2());
		wave6a.add(new EvilTank3());
		wave6a.add(new EvilTank2());
		wave6a.add(new EvilTank3());

			wave6b.add(new EvilTank2());
		wave6b.add(new EvilTank3());
		wave6b.add(new EvilTank2());
		wave6b.add(new EvilTank3());
		wave6b.add(new EvilTank2());
		wave6b.add(new EvilTank3());
		wave6b.add(new EvilTank2());
		wave6b.add(new EvilTank3());

			wave6c.add(new EvilTank2());
		wave6c.add(new EvilTank3());
		wave6c.add(new EvilTank2());
		wave6c.add(new EvilTank3());
		wave6c.add(new EvilTank2());
		wave6c.add(new EvilTank3());
		wave6c.add(new EvilTank2());
		wave6c.add(new EvilTank3());

			wave6d.add(new EvilTank2());
		wave6d.add(new EvilTank3());
		wave6d.add(new EvilTank2());
		wave6d.add(new EvilTank3());
		wave6d.add(new EvilTank2());
		wave6d.add(new EvilTank3());
		wave6d.add(new EvilTank2());
		wave6d.add(new EvilTank3());

		wave7.add(new BadAss());



		wave8.add(new BadAss());
		wave8.add(new EvilTank2());
		wave8.add(new EvilTank3());
		wave8.add(new EvilTank2());
		wave8.add(new EvilTank3());
		wave8.add(new EvilTank2());
		wave8.add(new EvilTank3());
		wave8.add(new EvilTank2());
		wave8.add(new EvilTank3());
		wave8.add(new EvilTank1());
		wave8.add(new EvilTank1());
		wave8.add(new EvilTank1());
		wave8.add(new EvilTank1());
		wave8.add(new EvilTank1());
		wave8.add(new EvilTank1());
		wave8.add(new EvilTank1());
		wave8.add(new BadAss());
		wave8.add(new BadAss());
		wave8.add(new BadAss());
		wave8.add(new BadAss());





		wavesVector.add(wavea);
		wavesVector.add(wave);

		wavesVector.add(wave1);

		wavesVector.add(wave2);
		wavesVector.add(wave3);
		wavesVector.add(wave4);
		wavesVector.add(wave5);
		wavesVector.add(wave6);
		wavesVector.add(wave7);
		wavesVector.add(waveEmpty);
		wavesVector.add(waveEmpty);
		wavesVector.add(wave6d);
		wavesVector.add(wave6a);
		wavesVector.add(wave8);
		wavesVector.add(wave6b);
		wavesVector.add(wave6c);






		//wave.add(new BlackDot());
		//wave.add(new BadDot());
		//wave[0][0] = creep;


	}

	public class waveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			if (tick < 17)
			{
				tick++;
				//System.out.println(tick);
			}


		else
		{
			if(j < wavesVector.size())
			{
					if(i < wavesVector.get(j).size())
					{

						Manager.insertAttacker((Creep) wavesVector.get(j).get(i));
						i++;
					}
					else if(waveCooldown > 0)
					{
						waveCooldown --;
					}
					else
					{
						i = 0;
						j++;
						waveCooldown = waveCooldownConst;
						System.out.println("ny wave");
					}
			}
	tick=0;
//	System.out.println(tick);
		}


			//Creep creep = (Creep) wavesVector.get(j).get(i);
			//System.out.println("ALALALAL");

		}
	}
}
