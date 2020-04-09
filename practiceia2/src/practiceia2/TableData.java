package practiceia2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.google.gson.Gson;



public class TableData extends DefaultTableModel {

	static final Object[] tableHeadings = new Object[] 
			{"title" , "quantity", "type", "Date of Expiry"};

	TableData() {
		super(tableHeadings,0);
	}
	public void saveData(String filename) {
		Gson gson = new Gson();
		Vector dataVector = this.getDataVector();
		String textData = gson.toJson(dataVector);
		System.out.println(textData);
		System.out.println("Data saved");

		Path path = Paths.get(filename);
		try {
			Files.writeString(path, textData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadData (String filename) {
		Path path = Paths.get(filename);
		try {
			String textData = Files.readString(path);
			System.out.println(textData);
			System.out.println("Data loaded");


			Gson gson = new Gson();
			Object[][] tableData = gson.fromJson(textData, Object[][].class);
			this.setDataVector(tableData, tableHeadings);
			System.out.println(tableData);
			this.fireTableDataChanged();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void add(String itemname, int quantity, String type, String date ) {
		addRow(new Object[] {itemname,quantity,type,date});
	}

	public void deleteSelectedRowFromJtable(int row) {
		if (row >= 0) {
			removeRow(row);
			JOptionPane.showMessageDialog(null, "Row Deleted");
		} else {
			JOptionPane.showMessageDialog(null,"Unable To Delete", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}


