// 2019.5.01 Jang Ju Man

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
		tool = new ScribbleTool(canvas, "Scribble");
	}
	
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		tool.startShape(p);
		canvas.mouseButtonDown = true;
//		canvas.startStroke(p);
		canvas.x = p.x;
		canvas.y = p.y;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		if(canvas.mouseButtonDown) {
			tool.addPointToShape(p);
			
//			canvas.addPointToStroke(p);
//			Graphics g = canvas.getGraphics();
//			g.setColor(canvas.getCurColor());
//			g.drawLine(canvas.x, canvas.y, p.x, p.y);
			
//			canvas.getGraphics().drawLine(canvas.x, canvas.y, p.x, p.y);
			canvas.x = p.x;
			canvas.y = p.y;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		Point p = e.getPoint();
		tool.endShape(p);
		canvas.mouseButtonDown = false;
		
//		canvas.endStroke(p);
//		canvas.mouseButtonDown = false;
	}
		
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
	protected ScribbleCanvasListener(ScribbleCanvas canvas, Tool tool) {
		this.canvas = canvas;
		this.tool = tool;
	}
	protected ScribbleCanvas canvas;
	protected Tool tool;
}
