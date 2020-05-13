package comcheck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;

import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.SigarCommandBase;

import javax.swing.JLabel;
import comcheck.data;

public class testWindow extends SigarCommandBase{

	private JFrame frmComcheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		new data().processCommand(args); //없으면 데이터출력안됨
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
		data Cdata = new data();
		frmComcheck = new JFrame();
		frmComcheck.setTitle("Comcheck");
		frmComcheck.setBounds(100, 100, 450, 300);
		frmComcheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComcheck.getContentPane().setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frmComcheck.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("운영체제 정보");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Cdata.getSyvendor());
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Cdata.getSyname()+" "+Cdata.getSyversion()+" "+Cdata.getSydatamodel()+" 비트 운영체제");
		panel.add(lblNewLabel_2);
	}

	@Override
	public void output(String[] arg0) throws SigarException {
		// TODO Auto-generated method stub
		
	}

}
