package Tic;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
	
	//public global variables
	public static boolean playingBot;
	public static int count, Xwin, Owin, botWin, draw;
	
	//private global variables
	private JButton[] options;
	private boolean win;
	private String letter;
	private final int[][] play;
	private ArrayList<JButton> movesLeft;
	
	public GamePanel(int width, int height) {
		win = false; playingBot = false;
		botWin = 0; Xwin = 0; Owin = 0; 
		draw = 0; count = 0;
		letter = "";
		options = new JButton[9];
		movesLeft = new ArrayList<>();
		play = new int[][] {
			{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
			{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
			{0, 4, 8}, {2, 4, 6}	 //diagonal wins
		};
		
		setLayout(new GridLayout(3,3,10,10));
		setBounds(0, 0, width/2, height); 
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        	for(int i = 0; i < options.length; i++) {
        		JButton x = new JButton("");
        		x.setFont(new Font("Arial", Font.BOLD, 70));
        		x.addActionListener(this);
        		add(x);	
        		movesLeft.add(x);
        		options[i] = x;	
        	}
	}
	
	public int getXwin() { return Xwin; }
	
	public int getOwin() { return Owin; }
	
	public int getbotWin() { return botWin; }
	
	public int getDraw() { return draw; }
	
	public void reset() {
		win = false;
		count = 0;
		letter = "";
		for(JButton e: options) {
			e.setText("");
			e.setEnabled(true);
		}
	}
	public void setCount() {
		count++;
		if(count % 2 == 1)
			letter = "X";
		else 
			letter = "O";
	}
	public void chkWin(JButton currentState) {
		for(int i=0; i< play.length; i++){ // check for the winning combinations
			if( options[play[i][0]].getText().equals(options[play[i][1]].getText()) && 
				options[play[i][1]].getText().equals(options[play[i][2]].getText()) && 
				options[play[i][0]].getText().replaceAll("\\s+","") != "")
			{ win = true; }		
		}
		
		
		if(win) 
			setWin(currentState);
		else if(count == 9)
			UserPanel.stat.setDraws(++draw);	
	}
	
	private void setWin(JButton currentState) {
		for(JButton x: options)
			x.setEnabled(false);
		
		if(currentState.getText().equals("X") && !playingBot) 
			UserPanel.stat.setXwins(++Xwin);
		else if(currentState.getText().equals("X"))
			UserPanel.stat.setBotWins(++botWin);
			
		else 
			UserPanel.stat.setOwins(++Owin);	
	}
	
	public void botMove() {
		setCount();
		Random generate = new Random();
		int nextMove = generate.nextInt(movesLeft.size());
		System.out.println("brah" + nextMove);
		
		while(!options[nextMove].getText().equals(""))
			nextMove = generate.nextInt(movesLeft.size());
			
		JButton currentState = new JButton(letter);
		currentState.setEnabled(false);
		options[nextMove] = currentState;
		
		System.out.println(currentState.getText());
		chkWin(currentState);	
	}
	
	public void actionPerformed(ActionEvent e) {
		setCount();
		JButton currentState = (JButton) e.getSource(); 
		currentState.setText(letter);
		currentState.setEnabled(false);
		chkWin(currentState);
		
		if(playingBot) {
			movesLeft.remove(currentState);
			botMove();
		}	
	}
}
