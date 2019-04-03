package com.javaob.c18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball extends JPanel {
	private int delay = 10;
	private Timer timer = new Timer(delay, new TimerListener());
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
