package graph_Proj;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Vertex extends Frame implements MouseListener{
	
	public Vertex() {
		// TODO Auto-generated constructor stub
		addMouseListener(this);
		setSize(100, 100);
		setLayout(null);
		setVisible(true);
	}
	

	@Override
	public void mouseClicked(MouseEvent t) {
		// TODO Auto-generated method stub
		Graphics graphics = getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillOval(t.getX(), t.getY(), 30, 30);
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
