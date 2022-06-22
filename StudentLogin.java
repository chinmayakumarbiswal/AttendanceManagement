import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class StudentLogin extends JFrame {
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentLogin frame = new StudentLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




    public StudentLogin() {
        setBounds(450, 190, 500, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblNewUserRegister = new JLabel("Student Login");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(200, 52, 325, 50);
        contentPane.add(lblNewUserRegister);


        JLabel lblUsername = new JLabel("Email");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(0, 159, 99, 29);
        contentPane.add(lblUsername);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(200, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(0, 245, 99, 24);
        contentPane.add(lblPassword);


        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(200, 235, 228, 50);
        contentPane.add(passwordField);
    

        btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = username.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "");
                    Statement stmt=connection.createStatement();
                    String sql = "SELECT * FROM student where  email='"+email+"' AND password='"+password+"'";
                    ResultSet rs=stmt.executeQuery(sql);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Welcome "+email+"Login and redirect");
                    } else {
                        JOptionPane.showMessageDialog(null,"Login Error");
                    }
                    connection.close();
                } 
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(200, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}
