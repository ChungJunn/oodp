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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		contentPane.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		contentPane.add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		lblPasswd = new JLabel("passwd");
		GridBagConstraints gbc_lblPasswd = new GridBagConstraints();
		gbc_lblPasswd.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswd.anchor = GridBagConstraints.EAST;
		gbc_lblPasswd.gridx = 0;
		gbc_lblPasswd.gridy = 1;
		contentPane.add(lblPasswd, gbc_lblPasswd);
		
		txtPasswd = new JTextField();
		GridBagConstraints gbc_txtPasswd = new GridBagConstraints();
		gbc_txtPasswd.insets = new Insets(0, 0, 5, 0);
		gbc_txtPasswd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasswd.gridx = 1;
		gbc_txtPasswd.gridy = 1;
		contentPane.add(txtPasswd, gbc_txtPasswd);
		txtPasswd.setColumns(10);
		
		btnLogin = new JButton("login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 3;
		contentPane.add(btnLogin, gbc_btnLogin);
		btnLogin.addActionListener(loginSystem);
		
		btnCreateAccount = new JButton("create account");
		GridBagConstraints gbc_btnCreateAccount = new GridBagConstraints();
		gbc_btnCreateAccount.gridx = 1;
		gbc_btnCreateAccount.gridy = 3;
		contentPane.add(btnCreateAccount, gbc_btnCreateAccount);
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
