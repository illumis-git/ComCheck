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
	private String[] gpudata; //0.gpu사용률, 1.GPU메모리사용량, 3.알수없음 비디오엔진?브라우저 하드웨어가속 4.메모리사용중 /단위 퍼센트
	private String gputemp;

	public String getGputemp() {
		return gputemp;
	}

	public void setGputemp(String gputemp) {
		this.gputemp = gputemp;
	}

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
		gpudata = new String[5];
		
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
						setGputemp(String.valueOf(temp.value));
					}

					// Print fan speed
					List<Fan> fans = gpu.sensors.fans;
					for (final Fan fan : fans) {
						System.out.println(fan.name + ": " + fan.value + " RPM");

					}
					List<Load> loads = gpu.sensors.loads;
					int i=0;
					
					for (final Load load : loads) {
						
						System.out.println(load.name + ": " + load.value + " 이게뭐죠"+i);
						String test = new String(load.value.toString());
						
						setGpudata(i,test);
						
						i++;
						
						
					}

				}
			}
		}
	
	}
	public static void main (String[] args) {
		Gpudata gdata = new Gpudata();
		gdata.getGpu();
	}
}
