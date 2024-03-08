package CS1002_W11Practical_Classes;
import java.time.LocalDate;
import java.time.temporal.*;


 public class User {

    private String name;

    private LocalDate dateOfBirth;

    /* One user -> one tracker */
    final private Tracker tracker;

    public User(String name, LocalDate dateOfBirth){
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.tracker = new Tracker(this);
     
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Tracker getTracker() {
        return tracker;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String printDetails() {
        return("name: "+ this.getName()+
                           "\nage: " + this.calculateAge() +
                           "\nrecent activities: " + this.printLastThree());
    }

    String getName() {
        return this.name;
    }

    int calculateAge() {
        
        int age = (int)(ChronoUnit.YEARS.between(this.getDateOfBirth(), LocalDate.now()));
        return age;
    }
    /* Prints the last 3 values by finding the first non empty entry in the activities array */
    private String printLastThree(){
        for (int i = 0 ; i < 10; i++){
            if(this.getTracker().getActivities()[i] == null){
                if (i >= 3){
                    String message = this.getTracker().getActivities()[i-1].getName()+ ", " + this.getTracker().getActivities()[i-2].getName() + " and " + this.getTracker().getActivities()[i-3].getName();
                    return message;
                }
                else if (i == 2){
                    String message = this.getTracker().getActivities()[i-1].getName() + " and " + this.getTracker().getActivities()[i-2].getName();
                    return message;
                    
                }
                else if (i == 1){
                    String message = this.getTracker().getActivities()[i-1].getName();
                    return message;
                }
                else{
                    String message = "No activities logged";
                    return message;
                    
                }
            }
            else if (i == 9){
                String message = this.getTracker().getActivities()[i].getName()+ ", " + this.getTracker().getActivities()[i-1].getName() + " and " + this.getTracker().getActivities()[i-2].getName();
                return message;

            }
        }
        return "";

    }

}
