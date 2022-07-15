

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;

public class StudentDash extends JFrame {
	Connection con;
    PreparedStatement pspt;
    ResultSet rs;
    
    
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDash frame = new StudentDash();
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
	public StudentDash() {
		con=DbManager2.ConnectDatabase();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 218, 487);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 10, 200, 62);
		panel.add(lblNewLabel);
		
		JButton Logout = new JButton("LogOut");
		Logout.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		Logout.setForeground(Color.GREEN);
		Logout.setBackground(Color.YELLOW);
		Logout.setBounds(43, 390, 119, 46);
		panel.add(Logout);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Regd", "Tid", "batch", "branch", "subcode", "Date", "Status"
			}
		));
		table.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		table.setBounds(217, 0, 611, 477);
		contentPane.add(table);
		
		String q;
		long stid=SessionStudent.sr_no;
		
		try {
			  q="select * from attendlog where sid='"+stid+"'";
//			  q="select * from attendlog where sid=210720100009 ";
				pspt=con.prepareStatement(q);
				rs=pspt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
		  }
	
		  catch (Exception e) {
			// TODO: handle exception
			  System.out.println(e);
		}
	}
}
