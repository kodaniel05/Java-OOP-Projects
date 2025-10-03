import java.util.ArrayList;
/**
 * HW-09 -- AmusementPark
 *
 * AmusementPark
 *
 * @author Katie O'Daniel, YourLabSectionHere
 *
 * @version June 15, 2023
 *
 */

public interface Park {
    void setName(String name);
    String getName();

    void setAdmissionCost(double admissionCost) ;
    double getAdmissionCost();

    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;
    double getLand() ;

    void addRide(Ride ride) throws WrongRideException;
    void removeRide(Ride ride);
    ArrayList<Ride> getRides();

    boolean isIndoor();
    boolean isOutdoor();

    void setSeasons(boolean[] seasons);
    boolean[] getSeasons();

    void close();
}
