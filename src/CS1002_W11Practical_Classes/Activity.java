package CS1002_W11Practical_Classes;
import java.time.LocalDateTime;
import java.time.temporal.*;
import java.lang.Math;
public class Activity {
    
    protected String name;

    protected LocalDateTime startDate;

    protected LocalDateTime endDate;

    protected double totalDistance;

    protected double[][] route;
    

    // Constructors
    /* Default constructor, useful for logging activitivities without a specialised class, 
     * and that don't need many details stored, like perhaps fishing 
     */
    public Activity(String name, LocalDateTime startDate, LocalDateTime endDate){
        if (ChronoUnit.SECONDS.between(startDate, endDate) >= 0){
            this.setName(name);
            this.setStartDate(startDate);
            this.setEndDate(endDate);
        }
        else {
            System.out.println("Invalid dates entered!");
        }

        }
    
    /* Specialised constructor for activities where recording the route is crucial */
    public Activity(String name, LocalDateTime startDate, LocalDateTime endDate, double[][] route){
        this(name, startDate, endDate);
        this.setRoute(route);
    }
    /* Specialised constructor for activities where the total distance is an important and pre-determined factor */ 
    public Activity(String name, LocalDateTime startDate, LocalDateTime endDate, double totalDistance){
        this(name, startDate, endDate);
        if (totalDistance > 0){
            this.setTotalDistance(totalDistance);
        }
        else{
            System.out.println("Invalid distance entered!");
        }
    }
    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    } 
    public double[][] getRoute() {
        return route;
    }
    public void setRoute(double[][] route) {
        this.route = route;
    } 

    /* Method for printing used by the subclasses */
    public String printDetails(){
        String message = ("\n" + this.getName() +
                          "\nstart time " + this.getStartDate() +
                          "\nend time " + this.getEndDate() +
                          "\ntotal distance " + this.getTotalDistance() + " km");
        return message;


}

    protected double calculateTime(String units) {
        /* For activities where crucial statistics use seconds, minutes or hours
         * all included in this method to minimise code repetition
         */
        if (units == "seconds"){
            return ChronoUnit.SECONDS.between(this.getStartDate(), this.getEndDate());
        }
        else if (units == "minutes"){
            return ChronoUnit.MINUTES.between(this.getStartDate(), this.getEndDate());
        }
        else if (units == "hours"){
            return ChronoUnit.HOURS.between(this.getStartDate(), this.getEndDate());
        }
        else return 0;

    }

    /* calculates the distance from grid map references - made specifically for activities where the route may be clear but not the distance
     * also useful for calculating the value for the totalDistance atribute in cases where it is not pre-determined. 
     */
    protected double calculateDistanceCovered() {
        double totalDistanceCovered = 0;
        for (int i = 0; i <= (this.getRoute().length-2); i++){
                double xd = 0.3*(this.getRoute()[i][0] - this.getRoute()[i+1][0]);
                double yd = 0.3*(this.getRoute()[i][1] - this.getRoute()[i+1][1]);
                totalDistanceCovered += Math.sqrt(xd*xd + yd*yd);    
        }
        return totalDistanceCovered;
    }

    }
