import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

class LoginSystem implements ActionListener {
  ArrayList<Account> myList;
  LoginFrame loginFrame;
  CreateAccountFrame createAccountFrame;

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == loginFrame.b_login){
      System.out.println("login");
      loginFrame.login(loginFrame.t_id.getText(), loginFrame.t_passwd.getText());
    }
    else if(e.getSource() == loginFrame.b_createAccount){
      System.out.println("create account");
      createAccountFrame.setVisible(true);
    }
  }
  LoginSystem(){
    myList = new ArrayList<Account>();
    loginFrame = new LoginFrame(myList, this);
    createAccountFrame = new CreateAccountFrame(myList);
  }

  public static void main(String args[]){
    LoginSystem loginSystem = new LoginSystem();
  }
}

class LoginFrame extends Frame {
  ArrayList<Account> myList;

  TextField t_id = new TextField();
  TextField t_passwd = new TextField();

  Button b_login=new Button("login");
  Button b_createAccount=new Button("createAccount"); //add button

  LoginFrame(ArrayList<Account> list, LoginSystem loginSystem){
    myList = list;

    Label l_id = new Label("id");
    Label l_passwd = new Label("passwd");
    l_id.setBounds(350, 300, 100, 60);
    l_passwd.setBounds(350, 500, 100, 60);
    add(l_id);
    add(l_passwd);

    t_id.setBounds(450, 300, 400, 60);
    t_passwd.setBounds(450, 500, 400, 60);
    add(t_id);
    add(t_passwd);

    b_login.setBounds(300,700,160,60);
    b_createAccount.setBounds(600,700,160,60); //bounds
    b_login.addActionListener(loginSystem);
    b_createAccount.addActionListener(loginSystem);

    add(b_login);
    add(b_createAccount);//adding button into frame

    setSize(1000,1000);//frame size 300 width and 300 height
    setLayout(null);//no layout manager
    setVisible(true);//now frame will be visible, by default not visible
  }

  int login(String id, String passwd) {
		//TODO
		for (Account temp : myList) {
			if ( temp.equals(new Account(id, passwd))) {
				System.out.println("logged in");
				return 1;
			}
			else {
				System.out.println("not logged in");
				System.out.printf("input: %s %s\n", id, passwd);
				return 0;
			}
		}
		return 0;
	}
}

class CreateAccountFrame extends Frame implements ActionListener{
  TextField t_id = new TextField();
  TextField t_passwd = new TextField();
  ArrayList<Account> myList;
  CreateAccountFrame(ArrayList<Account> list){
    myList = list;

    Label l_id = new Label("id");
    Label l_passwd = new Label("passwd");
    l_id.setBounds(350, 300, 100, 60);
    l_passwd.setBounds(350, 500, 100, 60);
    add(l_id);
    add(l_passwd);

    t_id.setBounds(450, 300, 400, 60);
    t_passwd.setBounds(450, 500, 400, 60);
    add(t_id);
    add(t_passwd);

    Button b_createAccount=new Button("createAccount"); //add button
    b_createAccount.setBounds(600,700,160,60); //bounds
    b_createAccount.addActionListener(this);
    add(b_createAccount);//adding button into frame

    setSize(1000,1000);//frame size 300 width and 300 height
    setLayout(null);//no layout manager
    setVisible(false);//now frame will be visible, by default not visible
    }

    public void actionPerformed(ActionEvent e){
      System.out.println("action performed");
      //create new account
      createAccount(t_id.getText(), t_passwd.getText());
      System.out.println("showing the registration DB");
      for(Account temp : myList) {
        System.out.printf("%s %s\n", temp.id, temp.passwd);
      }
      setVisible(false);
    }

    int createAccount(String id, String passwd) {
      //TODO
      myList.add(new Account(id, passwd));
      return 0;
    }
}

class Account {
  String id;
  String passwd;

  Account(String newId, String newPasswd){
    id = newId;
    passwd = newPasswd;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
    return true;
    }
    if (!(o instanceof Account)) {
    return false;
    }

    Account a = (Account) o;

    return id.equals(a.id) && passwd.equals(a.passwd);
  }
}
