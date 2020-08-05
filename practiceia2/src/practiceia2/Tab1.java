package practiceia2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;

public class Tab1 extends JPanel {
	private JTextField filterTB;

	Tab1(TableData tableData, JTabbedPane tabbedPane, DefaultTableModel model) {
		setLayout(null);

		JPanel panel = new JPanel();

		panel.setLayout(null);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 41, 734, 211);
		add(scrollPane);
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableData);

		TableRowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);


		filterTB = new JTextField();
		filterTB.setBounds(76, 10, 532, 20);
		add(filterTB);
		filterTB.setColumns(10);

		filterTB.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {	
				model.fireTableDataChanged();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				model.fireTableDataChanged();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {	
				model.fireTableDataChanged();
			}
		});

		sorter.setRowFilter(new RowFilter() {
			@Override
			public boolean include(Entry entry) {
				String name = entry.getValue(0).toString();
				String searchText = filterTB.getText();
				return name.startsWith(searchText);
			}
		});


		JButton savebutton = new JButton("Save");
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableData.saveData("C:\\Users\\maxim\\text.json");
			}


		});
		savebutton.setBounds(642, 417, 112, 23);
		add(savebutton);

		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableData.loadData("C:\\Users\\maxim\\text.json");
			}
		});
		loadButton.setBounds(642, 383, 112, 23);
		add(loadButton);
	}
}
