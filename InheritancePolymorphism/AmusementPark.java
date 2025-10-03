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
public class AmusementPark implements Park {
    private String name;
    private double admissionCost;
    private double land;
    private ArrayList<Ride> rides;
    private boolean indoor;
    private boolean outdoor;
    private boolean arcade;
    private boolean bowling;
    private boolean[] seasons;

    public AmusementPark(String name, double admissionCost, double land, ArrayList<Ride> rides,
                         boolean indoor, boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    @Override
    public double getAdmissionCost() {
        return admissionCost;
    }

    @Override
    public double getLand() {
        return land;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Ride> getRides() {
        return rides;
    }

    @Override
    public boolean[] getSeasons() {
        return seasons;
    }

    public boolean isArcade() {
        return arcade;
    }

    public boolean isBowling() {
        return bowling;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }

    public void addRide(Ride ride) throws WrongRideException {
        if (ride instanceof Rollercoaster) {
            rides.add(ride);
        } else {
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
        }
    }

    public void removeRide(Ride ride) {
        rides.remove(ride);
    }

    public void enlarge(double addedLand, double maxLand, boolean addedIndoor,
                        boolean addedOutdoor) throws SpaceFullException {
        if (land + addedLand <= maxLand) {
            land += addedLand;
            if (addedIndoor) indoor = true;
            if (addedOutdoor) outdoor = true;
        } else {
            throw new SpaceFullException("There is no more land to use for this park!");
        }
    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight,
                           int newMaxRiders, boolean newSimulated) {
        int index = rides.indexOf(ride);
        if (index >= 0) {
            Ride modifiedRide = rides.get(index);
            modifiedRide.setName(newName);
            modifiedRide.setColor(newColor);
            modifiedRide.setMinHeight(newMinHeight);
            modifiedRide.setMaxRiders(newMaxRiders);
            if (modifiedRide instanceof Rollercoaster) {
                ((Rollercoaster) modifiedRide).setSimulated(newSimulated);
            }
        }
    }

    public void close() {
        name = "";
        admissionCost = 0;
        land = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        arcade = false;
        bowling = false;
    }
}
