package hotel;
//import applet.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import com.mysql.cj.xdevapi.Table;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class hoteld extends JFrame  
{
	public  static void insert(int i,String nam,String room,int day,String bookk,int amt) throws Exception
	{
		String employeename=nam;
		int id=i;
		String roomname=room;
		int am=amt;
		String name="root";
		String pass="Sanath@123";
		String query="insert into employee values (?,?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id); 
		st.setString(2, employeename);
		st.setString(3, roomname);
		st.setInt(4,day);
		st.setString(5,bookk);
		st.setInt(6, am);
		int count =st.executeUpdate();
		st.close();
		con.close();
	}
	private JTextField id;
	private JTextField employee;
	private static JTable table;
	private JTable table_1;
	private JLabel lblTotalNoOf;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextField textField_1;
	public static JComboBox room;
	private JTextField days;
	private JLabel lblDateOfBooking;
	private JTextField book;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					hoteld frame = new hoteld();
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
	public hoteld() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 526);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHotel.setBounds(414, 13, 168, 112);
		contentPane.add(lblHotel);
		
		JLabel lblEmployeename = new JLabel("Name of the resident");
		lblEmployeename.setBounds(45, 240, 142, 27);
		contentPane.add(lblEmployeename);
		
		id = new JTextField();
		id.setBounds(246, 194, 116, 22);
		contentPane.add(id);
		id.setColumns(10);
		
		employee = new JTextField();
		employee.setBounds(246, 242, 116, 22);
		contentPane.add(employee);
		employee.setColumns(10);
		
		 room = new JComboBox();
		room.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Deluxe"}));
		room.setBounds(682, 194, 106, 22);
		contentPane.add(room);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(470, 197, 106, 19);
		contentPane.add(lblRoomType);
		
		JLabel lblTotalAmt = new JLabel("Total Amt.");
		lblTotalAmt.setBounds(470, 245, 82, 16);
		contentPane.add(lblTotalAmt);
	
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(682, 242, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2 f=new frame2();
				f.setVisible(true);
				dispose();
				
			}
		});
		btnDisplay.setBounds(242, 374, 97, 25);
		contentPane.add(btnDisplay);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str_id = id.getText();
				String str_employeeString=employee.getText();
				String str_room=room.getSelectedItem().toString();
				String bookk=book.getText();
				int day=Integer.parseInt(days.getText());
				int id =Integer.parseInt(str_id);
				System.out.println(id);
				System.out.println(str_employeeString);
				 int amt=0;
				 if(str_room.equals("Single"))
				 {
					 amt=1000*day;
				 }
				 if(str_room.equals("Double"))
				 {
					 amt=5000*day;
				 }
				 if(str_room.equals("Deluxe"))
				 {
					 amt=10000*day;
				 }
				 textField_1.setText(Integer.toString(amt));
				try {
					insert(id, str_employeeString,str_room,day,bookk,amt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnEnter.setBounds(85, 374, 97, 25);
		contentPane.add(btnEnter);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(45, 197, 82, 16);
		contentPane.add(lblId);
		
		table = new JTable();
		table.setBounds(741, 325, 1, 1);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(712, 312, 1, 1);
		contentPane.add(table_1);
		
		lblTotalNoOf = new JLabel("Total No Of customers");
		lblTotalNoOf.setBounds(47, 144, 135, 16);
		contentPane.add(lblTotalNoOf);
		
		textField = new JTextField();
		textField.setEditable(false);
		
				try {
					textField.setText(Integer.toString(hotelmain.end()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		
		textField.setBounds(246, 138, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(419, 374, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNoOfDays = new JLabel("No of Days");
		lblNoOfDays.setBounds(470, 138, 112, 22);
		contentPane.add(lblNoOfDays);
		
		days = new JTextField();
		days.setBounds(682, 141, 116, 22);
		contentPane.add(days);
		days.setColumns(10);
		
		lblDateOfBooking = new JLabel("Date of Booking");
		lblDateOfBooking.setBounds(45, 312, 142, 28);
		contentPane.add(lblDateOfBooking);
		
		book = new JTextField();
		book.setBounds(246, 321, 116, 22);
		contentPane.add(book);
		book.setColumns(10);
		
		
	}
}
