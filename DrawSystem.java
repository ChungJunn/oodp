// Drawing tool 5.1
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class DrawSystem extends JFrame {
	public DrawSystem() {
		setTitle("Drawing Pad");
		canvas = new ScribbleCanvas();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(CreateMenuBar(), BorderLayout.NORTH);
		getContentPane().add(canvas,  BorderLayout.CENTER);
		
//		canvas.setBackground(Color.white);
//		getContentPane().setLayout(new BorderLayout());
//		getContentPane().add(canvas,  BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(exitAction != null) {
					exitAction.actionPerformed(new ActionEvent(DrawSystem.this, 0, null));
				}
			}
		});
		
//		<createMenuBar() method on page 411>
//		<newFile(), openFile(), saveFile(), and saveFileAs() method on page 416>
		
	} 
	
	public void run() {
		int drawing_w = 600;
		int drawing_h = 400;
		JFrame frame = new DrawSystem();
		frame.setSize(drawing_w, drawing_h);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width/2 - drawing_w/2, screenSize.height/2 - drawing_h/2);
		frame.show();
	}
	

	protected String currentFilename = null;
	protected ScribbleCanvas canvas;
	protected ActionListener exitAction;
	protected JFileChooser chooser = new JFileChooser(".");
	
	protected JMenuBar CreateMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem mi;
		
		// FIle menu
		menu = new JMenu("File");
		menuBar.add(menu);
		
		mi = new JMenuItem("New");
		menu.add(mi);
		mi.addActionListener(new NewFileListener());
		
		mi = new JMenuItem("Open");
		menu.add(mi);
		mi.addActionListener(new OpenFileListener());
		
		mi = new JMenuItem("Save");
		menu.add(mi);
		mi.addActionListener(new SaveFileListener());
		
		mi = new JMenuItem("Save As");
		menu.add(mi);
		mi.addActionListener(new SaveAsFileListener());
		
		menu.add(new JSeparator());
		
		exitAction = new ExitListener();
		mi = new JMenuItem("Exit");
		menu.add(mi);
		mi.addActionListener(exitAction);
		
		// option menu
		menu = new JMenu("Option");
		menuBar.add(menu);
		
		mi = new JMenuItem("Color");
		menu.add(mi);
		mi.addActionListener(new ColorListener());
		
		//horizontal space
		menuBar.add(Box.createHorizontalGlue());
		
		//Help menu
		menu = new JMenu("Help"); 
		menuBar.add(menu);
		
		mi = new JMenuItem("About");
		menu.add(mi);
		mi.addActionListener(new AboutListener());
		
		return menuBar;
		
	}
	
	class AboutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "DrawingPad version 1.0\nCopyright (c) Xiaoping Jia 2002", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	class NewFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			newFile();
		}
	}
	
	class OpenFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int retval = chooser.showDialog(null, "Open");
			if(retval == JFileChooser.APPROVE_OPTION) {
				File theFile = chooser.getSelectedFile();
				if(theFile != null) {
					String filename = chooser.getSelectedFile().getAbsolutePath();
					openFile(filename);
				}
			}
		}
	}
	
	class SaveFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			saveFile();
		}
	}
	
	class SaveAsFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int retval = chooser.showDialog(null, "Save As");
			if(retval == JFileChooser.APPROVE_OPTION) {
				File theFile = chooser.getSelectedFile();
				if(theFile != null) {
					if(!theFile.isDirectory()) {
						String filename = chooser.getSelectedFile().getAbsolutePath();
						saveFileAs(filename);
					}
				}
			}
		}
	}
	
	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "Do you want to exit Drawing pad?", "Exit Drawing Pad?", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_NO_OPTION) {
				saveFile();
				System.exit(0);
			}
			
		}
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
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Color result = dialog.showDialog();
			if(result != null) {
				canvas.setCurColor(result);
			}
		}
		
		protected ColorDialog dialog = new ColorDialog(DrawSystem.this, "Choose color", canvas.getCurColor());
	}
	

}
