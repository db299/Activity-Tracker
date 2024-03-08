package CS1002_W11Practical_Classes;
import java.time.LocalDateTime;

public class Run extends Activity {

    public Run(double[][] route, LocalDateTime startDate, LocalDateTime endDate) {
        super("Run",startDate,endDate,route);
        this.setTotalDistance(this.calculateDistanceCovered());      
    }
    public Run(double[][] route,String name, LocalDateTime startDate, LocalDateTime endDate) {
        super(name,startDate,endDate,route);
    }
    
    public String printDetails(){
        return super.printDetails() + "\naverage km time " + this.calculateKmAverage() + " min/km";
    }
    
    private double calculateKmAverage(){
        return this.calculateTime("minutes")/this.getTotalDistance();
    }

}
