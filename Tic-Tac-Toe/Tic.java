package Tic;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Tic extends JFrame{
	final int width, height; 
	public static UserPanel up;
	public static GamePanel gp;
	
    public Tic() {
    		width = 1000; height = width / 2;
		Dimension size = getToolkit().getScreenSize();
		
        setTitle("TIC TAC TOE");
        setSize(width, height);
        //setMargin(new Insets(50, 50, 50, 50));
        setLocation((size.width - getWidth())/2, (size.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
  
        
        add(up = new UserPanel(width,height));
        add(gp = new GamePanel(width,height));
        setVisible(true);
   }
	
	public static void main(String[] args) {
		try{
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,  "Error setting " +
                          "the look and feel.");
            System.exit(0);
        }
		new Tic();
	}
}
