import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class GiveAttendance extends JInternalFrame {
	Connection con;
    PreparedStatement pspt;
    ResultSet rs;
    private JTextField sidfld;
    private JTextField Batchtf;
    private JTextField Branchtf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveAttendance frame = new GiveAttendance();
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
	public GiveAttendance() {
		
		con=DbManager2.ConnectDatabase();
		setBounds(450, 10, 930, 630);
		getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Enter Sid\r\n");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2.setBounds(79, 99, 100, 34);
		getContentPane().add(lblNewLabel_2);
		
		sidfld = new JTextField();
		sidfld.setFont(new Font("Arial", Font.BOLD, 16));
		sidfld.setColumns(10);
		sidfld.setBounds(337, 103, 214, 30);
		getContentPane().add(sidfld);
		
		
		JComboBox<Object> scodecombo = new JComboBox<Object>();
		scodecombo.setModel(new DefaultComboBoxModel(new String[] {"Java", "Python", "C", "AWS"}));
		scodecombo.setFont(new Font("Arial", Font.BOLD, 16));
		scodecombo.setBounds(337, 334, 214, 42);
		getContentPane().add(scodecombo);
		
		JComboBox<Object> comboapproval = new JComboBox<Object>();
		comboapproval.setModel(new DefaultComboBoxModel(new String[] {"Select Attendance", "Absent", "present"}));
		comboapproval.setFont(new Font("Arial", Font.BOLD, 16));
		comboapproval.setBounds(337, 429, 214, 42);
		getContentPane().add(comboapproval);
		
		JButton process = new JButton("Add");
		process.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(comboapproval.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(process, "Please Select The status");
				}
				else 
				{
					String s;
					
				 if(comboapproval.getSelectedIndex()==1) 
				 {
					 s=(String)comboapproval.getSelectedItem();
					 
				 }
				 
				 else 
				 {
					 s=(String)comboapproval.getSelectedItem();
					
				}
				 try 
				 {
					 String name,sbatch,sbranch,scode,status,q;
					long sid,tid;
					long Sid=Long.parseLong(sidfld.getText());
					tid=SessionTeacher .tr_no;
					sbatch=Batchtf.getText();
					sbranch=Branchtf.getText();
					scode=(String)scodecombo.getSelectedItem();
					status=s;
					
					System.out.println(Sid);
					System.out.println(tid);
					System.out.println(sbatch);
					System.out.println(sbranch);
					System.out.println(scode);
					System.out.println(status);
					
					q="INSERT INTO attendlog(sid, tid, batch, branch, subcode, status) values('"+Sid+"','"+tid+"','"+sbatch+"','"+sbranch+"','"+scode+"','"+status+"')";
	          		pspt=con.prepareStatement(q);
	          		int count=pspt.executeUpdate(q);
	          		
	          		Component btnlogin = null;
					if (count == 1) {
                        JOptionPane.showMessageDialog(btnlogin, "Inserted Success");
                    } else {
                    	JOptionPane.showMessageDialog(btnlogin, "Insertion Error");
                    }
					
					
				   
				 }
				 catch(Exception ex) 
				 {
					 System.out.println(ex.getMessage());
				 }
				
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		process.setFont(new Font("Arial", Font.PLAIN, 17));
		process.setBounds(670, 280, 185, 34);
		getContentPane().add(process);
		
		JLabel lblNewLabel_2_1 = new JLabel("Give Attendance");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(10, 21, 883, 34);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter Batch");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(79, 177, 147, 34);
		getContentPane().add(lblNewLabel_2_2);
		
		Batchtf = new JTextField();
		Batchtf.setFont(new Font("Arial", Font.BOLD, 16));
		Batchtf.setColumns(10);
		Batchtf.setBounds(337, 181, 214, 30);
		getContentPane().add(Batchtf);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Enter Branch");
		lblNewLabel_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2_2_1.setBounds(79, 256, 147, 34);
		getContentPane().add(lblNewLabel_2_2_1);
		
		Branchtf = new JTextField();
		Branchtf.setFont(new Font("Arial", Font.BOLD, 16));
		Branchtf.setColumns(10);
		Branchtf.setBounds(337, 260, 214, 30);
		getContentPane().add(Branchtf);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Enter SubjectCode");
		lblNewLabel_2_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2_2_1_1.setBounds(79, 334, 214, 34);
		getContentPane().add(lblNewLabel_2_2_1_1);
		
		
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Select Status");
		lblNewLabel_2_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2_2_1_1_1.setBounds(79, 432, 214, 34);
		getContentPane().add(lblNewLabel_2_2_1_1_1);
		
		

	}
}
