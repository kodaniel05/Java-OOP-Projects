/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Summer 2022</p>
 *
 * @author Purdue CS 
 * @version June 13, 2022
 */
public class Flavor {
    private String name;
    private double cost;

    public Flavor() {
        this.name = null;
        this.cost = 0.0;
    }

    public Flavor(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
