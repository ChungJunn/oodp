// 필요없음. 연습
import java.awt.*;
import java.awt.event.*;

public class DrawingCanvasListener extends ScribbleCanvasListener{
	
	public DrawingCanvasListener(DrawingCanvas canvas) {
		super(canvas, null);
	}
	
	public Tool getTool() {
		return tool;
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}

}
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//
//public class DrawingCanvasListener implements MouseListener, MouseMotionListener {
//	public void mousePressed(MouseEvent e) {
//		switch (drawingPad.getCurrentShape()) {
//			case DrawingPad.SCRIBBLE:
//				// handle mouse pressed event for scribbling
//				break;
//			case DrawingPad.LINE:
//				//`
//				break;
//			case DrawingPad.RECTANCLE:
//				//`
//				break;
//			case DrawingPad.OVAL:
//				//`
//				break;
//		}
//	}
//	
//	public void mouseDragged(MouseEvent e) {
//		switch(drawingPad.getCurrentShape()) {
//			case DrawingPad.SCRIBBLE:
//				//` 
//				break;
//			case 
//		}
//	}
//}
