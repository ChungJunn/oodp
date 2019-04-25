import java.awt.*;
class First extends Frame{
First(){

Label l_id = new Label("id");
Label l_passwd = new Label("passwd");
l_id.setBounds(350, 300, 100, 60);
l_passwd.setBounds(350, 500, 100, 60);
add(l_id);
add(l_passwd);

TextField t_id = new TextField();
TextField t_passwd = new TextField();
t_id.setBounds(450, 300, 400, 60);
t_passwd.setBounds(450, 500, 400, 60);
add(t_id);
add(t_passwd);

Button b_login=new Button("login");
Button b_createAccount=new Button("createAccount"); //add button
b_login.setBounds(300,700,160,60);
b_createAccount.setBounds(600,700,160,60); //bounds
add(b_login);
add(b_createAccount);//adding button into frame

setSize(1000,1000);//frame size 300 width and 300 height
setLayout(null);//no layout manager
setVisible(true);//now frame will be visible, by default not visible
}
public static void main(String args[]){
First f=new First();
}}
