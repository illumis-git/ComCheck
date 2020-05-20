package comcheck;

import org.hyperic.sigar.CpuPerc;

import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.SigarCommandBase;
import org.hyperic.sigar.cmd.Version;
import org.hyperic.sigar.Mem;
import java.io.PrintStream;
import java.text.DecimalFormat;

public class Data extends SigarCommandBase {
	private static String Syvendor; // OS제조사
	private static String Syname; // OS이름
	private static String Syversion;// OS버전
	private static String Syarch; // OS아키텍처 x32 x64
	private static String Sydatamodel;// OS데이터모델 32 64
	private static String Ifvendor; // cpu제조사
	private static String Ifmodel; // cpu제품명+동작속도
	private static String Totalmem; //총메모리
	private static String Freemem; //남은메모리
	private static String Usemem;  //사용중메모리
	private static String Percentmem; //전체 : 사용중 비율

	String strformat = "####.##";  //텍스트기본형(메모리)
	DecimalFormat df = new DecimalFormat(strformat);
	public void output(String[] args) throws SigarException {
		Mem mem = sigar.getMem();
		OperatingSystem sys = OperatingSystem.getInstance();
		// cpu제조사 모델명
		org.hyperic.sigar.CpuInfo[] infos = this.sigar.getCpuInfoList();

		// CpuPerc[] cpus =
		this.sigar.getCpuPercList();

		org.hyperic.sigar.CpuInfo info = infos[0];
		setSyvendor(sys.getVendor()); // OS제조사
		setSyname(sys.getName()); // OS이름
		setSyversion(sys.getVersion()); // OS버전 ex)windows 10
		setSydatamodel(sys.getDataModel()); // OS데이터모델 32 64
		setSyarch(sys.getArch()); // x32 x64
		setIfvendor(info.getVendor()); // 제조사
		setIfmodel(info.getModel()); // 제품명+동작속도
		setTotalmem(String.valueOf(df.format((double)mem.getTotal()/1000000000)));
		setFreemem(String.valueOf(df.format((double)mem.getFree()/1000000000)));
		setUsemem(String.valueOf(df.format((double)mem.getUsed()/1000000000)));
		setPercentmem(String.valueOf(Math.round(((double)mem.getUsed()*100)/(double)mem.getTotal())));
		System.out.println(getPercentmem());
	}

	public String getSyversion() {
		return Syversion;
	}

	public String getSydatamodel() {
		return Sydatamodel;
	}

	public void setSydatamodel(String sydatamodel) {
		Sydatamodel = sydatamodel;
	}

	public void setSyversion(String syversion) {
		Syversion = syversion.substring(0, 2);
	}

	public String getSyvendor() {
		return Syvendor;
	}

	public void setSyvendor(String syvendor) {
		if (syvendor.equals("Microsoft")) {
			Syvendor = "마이크로소프트";
		} else {
			Syvendor = syvendor;
		}
	}

	public String getSyname() {
		return Syname;
	}

	public void setSyname(String syname) {// OS종류판별
		if (syname.substring(0, 3).equals("Win")) {
			Syname = "윈도우";
		} else {
			Syname = syname;

		}
	}

	public String getSyarch() {
		return Syarch;
	}

	public void setSyarch(String syarch) {
		Syarch = syarch + "비트 프로세서";
	}

	// 여기까지 OS부분
	public String getIfvendor() {
		return Ifvendor;
	}

	public void setIfvendor(String ifvendor) {
		if (ifvendor.equals("Intel")) {
			Ifvendor = "인텔";
		} else {
			Ifvendor = ifvendor;
		}
	}

	public String getIfmodel() {
		return Ifmodel;
	}

	public void setIfmodel(String ifmodel) {
		Ifmodel = ifmodel.trim();
	}
	// 여기까지 CPU부분
	public static String getTotalmem() {
		return Totalmem;
	}

	public static void setTotalmem(String totalmem) {
		Totalmem = totalmem + " GB";
	}
	public static String getFreemem() {
		return Freemem;
	}

	public static void setFreemem(String freemem) {
		Freemem = freemem + " GB";
	}

	public static String getUsemem() {
		return Usemem;
	}

	public static void setUsemem(String usemem) {
		Usemem = usemem + " GB";
	}
	public static String getPercentmem() {
		return Percentmem;
	}

	public static void setPercentmem(String percentmem) {
		Percentmem = percentmem + "%";
	}
	//여기까지 메모리부분
}
