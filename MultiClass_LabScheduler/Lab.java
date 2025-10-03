/**
 * Project 02 --TimeKeeper
 *
 * This program helps you find your CS lab
 *
 * @author Katie O'Daniel,
 *
 * @version June 15, 2023
 *
 */
public class Lab {
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }

    public Lab(int capacity, String location) {
        this.capacity = capacity;
        this.location = location;
        this.morning = new Session();
        this.afternoon = new Session();
    }

    public Session getMorning() {
        return morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setMorning(Session morning) {
        this.morning = morning;
    }

    public void  setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String listAvailabilities() {
        String results = "";
        if (morning.getEnrollment() == 0) {
            results += "Morning: Available\n";
        }
        if (afternoon.getEnrollment() == 0) {
            results += "Afternoon: Available\n";
        }
        if (results.length() == 0) {
            return "No Availabilities";
        }
        return results;
    }

    public String listReservations() {
        String results = "";
        if (morning.getEnrollment() > 0) {
            results += "Morning: Reserved\n";
        }
        if (afternoon.getEnrollment() > 0) {
            results += "Afternoon: Reserved\n";
        }
        if (results.length() == 0) {
            return  "No Reservations";
        }
        return  results;
    }
    public String toString() {
        String morningString = "Available";
        String afternoonString = "Available";

        if (morning.getEnrollment() > 0) {
            morningString = morning.toString();
        }
        if (afternoon.getEnrollment() > 0) {
            afternoonString = afternoon.toString();
        }

        return "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: " + morningString
                + ", Afternoon: " + afternoonString + "}";
    }

}
