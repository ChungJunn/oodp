// 2019.5.1 Jang Ju Man
//package scribble1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;
import java.util.*;
import java.io.*;
//import javax.swing.JPanel;
import java.awt.event.*;
import java.util.EventListener;
import javax.swing.*;

public class ScribbleCanvas extends JPanel {
	public ScribbleCanvas() {
		listener = new ScribbleCanvasListener(this);
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}
	
	public void setCurColor(Color curColor) {
		this.curColor = curColor;
	}
	
	public Color getCurColor() {
		return curColor;
	}
	
	public void startStroke(Point p) {
		curStroke = new Stroke(curColor);
		curStroke.addPoint(p);
	}
	
	public void addPointToStroke(Point p) {
		if(curStroke != null) {
			curStroke.addPoint(p);
		}
	}
	
	public void endStroke(Point p) {
		if(curStroke != null) {
			curStroke.addPoint(p);
			curStroke = null;
		}
	}
	
	public void paint(Graphics g) {
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.black);
		if(strokes != null) {
			Iterator iter1 = strokes.iterator();
			
			while(iter1.hasNext()){
				Stroke stroke = (Stroke) iter1.next();
				
				if(stroke != null) {
					g.setColor(stroke.getColor());
					Point prev = null;
					List points = stroke.getPoints();
					Iterator iter2 = points.iterator();
					
					while(iter2.hasNext()) {
						Point cur = (Point) iter2.next();
						if(prev != null) {
							g.drawLine(prev.x, prev.y, cur.x, cur.y);
						}
						prev = cur;
						
					}
				}
			}
		}
	}
	
	public void newFile() {
		strokes.clear();
		repaint();
	}
	
	public void saveFile(String filename) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(strokes);
			out.close();
			System.out.println("sace drawing to "+filename);
		}catch(IOException e){
			System.out.println("unable to write file : " + filename);
		}
	}
	
	public void openFile(String filename) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			strokes = (List) in.readObject();
			in.close();
			repaint();
		}catch(IOException e1){
			System.out.println("unable to open file : " + filename);
		}catch(ClassNotFoundException e2) {
			System.out.println(e2);
		}
	}
	
	protected List strokes = new ArrayList();
	
	protected Stroke curStroke = null;
	protected Color curColor = Color.black;
	
	protected EventListener listener;
	protected boolean mouseButtonDown = false;
	protected int x,y;
}
