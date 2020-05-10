package hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class frame3 extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField delete;

	/**
	 * Launch the application.
	 */
	public static void delete(int ide)throws Exception
	
	{
		String name="root";
		String pass="Sanath@123";
		String query="delete from sample.employee where id=\""+ide+"\"" ;
		String query1="select * from sample.employee";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		PreparedStatement st = con.prepareStatement(query);
		
		st.executeUpdate(query);
		
		//PreparedStatement st1 = con.prepareStatement(query);
		ResultSet rs =st.executeQuery(query1);
		display(rs);
		st.close();
		con.close();
	}
	public static void sortName()throws Exception
	{
		String name="root";
		String pass="Sanath@123";
		String query="SELECT* FROM sample.employee order by employeename";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		PreparedStatement st = con.prepareStatement(query);
		
		ResultSet rs =st.executeQuery(query);
		display(rs);
		st.close();
		con.close();
		
	}
	public static void sortdays()throws Exception
	{
		String name="root";
		String pass="Sanath@123";
		String query="SELECT* FROM sample.employee order by Noofdays";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		PreparedStatement st = con.prepareStatement(query);
		
		ResultSet rs =st.executeQuery(query);
		display(rs);
		st.close();
		con.close();
		
	}
	public static void display(ResultSet rs) throws Exception
	{
		String name="root";
		String pass="Sanath@123";
		//String query="insert into employee values (?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		String query="select* from employee";
		PreparedStatement st = con.prepareStatement(query);
		// rs = st.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 frame = new frame3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public frame3() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFollowingAreThe = new JLabel("Following are the residents");
		lblFollowingAreThe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblFollowingAreThe.setBounds(239, 71, 285, 52);
		contentPane.add(lblFollowingAreThe);
		
		table = new JTable();
		table.setBounds(173, 165, 501, 272);
		contentPane.add(table);
		
		JButton name = new JButton("Sort According By Name");
		name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sortName();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		name.setBounds(59, 127, 182, 25);
		contentPane.add(name);
		
		JButton btnSortAccordingBy_1 = new JButton("Sort According By No.of Days");
		btnSortAccordingBy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sortdays();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSortAccordingBy_1.setBounds(462, 127, 244, 25);
		contentPane.add(btnSortAccordingBy_1);
		
		delete = new JTextField();
		delete.setBounds(45, 255, 116, 22);
		contentPane.add(delete);
		delete.setColumns(10);
		
		JButton del = new JButton("Delete");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ide = Integer.parseInt(delete.getText());
				try {
					delete(ide);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		del.setBounds(43, 309, 97, 25);
		contentPane.add(del);
		
	}
}
