package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Zeitgeber implements ActionListener {
	
	private int dasIntervall;
	private EventController dieSteuerung;
	private Timer t;
	
	public Zeitgeber(EventController eventController, int pIntervall){
		
		dieSteuerung = eventController;
		dasIntervall = pIntervall;
		
		t = new Timer(dasIntervall, this);
	}
	
	public void starte(){
		t.start();
	}
	
	public void stoppe(){
		t.stop();
	}
	
	public void actionPerformed(ActionEvent e) {
		dieSteuerung.tickTimer();
	}

	public void setdelay(int inter) {
		t.setDelay(inter);
	
		
	}

}
