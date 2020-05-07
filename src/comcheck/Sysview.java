package comcheck;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sysview extends JFrame{
	data Cdata = new data();
	private JFrame heading;
	private JLabel subheading1, subheading2, subheading3;//소제목(운영체제,CPU정보,등)
	private JLabel Sydata1, Sydata2, Sydata3;                  //운영체제
	private JLabel Ifdata1, Ifdata2, Ifdata3;
	public Sysview() {
		heading = new JFrame("Com Check");
		subheading1 = new JLabel("운영체제 정보");
		Sydata1.setText(Cdata.getSyvendor());
		Sydata2.setText(Cdata.getSyname());
		Sydata3.setText(Cdata.getSyarch());
		
		subheading2 = new JLabel("CPU 정보");
		Ifdata1.setText(Cdata.getIfvendor());
		Ifdata2.setText(Cdata.getIfmodel());
		
	}
	
}
