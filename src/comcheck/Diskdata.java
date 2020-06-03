package comcheck;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Disk;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

public class Diskdata {
	private String[] diskname;
	private String[] disktemp;

	public String getDisktemp(int k) {
		return disktemp[k];
	}

	public void setDisktemp(int k, String disktemp) {
		this.disktemp[k] = disktemp;
	}

	public String getDiskname(int i) {
		return diskname[i];
	}

	public void setDiskname(int i, String diskname) {
		this.diskname[i] = diskname;
	}

	public void getDisk() {
		int i = 0;
		int k = 0;
		Components components = JSensors.get.components();

		List<Disk> disks = components.disks;
diskname = new String[disks.size()];
disktemp = new String[disks.size()];
		if (disks != null) {

			for (final Disk disk : disks) {
				// System.out.println("Found CPU component: " + disk.name);
				String disknametoString = new String(disk.name.toString());
				
				setDiskname(i, disknametoString);
				//System.out.println("테스트" + getDiskname(i) + " 숫자값" + i);
				//System.out.println("안나오는부분" + getDiskname(0) + i);
				
				
				

				i++;
				if (disk.sensors != null) {
					// System.out.println("Sensors: ");

					// Print temperatures
					List<Temperature> temps = disk.sensors.temperatures;

					for (final Temperature temp : temps) {
						// System.out.println(temp.name + ": " + temp.value + " C");
						String disktemptoString = new String(temp.value.toString());

						setDisktemp(k, disktemptoString);
						System.out.println("테스트1" + getDisktemp(k) + "숫자값 " + k);

						k++;
					}

				}
			}
		}
	}

	public static void main(String[] args) {
		Diskdata disk = new Diskdata();
		disk.getDisk();
		System.out.println(disk.getDiskname(0));
	}
}