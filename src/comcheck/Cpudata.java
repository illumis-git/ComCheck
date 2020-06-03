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

public class Cpudata {
	public void getDisk() {
		Components components = JSensors.get.components();

		List<Cpu> cpus = components.cpus;
		if (cpus != null) {
			for (final Cpu cpu : cpus) {
				System.out.println("Found CPU component: " + cpu.name);
				if (cpu.sensors != null) {
					System.out.println("Sensors: ");

					// Print temperatures
					List<Temperature> temps = cpu.sensors.temperatures;
					for (final Temperature temp : temps) {
						System.out.println(temp.name + ": " + temp.value + " C");
					}

					// Print fan speed
					List<Fan> fans = cpu.sensors.fans;
					for (final Fan fan : fans) {
						System.out.println(fan.name + ": " + fan.value + " RPM");
					}
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}