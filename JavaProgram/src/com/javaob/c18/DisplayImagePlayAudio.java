package com.javaob.c18;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayImagePlayAudio	extends JFrame {
	public DisplayImagePlayAudio() {
		setLayout(new BorderLayout());
		add(new ImagePanel(), BorderLayout.CENTER);
		add(new AudioPanel(), BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		JFrame frame = new DisplayImagePlayAudio();
		frame.setTitle("显示图像");
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

//能够装载图像的面板
class ImagePanel extends JPanel{
	private Image image;
	public ImagePanel() {
		image = new ImageIcon("src/com/javabo/c18/image/xunshan.jpg").getImage();
		
	}
	// 在Panel上画图象
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//如果image不为空
		if(image!=null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}

class AudioPanel extends JPanel{
	private JButton jbtPlay = new JButton("播放");
	private JButton jbtStop = new JButton("停止");
	
	private AudioClip clip;
	public AudioPanel() {
		URL url = this.getClass().getResource("audio/xunshan.wav");
		
		clip = Applet.newAudioClip(url);
		jbtPlay.addActionListener(new ButtonListener());
		jbtStop.addActionListener(new ButtonListener());
		add(jbtPlay);
		add(jbtStop);
		
	}
	//创建监听类
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtPlay)
				clip.play();
			else if(e.getSource()==jbtStop)
				clip.stop();
			
		}
		
	}
}