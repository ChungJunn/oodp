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
		
		txtMemo.setBounds(1113, 254, 368, 232);
		contentPane.add(txtMemo);
		btnCreate.addActionListener(this);
		
		btnCreate.setBounds(1275, 499, 206, 43);
		contentPane.add(btnCreate);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(1294, 112, 187, 41);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtDueDate = new JTextField();
		txtDueDate.setBounds(1294, 171, 187, 41);
		contentPane.add(txtDueDate);
		txtDueDate.setColumns(10);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(1126, 174, 355, 35);
		contentPane.add(lblDueDate);
		
		JLabel lblMemo = new JLabel("Memo");
		lblMemo.setBounds(1109, 216, 372, 35);
		contentPane.add(lblMemo);
		
		JLabel label = new JLabel("\uC77C\uC815\uB4F1\uB85D");
		label.setBounds(1045, 45, 436, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC77C\uC815");
		label_1.setBounds(721, 45, 137, 35);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(658, 112, 266, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(658, 171, 266, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(567, 263, 357, 203);
		contentPane.add(textArea);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(519, 115, 137, 35);
		contentPane.add(lblName_1);
		
		JLabel lblDuedate = new JLabel("DueDate");
		lblDuedate.setBounds(519, 174, 137, 35);
		contentPane.add(lblDuedate);
		
		JLabel lblMemo_1 = new JLabel("Memo");
		lblMemo_1.setBounds(567, 223, 137, 35);
		contentPane.add(lblMemo_1);
		
		JList list = new JList();
		list.setBounds(52, 171, 393, 328);
		contentPane.add(list);
		
		JLabel lblmySchedule = new JLabel("\uB098\uC758\uC77C\uC815");
		lblmySchedule.setBounds(52, 118, 137, 35);
		contentPane.add(lblmySchedule);
		
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


