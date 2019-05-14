package schedule;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Font;


public class ScheduleSystem extends JFrame implements ActionListener{
	
	ArrayList<Task> myList = new ArrayList<Task>();
	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtDueDate;
	private JTextField textField;
	private JTextField textField_1;
	JButton btnCreate = new JButton("\uC77C\uC815\uB9CC\uB4E4\uAE30");

	JTextArea txtMemo = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleSystem frame = new ScheduleSystem();
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
	public ScheduleSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1544, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMemo.setBounds(947, 263, 534, 232);
		contentPane.add(txtMemo);
		btnCreate.addActionListener(this);
		
		btnCreate.setBounds(1181, 520, 300, 80);
		contentPane.add(btnCreate);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(1181, 105, 300, 60);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtDueDate = new JTextField();
		txtDueDate.setBounds(1181, 170, 300, 60);
		contentPane.add(txtDueDate);
		txtDueDate.setColumns(10);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblDueDate.setBounds(955, 169, 355, 35);
		contentPane.add(lblDueDate);
		
		JLabel lblMemo = new JLabel("Memo");
		lblMemo.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblMemo.setBounds(937, 223, 372, 35);
		contentPane.add(lblMemo);
		
		JLabel label = new JLabel("\uC77C\uC815\uB4F1\uB85D");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		label.setBounds(1045, 45, 436, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC77C\uC815");
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		label_1.setBounds(476, 45, 137, 35);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(658, 112, 266, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(658, 185, 266, 60);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(486, 292, 438, 203);
		contentPane.add(textArea);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblName_1.setBounds(476, 130, 137, 35);
		contentPane.add(lblName_1);
		
		JLabel lblDuedate = new JLabel("DueDate");
		lblDuedate.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblDuedate.setBounds(476, 195, 181, 35);
		contentPane.add(lblDuedate);
		
		JLabel lblMemo_1 = new JLabel("Memo");
		lblMemo_1.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblMemo_1.setBounds(476, 252, 137, 35);
		contentPane.add(lblMemo_1);
		
		JList list = new JList();
		list.setBounds(52, 171, 393, 328);
		contentPane.add(list);
		
		JLabel lblmySchedule = new JLabel("\uB098\uC758\uC77C\uC815");
		lblmySchedule.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblmySchedule.setBounds(52, 118, 219, 35);
		contentPane.add(lblmySchedule);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("±¼¸²", Font.PLAIN, 45));
		lblName.setBounds(1017, 112, 137, 35);
		contentPane.add(lblName);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCreate) {
			myList.add(new Task(txtTitle.getText(), txtMemo.getText(), txtDueDate.getText()));
			
			for (Task temp : myList) {
				System.out.printf("%s\n%s\n%s\n\n", temp.name, temp.memo, temp.dueDate);
			}
		}
	}
}


