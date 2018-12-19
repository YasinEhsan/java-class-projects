package graph_Proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JPanel;


public class HelloWorldClass extends JFrame {

//	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldClass window = new HelloWorldClass();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloWorldClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
//		new JFrame();
		setBounds(100, 100, 665, 431);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	
		
		JRadioButton mvVer = new JRadioButton("Move Vertex");
		mvVer.setBounds(18, 148, 141, 23);
		getContentPane().add(mvVer);
		
		JRadioButton rmEd = new JRadioButton("Remove Edge");
		rmEd.setBounds(18, 120, 141, 50);
		getContentPane().add(rmEd);
		
		JRadioButton rmVer = new JRadioButton("Remove Vertex");
		rmVer.setBounds(18, 86, 141, 23);
		getContentPane().add(rmVer);
		
		JRadioButton addEd = new JRadioButton("Add Edge");
		addEd.setBounds(18, 50, 141, 23);
		getContentPane().add(addEd);
		
		JRadioButton addVertex = new JRadioButton("Add Vertex");
//		addVertex.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new Vertex();
//			}
//		});
		addVertex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent t) {
				new Vertex();
				
			}
		});
		addVertex.setBounds(18, 20, 141, 23);
		getContentPane().add(addVertex);
		
		ButtonGroup bg1 = new ButtonGroup( );
		bg1.add(mvVer);
		bg1.add(rmEd);
		bg1.add(rmVer);
		bg1.add(addEd);
		bg1.add(addVertex);
		
		
		//ALL EDGE
		JButton allEd = new JButton("Add All Edges");
		allEd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		allEd.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		allEd.setBounds(18, 185, 180, 47);
		getContentPane().add(allEd);
		
		
		//CONNECTED COMPONENTS
		JButton conCom = new JButton("Connected Components");
		conCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showInputDialog(this,
//					    "Eggs are not supposed to be green.",
//					    "A plain message",
//					    JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		conCom.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		conCom.setBounds(18, 235, 180, 47);
		getContentPane().add(conCom);
		
		//CUT VERTICES
		JButton cutVer = new JButton("Show Cut Vertices");
		cutVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cutVer.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		cutVer.setBounds(18, 285, 180, 47);
		getContentPane().add(cutVer);
		
		//HELP
		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		help.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		help.setBounds(18, 341, 180, 47);
		getContentPane().add(help);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(Color.WHITE);
		panel.setBounds(235, 20, 395, 368);
		getContentPane().add(panel);
	}
}
