package CS1002_W11Practical_Classes;
import java.time.LocalDateTime;

public class Cycle extends Activity {

    public Cycle(double[][] route, LocalDateTime startDate, LocalDateTime endDate) {
        super("Cycle",startDate,endDate,route);
        this.setTotalDistance(this.calculateDistanceCovered());
    }
    public Cycle(double[][] route,String name, LocalDateTime startDate, LocalDateTime endDate) {
        super(name,startDate,endDate,route);
    }
    
    public String printDetails(){
        return super.printDetails() + "\nAverage speed " + this.calculateSpeed() + " km/h";
    }
    
    private double calculateSpeed(){
        // Using minutes for better accuracy
        return this.getTotalDistance()/this.calculateTime("minutes")*60;
    }
    
    

}
