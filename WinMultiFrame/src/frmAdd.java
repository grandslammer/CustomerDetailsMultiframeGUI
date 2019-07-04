import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtPhone;

	public static int customerID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAdd frame = new frmAdd();
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
	public frmAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddScreen = new JLabel("Add Customer Details");
		lblAddScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddScreen.setBounds(225, 24, 187, 14);
		contentPane.add(lblAddScreen);

		JButton button = new JButton("<- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		txtPhone = new JTextField();
		txtPhone.setBounds(141, 132, 211, 20);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(24, 60, 46, 14);
		getContentPane().add(lblName);

		JLabel lblAddress = new JLabel("Address 1");
		lblAddress.setBounds(24, 85, 64, 14);
		getContentPane().add(lblAddress);

		JLabel lblAddress_1 = new JLabel("Address 2");
		lblAddress_1.setBounds(24, 110, 64, 14);
		getContentPane().add(lblAddress_1);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(24, 135, 107, 14);
		getContentPane().add(lblPhoneNumber);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtName.getText().trim().isEmpty() == false && txtAddress1.getText().trim().isEmpty() == false
						&& txtAddress2.getText().trim().isEmpty() == false
						&& txtPhone.getText().trim().isEmpty() == false) {
					customerID++;
					frmMain.customerList.add(new Customer(String.valueOf(customerID), txtName.getText(),
							txtAddress1.getText(), txtAddress2.getText(), txtPhone.getText()));

					txtName.setText("");
					txtAddress1.setText("");
					txtAddress2.setText("");
					txtPhone.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Please complete all text fields!");
				}
			}
		});
		btnAdd.setBounds(503, 131, 89, 23);
		getContentPane().add(btnAdd);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				txtAddress1.setText("");
				txtAddress2.setText("");
				txtPhone.setText("");
			}
		});
		btnClear.setBounds(503, 256, 89, 23);
		getContentPane().add(btnClear);

		button.setBounds(503, 400, 89, 23);
		contentPane.add(button);

		txtName = new JTextField();
		txtName.setBounds(141, 57, 211, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtAddress1 = new JTextField();
		txtAddress1.setBounds(141, 82, 211, 20);
		contentPane.add(txtAddress1);
		txtAddress1.setColumns(10);

		txtAddress2 = new JTextField();
		txtAddress2.setBounds(141, 107, 211, 20);
		contentPane.add(txtAddress2);
		txtAddress2.setColumns(10);
	}

}
