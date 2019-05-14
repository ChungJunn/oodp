package login;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.awt.Font;

public class CreateAccount extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPassword;
	private JButton btnCreateAccount;
	
	ArrayList<Account> myList;
	private JTextField txtReEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount(new ArrayList<Account>());
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
	public CreateAccount(ArrayList<Account> list) {
		myList = list;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblId.setBounds(152, 120, 100, 80);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		txtId.setBounds(418, 120, 400, 80);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblPassword.setBounds(152, 205, 250, 80);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		txtPassword.setBounds(418, 205, 400, 80);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnCreateAccount = new JButton("CreateAccount");
		btnCreateAccount.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		btnCreateAccount.setBounds(418, 396, 350, 80);
		contentPane.add(btnCreateAccount);
		
		txtReEnter = new JTextField();
		txtReEnter.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		txtReEnter.setBounds(418, 291, 400, 80);
		contentPane.add(txtReEnter);
		txtReEnter.setColumns(10);
		
		JLabel lblReenter = new JLabel("Re-Enter");
		lblReenter.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblReenter.setBounds(152, 291, 200, 80);
		contentPane.add(lblReenter);
		btnCreateAccount.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//create account
		if(txtPassword.getText().contentEquals(txtReEnter.getText())) {
			myList.add(new Account(txtId.getText(), txtPassword.getText()));
			txtId.setText("");
			txtPassword.setText("");
			txtReEnter.setText("");
			
			//logging
			for (Account temp : myList) {
				System.out.printf("%s %s\n", temp.id, temp.passwd);
			}
			this.setVisible(false);
			return;
		}
		else {
			JOptionPane.showMessageDialog(null, "Passwords do not match!");
		}
	}
}
