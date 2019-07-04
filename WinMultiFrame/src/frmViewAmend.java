import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmViewAmend extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtPhone;
	
	private String selectedCustomerID;
	private Customer selectedCustomer = new Customer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmViewAmend frame = new frmViewAmend();
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
	public frmViewAmend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewAmendScreen = new JLabel("View Amend Screen");
		lblViewAmendScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblViewAmendScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewAmendScreen.setBounds(193, 45, 232, 14);
		contentPane.add(lblViewAmendScreen);
		
		List infoList = new List();
		
		for (int i = 0; i < frmMain.customerList.size(); i++) {
			infoList.add(frmMain.customerList.get(i).getFullDetails());
		}
		
		infoList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//retrieves the selected record form the user
				String customerFullDetails = infoList.getSelectedItem().toString();
				System.out.println(customerFullDetails);
				selectedCustomerID = customerFullDetails.substring(0, customerFullDetails.indexOf(" "));
				System.out.println(selectedCustomerID);
				
				for (int i = 0; i < frmMain.customerList.size(); i++) {
					if (frmMain.customerList.get(i).getID().equals(selectedCustomerID)) {
						selectedCustomer = frmMain.customerList.get(i);
						
						txtName.setText(selectedCustomer.getName());
						txtAddress1.setText(selectedCustomer.getAddress1());
						txtAddress2.setText(selectedCustomer.getAddress2());
						txtPhone.setText(selectedCustomer.getPhoneNumber());
					}
				}
			}
		});
		
		
		JButton button = new JButton("<- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(519, 413, 89, 23);
		contentPane.add(button);
		
		txtName = new JTextField();
		txtName.setBounds(126, 262, 125, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddress1 = new JTextField();
		txtAddress1.setBounds(390, 262, 136, 20);
		contentPane.add(txtAddress1);
		txtAddress1.setColumns(10);
		
		txtAddress2 = new JTextField();
		txtAddress2.setBounds(126, 323, 125, 20);
		contentPane.add(txtAddress2);
		txtAddress2.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(390, 323, 136, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 265, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address 1");
		lblAddress.setBounds(275, 265, 89, 14);
		contentPane.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address 2");
		lblAddress_1.setBounds(23, 326, 79, 14);
		contentPane.add(lblAddress_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(275, 326, 89, 14);
		contentPane.add(lblPhoneNumber);
		
		infoList.setBounds(105, 79, 421, 148);
		contentPane.add(infoList);
		
		JButton btnAmend = new JButton("Amend");
		btnAmend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedCustomer.setName(txtName.getText());
				selectedCustomer.setAddress1(txtAddress1.getText());
				selectedCustomer.setAddress2(txtAddress2.getText());
				selectedCustomer.setPhoneNumber(txtPhone.getText());
				
				infoList.clear();
				
				for (int i = 0; i < frmMain.customerList.size(); i++) {
					infoList.add(frmMain.customerList.get(i).getFullDetails());
					
					txtName.setText("");
					txtAddress1.setText("");
					txtAddress2.setText("");
					txtPhone.setText("");
				}
			}
		});
		btnAmend.setBounds(251, 413, 89, 23);
		contentPane.add(btnAmend);
	}
}
