import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.List;

public class frmDelete extends JFrame {

	private JPanel contentPane;
	private String selectedCustomerID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDelete frame = new frmDelete();
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
	public frmDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		List infoList = new List();
		infoList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectedRecord = "";
				selectedRecord = infoList.getSelectedItem().toString();
				selectedCustomerID = selectedRecord.substring(0, selectedRecord.indexOf(" "));
				System.out.println(selectedCustomerID);
			}
		});

		for (int i = 0; i < frmMain.customerList.size(); i++) {
			infoList.add(frmMain.customerList.get(i).getFullDetails());
		}

		JLabel lblDeleteScreen = new JLabel("Delete Screen");
		lblDeleteScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeleteScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteScreen.setBounds(230, 42, 131, 14);
		contentPane.add(lblDeleteScreen);

		JButton button = new JButton("<- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(520, 413, 89, 23);
		contentPane.add(button);

		JButton btnDeleteEntry = new JButton("Delete Entry");
		btnDeleteEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Searching for the selected customer in the arraylist and then removing them
				for (int i = 0; i < frmMain.customerList.size(); i++) {
					if (frmMain.customerList.get(i).getID().equals(selectedCustomerID)) {
						frmMain.customerList.remove(i);
					}
				}
				// re-populating the listbox on the screen
				infoList.clear();
				for (int i = 0; i < frmMain.customerList.size(); i++) {
					infoList.add(frmMain.customerList.get(i).getFullDetails());
				}
			}
		});
		btnDeleteEntry.setBounds(230, 331, 131, 23);
		contentPane.add(btnDeleteEntry);

		infoList.setBounds(10, 76, 572, 234);
		contentPane.add(infoList);
	}
}
