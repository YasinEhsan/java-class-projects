package v3;

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
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GG8099 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GG8099 frame = new GG8099();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GG8099() {
		
		int w = 600, h = w/3*2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, w, h);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel);
		btnPanel.setBounds(5, 5,  w/3 -10, h-35);
//		btnPanel.setBackground(Color.yellow);
		
		JRadioButton mvVer = new JRadioButton("Move Vertex");
		mvVer.setBounds(18, 148, 141, 23);
		btnPanel.add(mvVer);
		
		JRadioButton rmEd = new JRadioButton("Remove Edge");
		rmEd.setBounds(18, 120, 141, 50);
		btnPanel.add(rmEd);
		
		JRadioButton rmVer = new JRadioButton("Remove Vertex");
		rmVer.setBounds(18, 86, 141, 23);
		btnPanel.add(rmVer);
		
		JRadioButton addEd = new JRadioButton("Add Edge");
		addEd.setBounds(18, 50, 141, 23);
		btnPanel.add(addEd);
		
		JRadioButton addVertex = new JRadioButton("Add Vertex");
//		addVertex.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new Vertex();
//			}
//		});
		addVertex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent t) {
//				new Vertex();
				
			}
		});
		addVertex.setBounds(18, 20, 141, 23);
		btnPanel.add(addVertex);
		
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
		btnPanel.add(allEd);
		
		
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
		btnPanel.add(conCom);
		
		//CUT VERTICES
		JButton cutVer = new JButton("Show Cut Vertices");
		cutVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cutVer.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		cutVer.setBounds(18, 285, 180, 47);
		btnPanel.add(cutVer);
		
		//HELP
		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		help.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		help.setBounds(18, 341, 180, 47);
		btnPanel.add(help);
		
		JPanel picPanel = new JPanel();
		contentPane.add(picPanel);
		picPanel.setBounds(w/3, 5, h-5, h-35);
//		picPanel.setBackground(Color.RED);
	}

}
