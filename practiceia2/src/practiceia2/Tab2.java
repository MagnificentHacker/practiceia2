package practiceia2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class Tab2 extends JPanel {
	private JTextField itemnameTB;
	private JButton addButton;
	private JTextField dateTB;

	
	public Tab2(TableData tableData, JTabbedPane tabbedPane) {
		setLayout(null);
		
		itemnameTB = new JTextField();
		itemnameTB.setBounds(70, 194, 96, 20);
		add(itemnameTB);
		itemnameTB.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name of the item");
		nameLabel.setBounds(60, 163, 126, 20);
		add(nameLabel);
		
		JSpinner quantityS = new JSpinner();
		quantityS.setBounds(228, 194, 96, 20);
		add(quantityS);
		
		JLabel quantityLabel = new JLabel("Quantity/ml");
		quantityLabel.setBounds(228, 163, 96, 20);
		add(quantityLabel);

		JLabel priorityLabel = new JLabel("Type");
		priorityLabel.setBounds(388, 163, 96, 20);
		add(priorityLabel);

		JLabel dateLabel = new JLabel("Date Of Expiry");
		dateLabel.setBounds(545, 163, 96, 20);
		add(dateLabel);
		
		dateTB = new JTextField();
		dateTB.setColumns(10);
		dateTB.setBounds(545, 194, 96, 20);
		add(dateTB);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Itemtype.values()));
		comboBox.setBounds(377, 194, 112, 20);
		add(comboBox);
		
		
		addButton = new JButton("Add item");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantity = (Integer)quantityS.getValue();
				Object type = comboBox.getSelectedItem();
				tableData.add(itemnameTB.getText(),quantity,type.toString(),dateTB.getText());
				tabbedPane.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Row Added");
			}
		});
		addButton.setBounds(268, 371, 156, 23);
		add(addButton);
	}
}
