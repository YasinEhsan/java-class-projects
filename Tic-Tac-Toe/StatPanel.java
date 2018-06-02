package Tic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatPanel extends JPanel{
	private JLabel playerX, playerO, playerDraw, bot;
	
	public StatPanel() {
		setLayout(new GridLayout(9, 1));
		setBorder(BorderFactory.createTitledBorder("Stats"));
		
		add(new JLabel());
		add(playerX = new JLabel(" Player 'X' Wins:"));
		add(new JLabel(""));
		add(playerO = new JLabel(" Player 'O' Wins:"));
		add(new JLabel(""));
		add(playerDraw = new JLabel(" Draws:"));
		add(new JLabel(" "));
		add(bot = new JLabel(" Bot Wins: "));
	}
	public void setDraws(int draw) {
		playerDraw.setText("Draws: " + Integer.toString(draw));
	}
	public void setXwins(int Xwins) {
		 playerX.setText("Player 'X' Wins: " + Integer.toString(Xwins));
		 //UserPanel.view.append("Player X won");
	}
	public void setOwins(int Owins) {
		 playerO.setText("Player 'O' Wins: " + Integer.toString(Owins));
	}
	public void setBotWins(int botWins) {
		bot.setText("Bot Wins: " + Integer.toString(botWins));
	}
}
