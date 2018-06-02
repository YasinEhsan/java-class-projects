package Tic;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel {
	private JButton reset, exit, bot, multiplayer; 
	
	public ButtonPanel() {
		//setBorder(BorderFactory.createTitledBorder(""));
		
		
		reset = new JButton("Reset");
		exit = new JButton("Exit"); 
		bot = new JButton("Play Bot");
		multiplayer = new JButton("Multiplayer");
		
		reset.addActionListener(new Reset());
		exit.addActionListener(new Exit());
		bot.addActionListener(new Bot());
		multiplayer.addActionListener(new Multi());
		
		add(reset);
		add(exit);
		add(bot);
		add(multiplayer);
		
	}
	
	public class Reset implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Tic.gp.reset();
		}
	}
	public class Exit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	public class Bot implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Tic.gp.reset();
			Tic.gp.playingBot = true;
			Tic.gp.botMove();
		}
	}
	public class Multi implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Tic.gp.reset();
			Tic.gp.playingBot = false;
		}
	}
	

}
