package CS1002_W11Practical_Classes;
import java.time.LocalDateTime;

public class Swim extends Activity {

    private double poolLength;

    private int completedLaps;

    public Swim(double poolLength, int completedLaps, LocalDateTime startDate, LocalDateTime endDate) {
        super("Swim", startDate, endDate);
        this.setPoolLength(poolLength);
        this.setCompletedLaps(completedLaps);
        /* Dividing by 1000 to standardize it to km */
        this.setTotalDistance(completedLaps * poolLength / 1000);
    }
    public Swim(String name,double poolLength, int completedLaps, LocalDateTime startDate, LocalDateTime endDate) {
        super(name, startDate, endDate);
        if (poolLength > 0 && completedLaps > 0){
            this.setPoolLength(poolLength);
            this.setCompletedLaps(completedLaps);
            this.setTotalDistance(completedLaps * poolLength / 1000);
        }
        else {
            System.out.println("Invalid data entered!");
        }
       
    }

    public double getPoolLength() {
        return poolLength;
    }

    public void setPoolLength(double poolLength) {
        this.poolLength = poolLength;
    }

    public int getCompletedLaps() {
        return completedLaps;
    }

    public void setCompletedLaps(int completedLaps) {
        this.completedLaps = completedLaps;
    }
   
    public String printDetails(){
        return super.printDetails() + "\npool length " + this.getPoolLength() +
                                      "\ncompleted laps " + this.getCompletedLaps() +
                                      "\nminutes per length " + this.calculateMinutesPerLength();
    }
    
    private double calculateMinutesPerLength(){
        return this.calculateTime("minutes")/this.getCompletedLaps();
    }

}
