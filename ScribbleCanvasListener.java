// 2019.5.1 Jang Ju Man

//package scribble1;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;


public class ScribbleCanvasListener implements MouseListener, MouseMotionListener {
	public ScribbleCanvasListener(ScribbleCanvas canvas) {
		this.canvas = canvas;
	}
	
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		canvas.mouseButtonDown = true;
		canvas.startStroke(p);
		canvas.x = p.x;
		canvas.y = p.y;
	}
	
	public void mouseReleased(MouseEvent e) {
		Point p = e.getPoint();
		canvas.endStroke(p);
		canvas.mouseButtonDown = false;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		if(canvas.mouseButtonDown) {
			canvas.addPointToStroke(p);
			Graphics g = canvas.getGraphics();
			g.setColor(canvas.getCurColor());
			g.drawLine(canvas.x, canvas.y, p.x, p.y);
			
//			canvas.getGraphics().drawLine(canvas.x, canvas.y, p.x, p.y);
			canvas.x = p.x;
			canvas.y = p.y;
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
	protected ScribbleCanvas canvas;
}
