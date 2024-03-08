package CS1002_W11Practical_Classes;
public class Tracker {
    /* Static fields */

    private static int serialNumberCounter = 1;

    private static int getSerialNumberCounter() {
        return serialNumberCounter;
    }

    private static void setSerialNumberCounter(int serialNumberCounter) {
        Tracker.serialNumberCounter = serialNumberCounter;
    }

    private int serialNumber;

    /* Used so that trackers can only be associated with one owner */
    final private User owner;

    private Activity[] activities = new Activity[10];

    /* It only makes sense to create an empty tracker - activities are for the user to store */
    public Tracker(User owner){
        this.setSerialNumber(serialNumberCounter);
        this.owner = owner;
        setSerialNumberCounter(getSerialNumberCounter()+1);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public User getOwner() {
        return owner;
    }

    public Activity[] getActivities() {
        return activities;
    }

    /* This method makes it impossible for the program to even attempt to store more than 10 activities in a tracker
     * as the storing index never exceeds 10
     */
    public void addActivity(Activity activity) {
        for (int i = 0; i < 10; i++){
            if (this.getActivities()[i] == null){
                this.getActivities()[i] = activity;
                break;
            }
            else if ((this.getActivities()[i] != null) &&  i == 9){
                System.out.println("Error, tracker full");
            }
        }
    }

    public String findLongestDurationActivity(){
        /* Adds all the times for the activities to an array in the order they occur */
        double[] maxArray = new double[10];
        for (int i = 0; i < 10; i++){
                if (this.getActivities()[i] != null){
                    maxArray[i] = this.getActivities()[i].calculateTime("seconds");
                }
            }
        /* Finds the index of the activity that takes the longest time */
        int maxAt = 0;
        for (int i = 0; i < 10; i++) {
                maxAt = maxArray[i] > maxArray[maxAt] ? i : maxAt;
                }
        /* Returns the name of the activity */
        return this.getActivities()[maxAt].getName();
    }

    /* Very similar method to the one above, but accessing different data */
    public String findLongestDistanceActivity(){
        double[] maxArray = new double[10];
        for (int i = 0; i < 10; i++){
            if (this.getActivities()[i] != null){
                maxArray[i] = this.getActivities()[i].getTotalDistance();
            }
        }
        int maxAt = 0;
        for (int i = 0; i < 10; i++) {
                maxAt = maxArray[i] > maxArray[maxAt] ? i : maxAt;
                }
        /* Returns the name of the activity */
        return this.getActivities()[maxAt].getName();
    }

    /* Calculates the average duration in minutes by summing
     * all the durations and dividing by the number of activities
     * of the type specified
     */
    public double findAverageDuration(Class<?> type){
        double counter = 0;
        double total = 0;
        for (int i = 0; i < 10; i++){
            if (type.isInstance(this.getActivities()[i])){
                counter += 1;
                total += this.getActivities()[i].calculateTime("minutes");
            }
        }
        return total/counter;
    }

    /* Calculates the average distance of a given type of activity
     * by adding all the distances and dividing by the amount of
     * activities of said type stored
     */
    public double findAverageDistance(Class<?> type){
        double counter = 0;
        double total = 0;
        for (int i = 0; i < 10; i++){
            if (type.isInstance(this.getActivities()[i])){
                counter += 1;
                total += this.getActivities()[i].getTotalDistance();
            }
        }
        return total/counter;
    }

    public String printTrackerDetails(){
        return("Owner " + this.getOwner().getName()+
                           "\nSerial number " + this.getSerialNumber() +
                           this.printAllDetails());

    }

    public void clearActivities() {
        for (int i = 0; i < 10; i++){
            activities[i] = null;
        }
    }

    /* The method builds up a message containing all the statistics for the activities
     * it holds and returns it to be used in a print command.
     */
    private String printAllDetails(){
        String message ="";
        for (int i = 0; i < 10; i++){
            if(this.getActivities()[i] != null){
                message += "\n" + this.getActivities()[i].printDetails();
            }
        }
        return message;
    }
}
