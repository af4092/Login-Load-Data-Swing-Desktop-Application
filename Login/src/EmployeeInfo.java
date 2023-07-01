import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.swt.SWT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.JTextField;

public class EmployeeInfo extends JFrame {

	private JPanel contentPane;
	private JLabel EmployeeInfo;
	private JTable table;
	private JButton btnClear;
	private JLabel lbID;
	private JLabel lbName;
	private JLabel lbCountryCode;
	private JLabel lbDistrict;
	private JLabel lbPopulation;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfCountryCode;
	private JTextField tfDistrict;
	private JTextField tfPopulation;
	private JButton btnExit;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
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
	public EmployeeInfo() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		EmployeeInfo = new JLabel();
		EmployeeInfo.setText("Table Information:");
		EmployeeInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EmployeeInfo.setBounds(10, 10, 351, 52);
		contentPane.add(EmployeeInfo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame jFrame = new JFrame();
				jFrame.dispose();
				Login loginObj = new Login();
				loginObj.setVisible(true);
				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBounds(671, 390, 157, 38);
		contentPane.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 93, 563, 218);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoad = new JButton("Load Data");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","PASSWORD");
					Statement stmt = con.createStatement();
					String query = "select * from city";
					ResultSet rs = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i = 0; i < cols; i++)
						colName[i] = rsmd.getColumnName(i + 1);
					model.setColumnIdentifiers(colName);
					String ID, Name, CountryCode, District, Population;
					while(rs.next()) {
						ID = rs.getString(1);
						Name = rs.getString(2);
						CountryCode = rs.getString(3);
						District = rs.getString(4);
						Population = rs.getString(5);
						String[] row = {ID, Name, CountryCode, District, Population};
						model.addRow(row);
					}
					stmt.close();
					con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoad.setBounds(347, 390, 138, 38);
		contentPane.add(btnLoad);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel());
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(495, 390, 157, 38);
		contentPane.add(btnClear);
		
		lbID = new JLabel("ID");
		lbID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbID.setBounds(10, 101, 93, 31);
		contentPane.add(lbID);
		
		lbName = new JLabel("Name");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbName.setBounds(10, 130, 93, 31);
		contentPane.add(lbName);
		
		lbCountryCode = new JLabel("Country Code");
		lbCountryCode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbCountryCode.setBounds(10, 165, 104, 31);
		contentPane.add(lbCountryCode);
		
		lbDistrict = new JLabel("District");
		lbDistrict.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDistrict.setBounds(10, 198, 93, 31);
		contentPane.add(lbDistrict);
		
		lbPopulation = new JLabel("Population");
		lbPopulation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPopulation.setBounds(10, 233, 93, 31);
		contentPane.add(lbPopulation);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfID.setBounds(113, 106, 118, 25);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfName.setColumns(10);
		tfName.setBounds(113, 138, 118, 25);
		contentPane.add(tfName);
		
		tfCountryCode = new JTextField();
		tfCountryCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfCountryCode.setColumns(10);
		tfCountryCode.setBounds(113, 168, 118, 25);
		contentPane.add(tfCountryCode);
		
		tfDistrict = new JTextField();
		tfDistrict.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDistrict.setColumns(10);
		tfDistrict.setBounds(113, 201, 118, 25);
		contentPane.add(tfDistrict);
		
		tfPopulation = new JTextField();
		tfPopulation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPopulation.setColumns(10);
		tfPopulation.setBounds(113, 236, 118, 25);
		contentPane.add(tfPopulation);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","PASSWORD");
					String query = "insert into city" + "(ID, Name, CountryCode, District, Population)" + "values('','','','','')";
					PreparedStatement pst = con.prepareStatement(query);
					
					
					//Connection connection = null;
					//PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, tfID.getText());
					pst.setString(2, tfName.getText());
					pst.setString(3, tfCountryCode.getText());
					pst.setString(4, tfDistrict.getText());
					pst.setString(5, tfPopulation.getText());
					
					pst.execute(query);
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
					
					
					
				}catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(80, 274, 93, 38);
		contentPane.add(btnSave);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(176, 390, 157, 38);
		contentPane.add(btnExit);
	}
}
