package Tic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPanel extends JPanel {

	public static StatPanel stat;
	public static ButtonPanel buttons;
	public static ShowPanel view;
	
	public UserPanel(int width, int height) {
		
	   setBounds(width/2, 0, width/2, height); 
	   setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));  
       setLayout(new BorderLayout());
       
       add(stat = new StatPanel(), BorderLayout.NORTH);
       add(view = new ShowPanel(), BorderLayout.CENTER);
       add(buttons = new ButtonPanel(),BorderLayout.SOUTH); 
      }
	
}
	

