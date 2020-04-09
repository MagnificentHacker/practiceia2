package practiceia2;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tab3 extends JPanel {

	
	Tab3(JTabbedPane tabbedPane) {
		setLayout(null);

	
		
		JLabel labelabt = new JLabel("About");
		labelabt.setFont(new Font("Tahoma", Font.BOLD, 31));
		labelabt.setBounds(330, 24, 103, 46);
		add(labelabt);
		
		JLabel labelname = new JLabel("Author: Maxim Mitsenko");
		labelname.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labelname.setBounds(229, 151, 228, 24);
		add(labelname);
		
		JLabel labeldate = new JLabel("Date of Creation: 04.04.2020");
		labeldate.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labeldate.setBounds(229, 186, 286, 24);
		add(labeldate);
		
		JLabel labelversion = new JLabel("Version: 1.00");
		labelversion.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labelversion.setBounds(229, 221, 244, 24);
		add(labelversion);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnReturn.setBounds(574, 290, 89, 23);
		add(btnReturn);
		
		
	}

}
