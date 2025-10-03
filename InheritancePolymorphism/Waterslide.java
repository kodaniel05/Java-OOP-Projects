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
public class Waterslide extends Ride {
    private double splashDepth;

    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }

    public double getSplashDepth() {
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waterslide)) return false;
        if (!super.equals(o)) return false;
        Waterslide waterslide = (Waterslide) o;
        return waterslide.splashDepth == splashDepth;
    }


    public String toString() {
        return "Name: " + getName() + "\n" +
                "Color: " + getColor() + "\n" +
                "MinHeight: " + getMinHeight() + " inches\n" +
                "MaxRiders: " + getMaxRiders() + "\n" +
                "SplashDepth: " + splashDepth + " feet";
    }
}
