import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = 0;
            double temperatur_normal, temperatur_aktuell, deviation_normal, deviation_aktuell;
            DecimalFormat df = new DecimalFormat("##.##");
            
            Control control = new Control();
            public void run() {
            	temperatur_normal = control.getTemperaturNormal();
            	temperatur_aktuell = Math.random() * 10 + 17.58;
            	deviation_normal = control.getDeviation() * temperatur_normal;
            	deviation_aktuell = temperatur_aktuell - control.getTemperaturNormal();
            	
            	if (temperatur_aktuell - temperatur_normal > 0 && deviation_aktuell > deviation_normal) {
            		control.setStatus("Zu warm!");
            		control.setCommand("Heizung aus");
            	} else if (temperatur_aktuell - temperatur_normal < 0 && deviation_aktuell < -deviation_normal) {
            		control.setStatus("Zu kalt!");
            		control.setCommand("Heizung an");
            	} else {
            		control.setStatus("In Ordnung");
            	}
                System.out.printf("%-8s %-14s %-14s %-15s %-15s %-15s %-15s", 
                		countdownStarter, 
                		df.format(control.getTemperaturNormal()), 
                		df.format(deviation_normal), 
                		df.format(temperatur_aktuell),
                		df.format(deviation_aktuell),
                		control.getStatus(),
                		control.getCommand()
                		);
                System.out.println();
                countdownStarter++;

                if (countdownStarter > 20) {
                    scheduler.shutdown();
                }
            }
        };
        
        System.out.println("Status: Eingeschaltet. Soll 21.0 Gr. Überwachung läuft.");
        System.out.printf("%-8s %-14s %-14s %-14s %-15s %-15s %-15s", "Sekunde", "Temp. normal", "Abw. normal", "Temp. aktuell", "Abw. aktuell", "Status", "Anweisung");
        System.out.println();
        
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
		
		
		
		
		
		
		// Imitation der Temperatur Änderung
		
			

	}

}
