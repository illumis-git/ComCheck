package comcheck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;

import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.SigarCommandBase;

import javax.swing.JLabel;
import comcheck.Data;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class testWindow extends SigarCommandBase{

	private JFrame frmComcheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		new Data().processCommand(args); //없으면 데이터출력안됨
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testWindow window = new testWindow();
					window.frmComcheck.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Data Cdata = new Data();
		frmComcheck = new JFrame();
		frmComcheck.setTitle("Comcheck");
		frmComcheck.setBounds(100, 100, 450, 300);
		frmComcheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComcheck.getContentPane().setLayout(new GridLayout(5, 0, 10, 10));
		
		JPanel panel = new JPanel();
		frmComcheck.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("운영체제 정보");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Cdata.getSyvendor());
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Cdata.getSyname()+" "+Cdata.getSyversion()+" "+Cdata.getSydatamodel()+" 비트 운영체제");
		panel.add(lblNewLabel_2);
		
		
		JPanel panel_1 = new JPanel();
		frmComcheck.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("CPU 정보");
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(Cdata.getIfvendor());
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(Cdata.getIfmodel() + " " + Cdata.getSyarch());
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		frmComcheck.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("RAM 정보");
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("총 : " + Cdata.getTotalmem()+" / 사용중 : " + Cdata.getUsemem() + " / 사용가능 : " + Cdata.getFreemem());
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("전체 "+Cdata.getTotalmem()+" 중 " + Cdata.getUsemem()+"("+Cdata.getPercentmem()+") 사용중이며 " + Cdata.getFreemem()+"의 여유 메모리가 있습니다.");
		panel_2.add(lblNewLabel_8);
	}

	@Override
	public void output(String[] arg0) throws SigarException {
		// TODO Auto-generated method stub
		
	}

}
