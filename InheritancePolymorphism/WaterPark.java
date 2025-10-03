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
public class WaterPark implements Park {
    private String name;
    private double admissionCost;
    private double land;
    private ArrayList<Ride> rides;
    private boolean indoor;
    private boolean outdoor;
    private boolean lazyRiver;
    private boolean wavePool;
    private boolean[] seasons;

    public WaterPark(String name, double admissionCost, double land, ArrayList<Ride> rides,
                     boolean indoor, boolean outdoor, boolean lazyRiver, boolean wavePool, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }

    public boolean isLazyRiver() {
        return lazyRiver;
    }

    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    public boolean isWavePool() {
        return wavePool;
    }

    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
    }


    public double getAdmissionCost() {
        return admissionCost;
    }

    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getLand() {
        return land;
    }

    public void addRide(Ride ride) throws WrongRideException {
        if (!(ride instanceof Waterslide)) {
            throw new WrongRideException("A waterpark can only have waterslide rides!");
        }
        rides.add(ride);
    }

    public void removeRide(Ride ride) {
        rides.remove(ride);
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public boolean isOutdoor() {
        return outdoor;
    }


    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }


    public boolean[] getSeasons() {
        return seasons;
    }


    public void enlarge(double addedLand, double maxLand, boolean addedIndoor,
                        boolean addedOutdoor) throws SpaceFullException {
        if (land + addedLand > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park!");
        }

        land += addedLand;

        if (addedIndoor) {
            indoor = true;
        }

        if (addedOutdoor) {
            outdoor = true;
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
        lazyRiver = false;
        wavePool = false;
    }

    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders, double newSplashDepth) {
        if (rides.contains(ride)) {
            ride.setName(newName);
            ride.setColor(newColor);
            ride.setMinHeight(newMinHeight);
            ride.setMaxRiders(newMaxRiders);

            if (ride instanceof Waterslide) {
                ((Waterslide) ride).setSplashDepth(newSplashDepth);
            }
        }
    }
}

