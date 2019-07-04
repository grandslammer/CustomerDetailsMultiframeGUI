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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmMain extends JFrame {

	private JPanel contentPane;
	public static ArrayList<Customer> customerList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
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
	public frmMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Customer tempCust = new Customer();
				String strArrayListContent = "";
				for (int i = 0; i < customerList.size(); i++) {
					tempCust = customerList.get(i);
					strArrayListContent = strArrayListContent + tempCust.getID() + " " + tempCust.getName() + " "
							+ tempCust.getAddress1() + " " + tempCust.getAddress2() + " " + tempCust.getPhoneNumber()
							+ "\n";
				}
				FileUtility.WriteTextToFile("Customer List", strArrayListContent);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				String strAllRecords = FileUtility.ReadAllTextInFile("Customer List"); // Read in file method
				String arrayOfIndividualCustomers[] = null;
				String IndividualCustomersFields[] = null;

				try {
					if (!strAllRecords.isEmpty()) {
						arrayOfIndividualCustomers = strAllRecords.split("\\n"); // Splits the array based on a new line to separate each customer
						for (int i = 0; i < arrayOfIndividualCustomers.length - 1; i++) {
							IndividualCustomersFields = arrayOfIndividualCustomers[i].split("*"); // Splits array based on spaces to separate each individual field (name, addresses, phone) for each customer. * is used to fix bug that occurred when using a space because it was detecting first and last names as separate fields but name is one field only in this program.
							customerList.add(new Customer(IndividualCustomersFields[0], IndividualCustomersFields[1],
									IndividualCustomersFields[2], IndividualCustomersFields[3],
									IndividualCustomersFields[4])); // Adds each field to the ArrayList
						}
						System.out.println(frmAdd.customerID = Integer.parseInt(IndividualCustomersFields[0]));
					}
				} catch (Exception en) {
				}
				FileUtility.ReadAllTextInFile("CUSTOMERLIST.txt");
			}
		});
		frmAdd.customerID = 2000;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setBounds(267, 28, 83, 14);
		contentPane.add(lblMainMenu);

		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new frmAdd().show(true);
			}
		});
		btnAddNew.setBounds(261, 127, 89, 23);
		contentPane.add(btnAddNew);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frmDelete().show(true);
			}
		});
		btnDelete.setBounds(261, 218, 89, 23);
		contentPane.add(btnDelete);

		JButton btnViewAmend = new JButton("View Amend");
		btnViewAmend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frmViewAmend().show(true);
			}
		});
		btnViewAmend.setBounds(244, 315, 131, 23);
		contentPane.add(btnViewAmend);
	}

}
