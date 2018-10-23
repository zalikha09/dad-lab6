package view;


import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.rpc.holders.StringHolder;

import org.example.www.Lecture.LectureProxy;


import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class Main {

	private JFrame frame;
	private JTextField textFieldLogin;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldUserLevel;
	private JTextField textFieldLastLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(32, 31, 76, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblFirstNam = new JLabel("First Name");
		lblFirstNam.setBounds(10, 121, 76, 14);
		frame.getContentPane().add(lblFirstNam);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 183, 76, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblUserLevel = new JLabel("User Level");
		lblUserLevel.setBounds(190, 121, 76, 14);
		frame.getContentPane().add(lblUserLevel);
		
		JLabel lblLastLogin = new JLabel("Last Login");
		lblLastLogin.setBounds(190, 183, 76, 14);
		frame.getContentPane().add(lblLastLogin);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread thread1 = new Thread() {
					public void run() {
						LectureProxy lecture = new LectureProxy();
						
						StringHolder strFirstName = new StringHolder();
						StringHolder strLastName = new StringHolder();
						StringHolder strUserLvl = new StringHolder();
						StringHolder strLastLogin = new StringHolder();
						try {
							lecture.fnGetStudQuery(textFieldLogin.getText(), strFirstName, strLastName, strUserLvl, strLastLogin);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textFieldFirstName.setText(strFirstName.value);
						textFieldLastName.setText(strLastName.value);
						textFieldLastLogin.setText(strLastLogin.value);
						textFieldUserLevel.setText(strUserLvl.value);
						
					}
				};
				thread1.start();
			}
		});
		btnSearch.setBounds(267, 27, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(74, 28, 183, 20);
		frame.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(94, 118, 86, 20);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(94, 180, 86, 20);
		frame.getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldUserLevel = new JTextField();
		textFieldUserLevel.setBounds(270, 118, 86, 20);
		frame.getContentPane().add(textFieldUserLevel);
		textFieldUserLevel.setColumns(10);
		
		textFieldLastLogin = new JTextField();
		textFieldLastLogin.setBounds(270, 180, 86, 20);
		frame.getContentPane().add(textFieldLastLogin);
		textFieldLastLogin.setColumns(10);
	}
}
