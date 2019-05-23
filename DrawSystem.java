// Drawing tool 5.1
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class DrawSystem extends JFrame {
	
	public DrawSystem(String title) {
		super(title);
		
		// calling factory method
		canvas = makeCanvas();
		getContentPane().setLayout(new BorderLayout());
		menuBar = CreateMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		getContentPane().add(canvas, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(exitAction != null) {
					exitAction.actionPerformed(new ActionEvent(DrawSystem.this, 0, null));
				}
			}
		});
	}
	
	protected JMenuBar CreateMenuBar() {
		
		//after refactoring
		JMenuBar menuBar = new JMenuBar();
		JMenuItem [] mi = new JMenuItem[5];
		String[] FileMenu = {"New", "Open", "Save", "Save as", "Exit"};
		JMenu menu = new JMenu("File");
		
		MenuActionListener listener = new MenuActionListener();
		// file menu
		for(int i=0; i<mi.length; i++) {
			if(i == 4) {
				menu.add(new JSeparator());
			}
			mi[i] = new JMenuItem(FileMenu[i]);
			mi[i].addActionListener(listener);
			menu.add(mi[i]);
		}
		menuBar.add(menu);
		
		// option menu
		JMenuItem [] mi2 = new JMenuItem[1];
		menu = new JMenu("Option");
		String[] OptionMenu = {"Color"};
		for(int i=0; i<mi2.length; i++) {
			if(i == 4) {
				menu.add(new JSeparator());
			}
			mi2[i] = new JMenuItem(OptionMenu[i]);
			mi2[i].addActionListener(listener);
			menu.add(mi2[i]);
		}
		menuBar.add(menu);
		
		// tool menu
		JMenuItem [] mi3 = new JMenuItem[1];
		menu = new JMenu("tool");
		String[] ToolMenu = {"Clear"};
		for(int i=0; i<mi3.length; i++) {
			if(i == 4) {
				menu.add(new JSeparator());
			}
			mi3[i] = new JMenuItem(ToolMenu[i]);
			mi3[i].addActionListener(listener);
			menu.add(mi3[i]);
		}
		menuBar.add(menu);

		//horizontal space
		menuBar.add(Box.createHorizontalGlue());
		
		// help menu
		JMenuItem [] mi4 = new JMenuItem[1];
		menu = new JMenu("Help");
		String[] HelpMenu = {"About"};
		for(int i=0; i<mi4.length; i++) {
			if(i == 4) {
				menu.add(new JSeparator());
			}
			mi4[i] = new JMenuItem(HelpMenu[i]);
			mi4[i].addActionListener(listener);
			menu.add(mi4[i]);
		}
		
		menuBar.add(menu);
		
		return menuBar;
		
	}
	
	//after refactoring
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
				case "New":
					newFile();
					break;
					
				case "Open":
					int retval = chooser.showDialog(null, "Open");
					if(retval == JFileChooser.APPROVE_OPTION) {
						File theFile = chooser.getSelectedFile();
						if(theFile != null) {
							String filename = chooser.getSelectedFile().getAbsolutePath();
							openFile(filename);
						}
					}
					break;
					
				case "Save":
					saveFile();
					break;
					
				case "Save as":
					int retval2 = chooser.showDialog(null, "Save As");
					if(retval2 == JFileChooser.APPROVE_OPTION) {
						File theFile = chooser.getSelectedFile();
						if(theFile != null) {
							if(!theFile.isDirectory()) {
								String filename = chooser.getSelectedFile().getAbsolutePath();
								saveFileAs(filename);
							}
						}
					}
					break;
					
				case "Exit":
					int result = JOptionPane.showConfirmDialog(null, "Do you want to exit Drawing pad?", "Exit Drawing Pad?", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_NO_OPTION) {
						saveFile();
						System.exit(0);
					}
					break;
					
				case "Color":
					ColorDialog dialog_color = new ColorDialog(DrawSystem.this, "Choose color", canvas.getCurColor());
					Color result_color = dialog_color.showDialog();
					if(result_color != null) {
						canvas.setCurColor(result_color);
					}
					break;
					
				case "Clear":
					clear();
					break;
					
				case "About":
					JOptionPane.showMessageDialog(null, "DrawingPad version 1.0\nCopyright (c) Xiaoping Jia 2002", "About", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		}
	}
	
	// factory method
	protected ScribbleCanvas makeCanvas() {
		return new ScribbleCanvas();
	}
	
	public void run() {
//	public static void main(String[] args) {
		int drawing_w = 1000; //600;
		int drawing_h = 800;  //400;
		JFrame frame = new DrawSystem("Drawing Pad");
		frame.setSize(drawing_w, drawing_h);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width/2 - drawing_w/2, screenSize.height/2 - drawing_h/2);
		frame.show();
	}
	
	protected String currentFilename = null;
	protected ScribbleCanvas canvas;
	protected ActionListener exitAction;
	protected JFileChooser chooser = new JFileChooser(".");
	
	
	
	protected void clear() {
		canvas.clear();
	}
	
	protected void newFile() {
		currentFilename = null;
		canvas.newFile();
		setTitle("Drawing pad");
	}

	protected void openFile(String filename) {
		currentFilename = filename;
		canvas.openFile(filename);
		setTitle("Drawing Pad [" + currentFilename + "]");
	}
		
	protected void saveFile() {
		if(currentFilename == null) {
			currentFilename = "Untitled";
		}
		canvas.saveFile(currentFilename);
		setTitle("Drawing pad [" + currentFilename + "]");
	}
		
	protected void saveFileAs(String filename) {
		currentFilename = filename;
		canvas.saveFile(filename);
		setTitle("Drawing pad [ "+ currentFilename + "]");
	}
	
	// 만일을 위해 보존할 것. protected 부분이 삭제됨 위에서
//	class ColorListener implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			Color result = dialog.showDialog();
//			if(result != null) {
//				canvas.setCurColor(result);
//			}
//		}
//		
//		protected ColorDialog dialog = new ColorDialog(DrawSystem.this, "Choose color", canvas.getCurColor());
//	}
	
	JMenuBar menuBar = new JMenuBar();

}
