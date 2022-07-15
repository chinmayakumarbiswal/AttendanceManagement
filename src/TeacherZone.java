import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import lms_project.LoginFrame;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherZone extends JFrame {

	private JPanel contentPane;
	ViewAttendanceIF obj =new ViewAttendanceIF();
	GiveAttendance obj1=new GiveAttendance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherZone frame = new TeacherZone();
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
	public TeacherZone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane Dp = new JDesktopPane();
		Dp.setBounds(10, 10, 1376, 653);
		contentPane.add(Dp);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 439, 653);
		Dp.add(panel);
		
		JLabel s_name = new JLabel("Rakesh\r\n");
		s_name.setHorizontalAlignment(SwingConstants.CENTER);
		s_name.setFont(new Font("Arial", Font.BOLD, 18));
		s_name.setBounds(0, 79, 429, 31);
		panel.add(s_name);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 38, 419, 22);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(74, 600, 257, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Give Attendance");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dp.add(obj1);
				obj1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBounds(74, 505, 257, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("View Attendance\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dp.add(obj);
				obj.setVisible(true);
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(74, 408, 257, 31);
		panel.add(btnNewButton_1_1);
		
		JLabel btne2 = new JLabel("Exit");
		btne2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				obj1.setVisible(false);
			
			}
		});
		btne2.setFont(new Font("Arial", Font.BOLD, 20));
		btne2.setBounds(341, 517, 60, 25);
		panel.add(btne2);
		
		JLabel btne1 = new JLabel("Exit");
		btne1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				obj.setVisible(false);
			}
		});
		btne1.setFont(new Font("Arial", Font.BOLD, 20));
		btne1.setBounds(341, 420, 60, 25);
		panel.add(btne1);
	}

}
