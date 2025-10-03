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
public class Rollercoaster extends Ride {
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }

    public boolean isSimulated() {
        return simulated;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rollercoaster that = (Rollercoaster) o;

        if (simulated != that.simulated) return false;
        return super.equals(o);
    }

    public String toString() {
        return super.toString() + "\nSimulated: " + simulated;
    }
}
