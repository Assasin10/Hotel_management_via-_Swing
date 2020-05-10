package hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					frame2 frame = new frame2();
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
	public frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		//passwordField.addActionListener(new ActionListener() {
			
			
			
		//});
		passwordField.setBounds(245, 165, 152, 33);
		contentPane.add(passwordField);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(51, 165, 131, 33);
		contentPane.add(lblEnterPassword);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char pass[]=passwordField.getPassword();
				String p=new String(pass);
				/*if(p.equals("sanath"))
				{
					JOptionPane.showMessageDialog(null, "correct");
				}*/
			if(p.equals("Sanath"))
				{
				JOptionPane.showMessageDialog(null, "correct password");
				
				try {
					frame3 h=new frame3();
					h.setVisible(true );
					dispose();
				//	dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else
				JOptionPane.showMessageDialog(null, "Wrong password");
			}
		});
		btnOk.setBounds(148, 283, 97, 25);
		contentPane.add(btnOk);
	}
}
