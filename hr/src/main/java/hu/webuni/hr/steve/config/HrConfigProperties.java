package hu.webuni.hr.steve.config;

import java.util.TreeMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigProperties {

	private Salary salary = new Salary();
	
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public static class Salary {
		private Default def = new Default();
		private Smart smart = new Smart();

		public Default getDef() {
			return def;
		}
		public void setDef(Default def) {
			this.def = def;
		}
		public Smart getSmart() {
			return smart;
		}
		public void setSmart(Smart smart) {
			this.smart = smart;
		}
	}
	
	public static class Default {		
		private int percent;

		public int getPercent() {
			return percent;
		}

		public void setPercent(int percent) {
			this.percent = percent;
		}

	}
	
	public static class Smart {
		private TreeMap<Double, Integer> limits;

		public TreeMap<Double, Integer> getLimits() {
			return limits;
		}

		public void setLimits(TreeMap<Double, Integer> limits) {
			this.limits = limits;
		}

	}
	
}
