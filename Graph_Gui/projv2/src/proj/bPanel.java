package proj;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;


public class bPanel extends JPanel{
	
	public bPanel(int w, int h) {
		setBounds(0, 0, w/3, h);
		setBackground(Color.yellow);
		
		initialize();
		
	}
	
	public void initialize() {
		JRadioButton mvVer = new JRadioButton("Move Vertex");
		mvVer.setBounds(18, 148, 141, 23);
		add(mvVer);
		
		JRadioButton rmEd = new JRadioButton("Remove Edge");
		rmEd.setBounds(18, 120, 141, 23);
		add(rmEd);
		
		JRadioButton rmVer = new JRadioButton("Remove Vertex");
		rmVer.setBounds(18, 86, 141, 23);
		add(rmVer);
		
		JRadioButton addEd = new JRadioButton("Add Edge");
		addEd.setBounds(18, 50, 141, 23);
		add(addEd);
		
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
		add(addVertex);
		
		ButtonGroup bg1 = new ButtonGroup( );
		bg1.add(mvVer);
		bg1.add(rmEd);
		bg1.add(rmVer);
		bg1.add(addEd);
		bg1.add(addVertex);
		
	}

}
