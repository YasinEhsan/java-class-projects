package proj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class GG extends JFrame {

	private JPanel picPanel;
	private int h, w;
	private final JButton btnNewButton = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GG frame = new GG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GG() {
		w = 600; h = w/3*2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, w, h);
		getContentPane().setLayout(null);
		
		
		bPanel bPanel_ = new bPanel(w,h);
		getContentPane().add(bPanel_);
		
		
		
		
		
		getContentPane().add(picPanel = new JPanel());
		
		
		
		
		picPanel.setBounds(w/3, 0, w/3*2, h);
		picPanel.setBackground(Color.red);
		
		
		
		
	}

}
