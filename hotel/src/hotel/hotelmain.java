package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Node
{
	
	int id,amt;
	String name;
	String room;
	String date;
	int days;
	Node next=null;
	public Node(int id,String name,String room,int amt,int days,String date)
	{
		this.id=id;
		this.name=name;
		this.room=room;
		this.amt=amt;
		this.days=days;
		this.date=date;
	}
}

public class hotelmain {
	Node head=null;
	public Node add(int id,String name,String room,int amt,int days,String date)
	{
		Node n= new Node(id,name,room,amt,days,date);
		return n;
		
	}
	public void displayLL() throws Exception
	{
		String name="root";
		String pass="Sanath@123";
		String query="select * from employee";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		//insert();
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(query);
		Node p=head;
		while(rs.next())
		{
			if(head==null)
				head=add(Integer.parseInt(rs.getString("id")),rs.getString("employeename"),rs.getString("Room Type"),Integer.parseInt(rs.getString("Amount to be paid")),Integer.parseInt(rs.getString("Noofdays")),rs.getString("date"));
			else
			{
				p=head;
				while(p.next!=null)
					p=p.next;
				p.next=add(Integer.parseInt(rs.getString("id")),rs.getString("employeename"),rs.getString("Room Type"),Integer.parseInt(rs.getString("Amount to be paid")),Integer.parseInt(rs.getString("Noofdays")),rs.getString("date"));
			}
		}
		//System.out.println("STOP");
		p=head;
		while(p!=null)
		{
			
			System.out.println(p.id+" "+p.name+" "+p.room+" "+p.amt);
			p=p.next;
		}

	}
	
	public static void sortAccRoom(Node head)
	{
		
	}
	
	public static int end ()throws Exception
	{
		int i=0;
		String name="root";
		String pass="Sanath@123";
		String query="select * from employee";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///sample",name,pass);
		//insert();
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(query);
		while(rs.next())
		i++;
		st.close();
		
		con.close();
		return i;
	}
	public static void main(String[] args) throws Exception
	{
		hotelmain m = new hotelmain();
		m.displayLL();
		
	} 

	
}
