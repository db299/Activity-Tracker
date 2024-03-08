package CS1002_W11Practical_Classes;
import java.time.LocalDateTime;

public class TreadmillSession extends Activity {

    public TreadmillSession(LocalDateTime startDate, LocalDateTime endDate, double totalDistance) {
        super("Treadmill Session",startDate,endDate,totalDistance);
    }
    
    public TreadmillSession(String name,LocalDateTime startDate, LocalDateTime endDate, double totalDistance) {
        super(name,startDate,endDate,totalDistance);
    }
    
    public String printDetails(){
        return super.printDetails() + "\naverage km time " + calculateAvgKmTime() + " min/km";
    }
    
    private double calculateAvgKmTime(){
        return this.calculateTime("minutes")/this.getTotalDistance();
    }

}
