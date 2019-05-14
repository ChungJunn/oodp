package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Font;

public class Login extends JFrame {
	ArrayList<Account> myList;
	
	private JPanel contentPane;
	JTextField txtId;
	private final Action action = new SwingAction();
	JTextField txtPasswd;
	private JLabel lblPasswd;
	JButton btnLogin;
	JButton btnCreateAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(new ArrayList<Account>(), new LoginSystem());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login(ArrayList<Account> list, LoginSystem loginSystem) {
		myList = list;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblId.setBounds(207, 292, 100, 80);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		txtId.setBounds(424, 292, 400, 80);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		lblPasswd = new JLabel("passwd");
		lblPasswd.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblPasswd.setBounds(207, 378, 200, 80);
		contentPane.add(lblPasswd);
		
		txtPasswd = new JTextField();
		txtPasswd.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		txtPasswd.setBounds(424, 378, 400, 80);
		contentPane.add(txtPasswd);
		txtPasswd.setColumns(10);
		
		btnLogin = new JButton("login");
		btnLogin.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		btnLogin.setBounds(293, 483, 200, 80);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(loginSystem);
		
		btnCreateAccount = new JButton("create account");
		btnCreateAccount.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		btnCreateAccount.setBounds(524, 483, 400, 80);
		contentPane.add(btnCreateAccount);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblLoginForm.setBounds(352, 132, 472, 100);
		contentPane.add(lblLoginForm);
		btnCreateAccount.addActionListener(loginSystem);
	}
	
  int login(String id, String passwd) {
		//TODO
		for (Account temp : myList) {
			if ( temp.equals(new Account(id, passwd))) {
				System.out.println("logged in");
				return 1;
			}
		}
		System.out.println("not logged in");
		System.out.printf("input: %s %s\n", id, passwd);
		return 0;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
