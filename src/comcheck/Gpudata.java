package comcheck;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

public class Gpudata {
	private String[] gpuname;
	private String gpucoretemp;
	DefaultTableModel model = new DefaultTableModel(new Object[] { "Value" }, 0);
	private String[] gpudata; //0.gpu사용률, 1.GPU메모리사용량 GB 나온값/10, 3.알수없음 비디오엔진? 4.메모리사용률%

	public String getGpudata(int i) {
		return gpudata[i];
	}

	public void setGpudata(int i, String gpudata) {
		this.gpudata[i] = gpudata;
	}

	public String getGpucoretemp() {
		return gpucoretemp;
	}

	public void setGpucoretemp(String gpucoretemp) {
		this.gpucoretemp = gpucoretemp;
	}

	public String getGpuname(int i) {
		return gpuname[i];
	}

	public void setGpuname(String gpuname) {
		this.gpuname = gpuname.split(" ");

	}

	public void getGpu() {
		Components components = JSensors.get.components();

		List<Gpu> gpus = components.gpus;
		if (gpus != null) {
			for (final Gpu gpu : gpus) {
				setGpuname(gpu.name);

				if (gpu.sensors != null) {
					System.out.println("Sensors: ");

					// Print temperatures
					List<Temperature> temps = gpu.sensors.temperatures;
					for (final Temperature temp : temps) {
						setGpucoretemp(String.valueOf(temp.value));
						System.out.println(temp.name + ": " + temp.value + " C");
					}

					// Print fan speed
					List<Fan> fans = gpu.sensors.fans;
					for (final Fan fan : fans) {
						System.out.println(fan.name + ": " + fan.value + " RPM");

					}
					List<Load> loads = gpu.sensors.loads;int i=0;
					for (final Load load : loads) {
						this.gpudata = new String[loads.size()];
						
						setGpudata(i,String.valueOf(load.value));
						System.out.println(load.name + ": " + getGpudata(i) + " 이게뭐죠"+i);
						i++;
						model.addRow(new String[] { load.value });
						
					}

				}
			}
		}
	}
}
