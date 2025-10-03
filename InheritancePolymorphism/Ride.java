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
public class Ride {
    private String name;
    private String color;
    private int minHeight;
    private int maxRiders;

    public Ride() {
        this.name = "";
        this.color = "";
        this.minHeight = 0;
        this.maxRiders = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (minHeight != ride.minHeight) return false;
        if (maxRiders != ride.maxRiders) return false;
        if (!name.equals(ride.name)) return false;
        return color.equals(ride.color);
    }


    public String toString() {
        return "Name: " + name + "\nColor: " + color + "\nMinHeight: " + minHeight
                + " inches\nMaxRiders: " + maxRiders;
    }
}
