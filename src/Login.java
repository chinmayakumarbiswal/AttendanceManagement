import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	Connection con;
    PreparedStatement pspt;
    ResultSet rs;
	private JPanel contentPane;
	private JTextField txtemail;
	private JPasswordField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1007, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=DbManager2.ConnectDatabase();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 5, 999, 658);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(10, 10, 979, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 5, 980, 54);
		panel_1.add(lblNewLabel);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtemail.setBounds(100, 201, 236, 33);
		panel.add(txtemail);
		txtemail.setColumns(10);
		
		JComboBox combouser = new JComboBox();
		combouser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		combouser.setModel(new DefaultComboBoxModel(new String[] {"Select user Type", "Student", "Faculty"}));
		combouser.setBounds(100, 437, 230, 33);
		panel.add(combouser);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Email");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(106, 151, 185, 40);
		panel.add(lblNewLabel_1);
		
		txtpwd = new JPasswordField();
		txtpwd.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtpwd.setBounds(100, 317, 230, 33);
		panel.add(txtpwd);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Password");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(100, 267, 185, 40);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter userType");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(100, 387, 185, 40);
		panel.add(lblNewLabel_1_1_1);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setBackground(Color.GREEN);
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email,pass,q1,q2;
//				String s;
				email=txtemail.getText();
				pass=String.valueOf(txtpwd.getPassword());
				 if(combouser.getSelectedIndex()==1 && (String)combouser.getSelectedItem()=="Student")
                 {
	  ///user is student not warden
          	  try {
          		  q1="select * from student where email=? and password=?";
          		  pspt=con.prepareStatement(q1);
          		  pspt.setString(1, email);
          		  pspt.setString(2,pass);
          		  rs=pspt.executeQuery();
          		  if(rs.next())
          		  {
          			  JOptionPane.showMessageDialog(btnlogin, " Welcome ,You are valid Student user");
          			  String fnamed=rs.getString(2);
          			  long r_no =rs.getLong(4);
          			  String e_mail=rs.getString(5);
          			  String branch=rs.getString(7);
          			  String batch=rs.getString(8);
          			  SessionStudent.sf_name=fnamed;
          			SessionStudent.sr_no=r_no;
          			SessionStudent.semail=e_mail;
          			SessionStudent.sbranch=branch;
          			SessionStudent.sbatch=batch;
          			  
          			  StudentDash obj=new StudentDash();
          			  setVisible(false);
          			  obj.setVisible(true);
          			  
          		  }
          		  else 
          		  {
          			  JOptionPane.showMessageDialog(btnlogin, " oops You are not valid User,Please sigup ");
          		  }
          	  } 
          	  
          		catch (Exception exc) 
          		{
					// TODO: handle exception
            		  System.out.println(exc);
				}
	  
	  
	  
	  
                    }
				 else
                 {
	  ///user is student not warden
          	  try {
          		  q1="select * from teacher where email=? and password=?";
          		  pspt=con.prepareStatement(q1);
          		  pspt.setString(1, email);
          		  pspt.setString(2,pass);
          		  rs=pspt.executeQuery();
          		  if(rs.next())
          		  {
          			  JOptionPane.showMessageDialog(btnlogin, " Welcome ,You are valid teacher user");
          			  
          			String fnamed=rs.getString(1);
        			long tr_no =rs.getLong(3);
        			String e_mail=rs.getString(4); 
        			
          			SessionTeacher.tf_name=fnamed;
          			SessionTeacher.tr_no=tr_no;
          			SessionTeacher.temail=e_mail;
          			  
          			  TeacherZone obj=new TeacherZone();
          			  setVisible(false);
          			  obj.setVisible(true);
          			  
          		  }
          		  else 
          		  {
          			  JOptionPane.showMessageDialog(btnlogin, " oops You are not valid User,Please sigup ");
          		  }
          	  } 
          	  
          		catch (Exception exc) 
          		{
					// TODO: handle exception
            		  System.out.println(exc);
				}
	  
	  
	  
	  
                    }
          		  
          	}	
				
			
                 
			}
		);
		btnlogin.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnlogin.setForeground(Color.BLUE);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnlogin.setBounds(100, 537, 220, 48);
		panel.add(btnlogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\MCA\\cutmimage.png"));
		lblNewLabel_2.setBounds(517, 89, 424, 559);
		panel.add(lblNewLabel_2);
		
	}
}
