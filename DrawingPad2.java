//
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import javax.swing.*;
//
//public class DrawingPad2 extends DrawingPad {
//
//	public DrawingPad2(String title) {
//		super(title);
//	}
//	
//	protected void initTool() {
//		toolkit = new ToolKit();
//		toolkit.addTool(new ScribbleTool(canvas, "Scribble"));
//		toolkit.addTool(new TwoEndsShapeTool(canvas, "Line", newLineShape()));
//		toolkit.addTool(new TwoEndsShapeTool(canvas, "Oval", newOvalShape()));
//		toolkit.addTool(new TwoEndsShapeTool(canvas, "Rect", newRectangleShape()));
//		toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Oval", newFilledOvalShape()));
//		toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Rect", newFilledRectShape()));
//		drawingCanvas.setTool(toolkit.getTool(0));
//	}
//	
//	public static void main(String[] args) {
//		JFrame frame = new draw2.DrawingPad2("Dr Pd");
//		frame.setSize(WIDTH, HEIGHT);
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		frame.setLocation(screenSize.width/2 - WIDTH/2, screenSize.height/2 - HEIGHT/2);
//		frame.show();
//	}
//}
