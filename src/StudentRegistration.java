import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class StudentRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField tid;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JTextField branchtf;
    private JTextField batchtf;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentRegistration frame = new StudentRegistration();
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
    public StudentRegistration() {
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New Student Register");
        lblNewUserRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(10, 52, 980, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        tid = new JTextField();
        tid.setFont(new Font("Tahoma", Font.PLAIN, 32));
        tid.setBounds(707, 118, 228, 50);
        contentPane.add(tid);
        tid.setColumns(10);

        JLabel TecherID = new JLabel("Regd No");
        TecherID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        TecherID.setBounds(542, 133, 99, 29);
        contentPane.add(TecherID);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 212, 99, 24);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 195, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String first_name = firstname.getText();
                String last_name = lastname.getText();
                String email_id = email.getText();
                long regdnos = Long.parseLong(tid.getText());
                String branch = branchtf.getText();
                String batch = batchtf.getText();
                String password = passwordField.getText();
                
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(email_id);
                System.out.println(regdnos);
                System.out.println(branch);
                System.out.println(batch);

                

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "");
                    System.out.println("ok ok ");
                    String query = "INSERT INTO student(first_name, last_name, regdno, email, password, branch, batch) values('"+first_name+"','"+last_name+"','"+regdnos+"','"+email_id+"','"+password+"','"+branch+"','"+batch+"')";
                    System.out.println("ok ok ok ok");
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
        
        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBranch.setBounds(542, 276, 99, 29);
        contentPane.add(lblBranch);
        
        JLabel batch = new JLabel("Batch");
        batch.setHorizontalAlignment(SwingConstants.LEFT);
        batch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        batch.setBounds(542, 340, 99, 29);
        contentPane.add(batch);
        
        branchtf = new JTextField();
        branchtf.setFont(new Font("Tahoma", Font.PLAIN, 32));
        branchtf.setColumns(10);
        branchtf.setBounds(707, 259, 228, 50);
        contentPane.add(branchtf);
        
        batchtf = new JTextField();
        batchtf.setFont(new Font("Tahoma", Font.PLAIN, 32));
        batchtf.setColumns(10);
        batchtf.setBounds(707, 324, 228, 50);
        contentPane.add(batchtf);
    }
}