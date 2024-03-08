import CS1002_W11Practical_Classes.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class W11_Practical {
    // Method so I can space out the output in an easier to read way for the marker

    private static void s(){
        System.out.println();
    }
    // TESTING
    public static void main(String[] args){
        /* Creating multiple users */
        User james = new User("james",LocalDate.parse("2007-12-03"));
        User dan = new User("Dan",LocalDate.parse("2007-12-03"));
        /* Printing user details */
        System.out.println("Initial user details");
        System.out.println(james.printDetails());
        System.out.println(dan.printDetails());
        /* Printing tracker details */
        s();
        System.out.println("Tracker details for both trackers");
        System.out.println(james.getTracker().printTrackerDetails());
        System.out.println(dan.getTracker().printTrackerDetails());
        
        /* Creating activities, and further creating more than 10 activities */
        james.getTracker().addActivity(new Swim(2.0, 3, LocalDateTime.parse("2022-12-03T11:42:32"), LocalDateTime.parse("2022-12-03T13:42:32")));
        james.getTracker().addActivity(new Cycle(new double[][]{ {1,1} , {2,4} , {3,1} },LocalDateTime.parse("2022-12-04T11:42:32" ),LocalDateTime.parse("2022-12-04T12:42:32")));
        james.getTracker().addActivity(new Run(new double[][]{ {1,2} , {2,6} , {5,9} }, LocalDateTime.parse("2022-12-04T11:42:32" ), LocalDateTime.parse("2022-12-04T14:42:32")));
        james.getTracker().addActivity(new TreadmillSession(LocalDateTime.parse("2022-12-03T11:42:32" ), LocalDateTime.parse("2022-12-03T11:55:32"), 2));
        james.getTracker().addActivity(new Swim("Long Distance", 2.0, 10, LocalDateTime.parse("2022-12-04T11:42:32"), LocalDateTime.parse("2022-12-04T13:42:32")));
        james.getTracker().addActivity(new Cycle(new double[][]{ {1,2} , {2,5} , {3,7} },LocalDateTime.parse("2022-11-03T11:42:32" ),LocalDateTime.parse("2022-11-03T11:44:32")));
        james.getTracker().addActivity(new Run(new double[][]{ {1,1} , {1,2} , {1,3} }, LocalDateTime.parse("2022-12-03T11:42:32" ), LocalDateTime.parse("2022-12-03T11:43:32")));
        james.getTracker().addActivity(new TreadmillSession(LocalDateTime.parse("2022-12-03T11:42:32" ), LocalDateTime.parse("2022-12-03T12:55:32"), 6));
        james.getTracker().addActivity(new Swim("Swimming sprints",4.0, 3, LocalDateTime.parse("2022-12-04T11:42:32"), LocalDateTime.parse("2022-12-04T12:42:32")));
        james.getTracker().addActivity(new Cycle(new double[][]{ {1,1} , {2,7} , {3,1} },LocalDateTime.parse("2022-11-04T11:42:32" ),LocalDateTime.parse("2022-11-04T11:52:32")));
        /* Activities beyond 10 */
        s();
        System.out.println("Activities beyond 10");
        james.getTracker().addActivity(new Run(new double[][]{ {1,1} , {2,2} , {3,3} }, LocalDateTime.parse("2022-12-04T11:42:32" ), LocalDateTime.parse("2022-12-04T11:48:32")));
        james.getTracker().addActivity(new TreadmillSession(LocalDateTime.parse("2022-12-03T11:42:32" ), LocalDateTime.parse("2022-12-03T11:55:32"), 2));
        
        /* Testing for the display of recent activities */
        s();
        System.out.println("Displaying user details after data has been added");
        System.out.println(james.printDetails());

        /* Testing the averages */
        s();
        System.out.println("Average duration for an activity test (swim)");
        System.out.println(james.getTracker().findAverageDuration(Swim.class));
        System.out.println("Average distance for an activity test (swim)");
        System.out.println(james.getTracker().findAverageDistance(Swim.class));
        /* Testing for longest activities */
        s();
        System.out.println("Longest distance activity");
        System.out.println(james.getTracker().findLongestDistanceActivity());
        System.out.println("Longest duration activity");
        System.out.println(james.getTracker().findLongestDurationActivity());

        /* Printing tracker details after adding activities,
         * after having already calculated all of the relevant
         * statistics (this tests the majority of the implementation)
         */
        s();
        System.out.println("Tracker details");
        System.out.println(james.getTracker().printTrackerDetails());

        /* Clearing the activities in a tracker */
        james.getTracker().clearActivities();
        /* Checking its clear */
        s();
        System.out.println("Output for details after clearing activities");
        System.out.println(james.getTracker().printTrackerDetails());

        /* Malicious/mistaken user testing */
        s();
        System.out.println("Malicious/mistaken use");
        //Activity ends before it starts
        james.getTracker().addActivity(new Cycle(new double[][]{ {1,1} , {2,4} , {3,1} },LocalDateTime.parse("2023-12-04T11:42:32" ),LocalDateTime.parse("2021-12-04T12:42:32")));
        //Negative running distance
        james.getTracker().addActivity(new TreadmillSession(LocalDateTime.parse("2022-12-03T11:42:32" ), LocalDateTime.parse("2023-12-03T11:55:32"), -2));
        //Negative pool length
        james.getTracker().addActivity(new Swim("Long Distance", -2.0, 20, LocalDateTime.parse("2021-12-04T11:42:32"), LocalDateTime.parse("2022-12-04T13:42:32")));
        //Negative completed laps
        james.getTracker().addActivity(new Swim("Long Distance 2", 2.0, -20, LocalDateTime.parse("2021-12-04T11:42:32"), LocalDateTime.parse("2022-12-04T13:42:32")));
        //Test to see whether they were stored
        s();
        System.out.println("Test to see whether illegal activities stored");
        System.out.println(james.getTracker().printTrackerDetails());
        //The null pointer exception java throws shows that the illegal data has not been stored
        
        



    }
    
}
