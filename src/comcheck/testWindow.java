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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

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
		Gpudata gpudata = new Gpudata();
		gpudata.getGpu();
		Diskdata diskdata = new Diskdata();
		diskdata.getDisk();
		
		frmComcheck = new JFrame();
		frmComcheck.setTitle("Comcheck");
		frmComcheck.setBounds(100, 100, 500, 450);//실행시 GUI실행위치가 100, 100에서부터 500x450 사이즈로 실행됨
		frmComcheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComcheck.getContentPane().setLayout(new GridLayout(1, 0, 10, 10));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmComcheck.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("운영체제", null, panel, null);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("운영체제 정보");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제조사 : " + Cdata.getSyvendor());
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("제품명 : " + Cdata.getSyname()+" "+Cdata.getSyversion());
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_14 = new JLabel("OS 종류 : " + Cdata.getSydatamodel()+" 비트 운영체제");
		lblNewLabel_14.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_14);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("CPU", null, panel_1, null);
		panel_1.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("CPU 정보");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("제조사 : " + Cdata.getIfvendor());
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("제품명 : " + Cdata.getIfmodel(0) + " " + Cdata.getSyarch());
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_15 = new JLabel("동작속도 : " + Cdata.getIfmodel(1));
		lblNewLabel_15.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblNewLabel_15);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("RAM", null, panel_2, null);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("RAM 정보");
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblNewLabel_6);
		

		JLabel lblNewLabel_7 = new JLabel("총 : " + Cdata.getTotalmem()+" / 사용중 : " + Cdata.getUsemem() + " / 사용가능 : " + Cdata.getFreemem());
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("전체 "+Cdata.getTotalmem()+" 중 " + Cdata.getUsemem()+"("+Cdata.getPercentmem()+") 사용중이며 " + Cdata.getFreemem()+"의 여유 메모리가 있습니다.");
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblNewLabel_8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("GPU", null, panel_3, null);
		panel_3.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("GPU 정보");
		lblNewLabel_9.setVerticalAlignment(SwingConstants.TOP);
		panel_3.add(lblNewLabel_9);
		
		
		JLabel lblNewLabel_10 = new JLabel("제조사: " + gpudata.getGpuname(0));
		lblNewLabel_10.setVerticalAlignment(SwingConstants.TOP);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("제품명 : " + gpudata.getGpuname(1)+" "+gpudata.getGpuname(2)+" "+gpudata.getGpuname(3));
		lblNewLabel_12.setVerticalAlignment(SwingConstants.TOP);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("현재 온도(C) : " + gpudata.getGputemp());
		lblNewLabel_13.setVerticalAlignment(SwingConstants.TOP);
		panel_3.add(lblNewLabel_13);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("저장매체", null, panel_4, null);
		panel_4.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("Disk 정보");
		lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_16 = new JLabel("제품명 : " + diskdata.getDiskname(0));
		panel_4.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("현재 온도 (C) : " + diskdata.getDisktemp(0));
		panel_4.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("제품명 : " + diskdata.getDiskname(1));
		panel_4.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("현재 온도 (C) : " + diskdata.getDisktemp(1));
		panel_4.add(lblNewLabel_19);
		//주기적으로 데이터 갱신
	}

	@Override
	public void output(String[] arg0) throws SigarException {
		// TODO Auto-generated method stub
		
	}

}
