import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewAttendanceIF extends JInternalFrame {
	private JTable table;
	Connection con;
    PreparedStatement pspt;
    ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAttendanceIF frame = new ViewAttendanceIF();
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
	public ViewAttendanceIF() {
		con=DbManager2.ConnectDatabase();
		setBounds(450, 10, 930, 630);
		getContentPane().setLayout(null);
		
		JComboBox combob1 = new JComboBox();
		combob1.setFont(new Font("Tahoma", Font.BOLD, 20));
		combob1.setModel(new DefaultComboBoxModel(new String[] {"Select Branch", "MCA", "BTech", "Msc", "Bsc"}));
		combob1.setBounds(63, 441, 168, 21);
		getContentPane().add(combob1);
		
		JComboBox combob2 = new JComboBox();
		combob2.setModel(new DefaultComboBoxModel(new String[] {"select Batch", "2022", "2021", "2020", "2019"}));
		combob2.setFont(new Font("Tahoma", Font.BOLD, 20));
		combob2.setBounds(680, 445, 168, 21);
		getContentPane().add(combob2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 10, 898, 398);
		getContentPane().add(table);
 		

			JButton btn = new JButton("Submit");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String q="";
			 		String branch=(String)combob1.getSelectedItem();
			 		String batch=(String)combob2.getSelectedItem();
			 		 try {
						  q="select * from attendlog where branch=? and batch=? ";
							pspt=con.prepareStatement(q);
							pspt.setString(1,branch );
							pspt.setString(2,batch );
							rs=pspt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							
							
//							System.out.println(rs.getInt(1));
						  
						  
					  }
				
					  catch (Exception e1) {
						// TODO: handle exception
						  System.out.println(e1);
					}
				}
			});
			btn.setBounds(326, 537, 273, 30);
			getContentPane().add(btn);

	}
}
