// 2019.5.14 Jang Ju Man

import java.util.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Stroke extends Shape{	//implements Serializable {
	public Stroke() {}
	
	public Stroke(Color color) {
		super(color);
	}
	
//	public void setColor(Color color) {
//		this.color= color;
//	}
//	
//	public Color getColor() {
//		return color;
//	}
	
	public void addPoint(Point p) {
		if(p != null) {
			points.add(p);
		}
	}
	 
	public List getPoints() {
		return points;
	}
	
	public void draw(Graphics g) {
		if(color != null) {
			g.setColor(color);
		}
		Point prev = null;
		Iterator iter = points.iterator();
		while(iter.hasNext()) {
			Point cur = (Point)iter.next();
			if(prev != null) {
				g.drawLine(prev.x, prev.y, cur.x, cur.y);
			}
			prev = cur;
		}
	}
	
	protected List points = new ArrayList();
//	protected Color color = Color.black;
}
