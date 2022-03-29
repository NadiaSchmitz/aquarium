public class Control {

	private double temperatur_normal = 21.0;
	private double temperatur;
	private double deviation = 0.05;
	private String status;
	private String command;
	
	public Control() {
		
	}
	
	public double getTemperaturNormal() {
		return temperatur_normal;
	}
	
	public void setTemperaturNormal(double temperatur_normal) {
		this.temperatur_normal = temperatur_normal;
	}
	
	public double getTemperatur() {
		return temperatur;
	}
	
	public void setTemperatur(double temperatur) {
		this.temperatur = temperatur;
	}
	
	public double getDeviation() {
		return deviation;
	}
	
	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
}
