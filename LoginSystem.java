package test;

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

class LoginSystem implements ActionListener {
  ArrayList<Account> myList;
  Login login;
  CreateAccount createAccount;
  int loggedin;

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == login.btnLogin){
      System.out.println("login");
	  loggedin = login.login(login.txtId.getText(), login.txtPasswd.getText());

	  if(loggedin == 1);
	  else {
		JOptionPane.showMessageDialog(null, "try again");
		login.txtId.setText("");
		login.txtId.setText("");
	  }
    }
    else if(e.getSource() == login.btnCreateAccount){
      System.out.println("create account");
      createAccount.setVisible(true);
    }
  }
  LoginSystem(){
    myList = new ArrayList<Account>();
    login = new Login(myList, this);
    createAccount = new CreateAccount(myList);
  }

  public int run(){
    LoginSystem loginSystem = new LoginSystem();
    loginSystem.login.setVisible(true);

    while(loginSystem.loggedin != 1) {
    	System.out.println("");
    } //busy wait

    loginSystem.login.dispose();
    loginSystem.createAccount.dispose();

    System.out.println("logged in");

    return 1;
  }
}
