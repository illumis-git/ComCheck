package comcheck;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.SigarCommandBase;
import org.hyperic.sigar.cmd.Version;
import java.io.PrintStream;

public class data extends SigarCommandBase {
	private static String Syvendor; // OS제조사
	private static String Syname; // OS이름
	private static String Syversion;// OS버전
	private static String Syarch; // OS아키텍처 x32 x64
	private static String Sydatamodel;// OS데이터모델 32 64
	private static String Ifvendor; // cpu제조사
	private static String Ifmodel; // cpu제품명+동작속도
	private static String Frmem; // 메모리

	public void output(String[] args) throws SigarException {

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
		Syversion = syversion.substring(0,2);
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
		if (syname.substring(0,3).equals("Win")) {
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
		Ifvendor = ifvendor;
	}

	public String getIfmodel() {
		return Ifmodel;
	}

	public void setIfmodel(String ifmodel) {
		Ifmodel = ifmodel.trim();
	}
	// 여기까지 CPU부분

}
