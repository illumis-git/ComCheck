package comcheck;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;

public class Sysview extends JFrame{
	data Cdata = new data();
	public Sysview() {
		setTitle("Com check");
		getContentPane().setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("운영체제 정보");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Cdata.getSyvendor());
		
		panel.add(lblNewLabel_1);
		/*
		subheading1 = new JLabel("운영체제 정보");
		Sydata1.setText(Cdata.getSyvendor());
		Sydata2.setText(Cdata.getSyname());
		Sydata3.setText(Cdata.getSyarch());
		
		subheading2 = new JLabel("CPU 정보");
		Ifdata1.setText(Cdata.getIfvendor());
		Ifdata2.setText(Cdata.getIfmodel());
		*/
	}
	
}
