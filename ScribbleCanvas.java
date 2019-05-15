// 2019.5.1 Jang Ju Man
//package scribble1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Graphics;
import java.util.*;
import java.io.*;
import javax.swing.JPanel;
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
	
	public void addShape(Shape shape) {
		if(shape != null) {
			shapes.add(shape);
		}
	}
//	
//	public void startStroke(Point p) {
//		curStroke = new Stroke(curColor);
//		curStroke.addPoint(p);
//	}
//	
//	public void addPointToStroke(Point p) {
//		if(curStroke != null) {
//			curStroke.addPoint(p);
//		}
//	}
//	
//	public void endStroke(Point p) {
//		if(curStroke != null) {
//			curStroke.addPoint(p);
//			curStroke = null;
//		}
//	}
	
	public void paint(Graphics g) {
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.black);
		
		if(shapes != null) {
			Iterator iter = shapes.iterator();
			
			while(iter.hasNext()){
				Shape shape = (Shape) iter.next();
				
				if(shape != null) {
//					g.setColor(shape.getColor());
//					Point prev = null;
//					List points = stroke.getPoints();
//					Iterator iter2 = points.iterator();
//					
//					while(iter2.hasNext()) {
//						Point cur = (Point) iter2.next();
//						if(prev != null) {
//							g.drawLine(prev.x, prev.y, cur.x, cur.y);
//						}
//						prev = cur;
//						
//					}
					shape.draw(g);
				}
			}
		}
	}
	public void clear() {
		shapes.clear();
		repaint();
	}
	
	public void newFile() {
		shapes.clear();
		repaint();
	}
	
	public void openFile(String filename) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			shapes = (List) in.readObject();
			in.close();
			repaint();
			
//			ObjectInputStream re = new ObjectInputStream(new FileInputStream(filename));
//			Object obj = re.readObject();
//			String outstr = (String) obj;
//			System.out.println(outstr);
//			re.close();
			
		}catch(IOException e1){
			System.out.println("unable to open file : " + filename);
		}catch(ClassNotFoundException e2) {
			System.out.println(e2);
		}
////		// after version iter1
//		FileDialog fdlg = new FileDialog(this, "open", FileDialog.LOAD);
//		fdlg.setVisible(true);
//		
//		String dir = fdlg.getDirectory();
//
//		String file = fdlg.getFile();
//		
//
//		if(dir == null || file == null){	// 파일 선택 없이 다이얼로그를 종료할시 작업 수행 없이 바로 리턴
//			return;
//		}
//		
	}
	
	public void saveFile(String filename) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(shapes);
			out.close();
			System.out.println("save drawing to "+filename);
		}catch(IOException e){
			System.out.println("unable to write file : " + filename);
		}
	}
	
	// factory method
	protected EventListener makeCanvasListener() {
		return new ScribbleCanvasListener(this);
	}
	
	// the list of shapes of the drawing
	// the elements are instances of stroke
	protected List shapes = new ArrayList();
	
//	protected Stroke curStroke = null;
	protected Color curColor = Color.black;
	
	protected EventListener listener;
	protected boolean mouseButtonDown = false;
	protected int x,y;
}
