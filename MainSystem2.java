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
import schedule.*;
import java.awt.Font;

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
		setBounds(100, 100, 2000, 1500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNoteMemo.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		
		btnNoteMemo.setBounds(31, 172, 300, 80);
		contentPane.add(btnNoteMemo);
		btnNoteMemo.addActionListener(this);
		btnSchedule.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		
		btnSchedule.setBounds(31, 277, 300, 80);
		contentPane.add(btnSchedule);
		btnSchedule.addActionListener(this);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblMainMenu.setBounds(31, 25, 300, 150);
		contentPane.add(lblMainMenu);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNoteMemo) {
			DrawSystem drawSystem = new DrawSystem();
			drawSystem.run();
		}
		else if(e.getSource() == btnSchedule) {
			ScheduleSystem scheduleSystem = new ScheduleSystem();
		}
	}
}
