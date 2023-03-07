import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUserName = new JLabel("User name");
		lbUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbUserName.setBounds(392, 167, 124, 42);
		contentPane.add(lbUserName);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbPassword.setBounds(392, 235, 124, 42);
		contentPane.add(lbPassword);
		
		user = new JTextField();
		user.setBounds(451, 208, 251, 36);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(65, 105, 225));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","2207");
					Statement stmt = con.createStatement();
					String sql = "Select * from tblogin where UserName ='"+user.getText()+"' and Password ='"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Sucessfull");
						JFrame jFrame = new JFrame();
						jFrame.dispose();
						
						EmployeeInfo empObj = new EmployeeInfo();
						empObj.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Wrong password");
					}
					con.close();
				}catch(Exception e1) {System.out.print(e1);}
				
			}
		});
		//adding image to the Login button
		Image img = new ImageIcon(this.getClass().getResource("/ok5.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(439, 420, 235, 42);
		contentPane.add(btnLogin);
		
		pass = new JPasswordField();
		pass.setBounds(451, 271, 251, 41);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 7));
		Image img2 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(343, 48, 420, 414);
		contentPane.add(lblNewLabel);
	}
}
