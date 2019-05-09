import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import draw.DrawSystem;
import login.LoginSystem;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.event.*;
import draw.*;
import login.*;

public class MainSystem2 extends JFrame implements ActionListener {
	JButton btnNoteMemo = new JButton("NoteMemo");
	JButton btnSchedule = new JButton("Schedule");
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginSystem loginSystem = new LoginSystem();
		
		System.out.println("[main system] This is main system");

		loginSystem.run();
		MainSystem2 frame = new MainSystem2();
		frame.setVisible(true);
					
	}

	/**
	 * Create the frame.
	 */
	public MainSystem2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNoteMemo.setBounds(114, 183, 191, 43);
		contentPane.add(btnNoteMemo);
		btnNoteMemo.addActionListener(this);
		
		btnSchedule.setBounds(114, 263, 191, 43);
		contentPane.add(btnSchedule);
		btnSchedule.addActionListener(this);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(114, 36, 191, 35);
		contentPane.add(lblMainMenu);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNoteMemo) {
			DrawSystem drawSystem = new DrawSystem();
			drawSystem.run();
		}
		else if(e.getSource() == btnSchedule) {
			TaskSystem taskSystem = new TaskSystem();
			taskSystem.run();
		}
	}
}
