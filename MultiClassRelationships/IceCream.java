/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Summer 2022</p>
 *
 * @author Purdue CS 
 * @version June 13, 2022
 */
public class IceCream {
    private Restaurant[] restaurants;
    private boolean summer;
    private int newBusinesses;
    private int newBusinessThreshold;

    public IceCream() {
        this.restaurants = null;
        this.summer = false;
        this.newBusinesses = 0;
        this.newBusinessThreshold = 0;
    }

    public IceCream(Restaurant[] restaurants, boolean summer, int newBusinesses, int newBusinessThreshold) {
        this.restaurants = restaurants;
        this.summer = summer;
        this.newBusinesses = newBusinesses;
        this.newBusinessThreshold = newBusinessThreshold;
    }

    public int closeBusinesses() {
        if (newBusinesses > newBusinessThreshold) {
            int closedCount = 0;
            while (newBusinesses > newBusinessThreshold) {
                int lowestSalesIndex = 0;
                double lowestSales = restaurants[0].totalSales();
                for (int i = 1; i < restaurants.length; i++) {
                    double sales = restaurants[i].totalSales();
                    if (sales < lowestSales) {
                        lowestSales = sales;
                        lowestSalesIndex = i;
                    }
                }
                restaurants[lowestSalesIndex].closeRestaurant();
                closedCount++;
                newBusinesses--;
            }
            return closedCount;
        }
        return 0;
    }

    public void applySummerDiscounts() {
        if (summer) {
            for (Restaurant restaurant : restaurants) {
                double totalSales = restaurant.totalSales();
                if (totalSales <= 150) {
                    restaurant.calculateDiscounts(0.25);
                } else if (totalSales > 150 && totalSales <= 300) {
                    restaurant.calculateDiscounts(0.15);
                } else if (totalSales > 300) {
                    restaurant.calculateDiscounts(0.10);
                }
            }
        }
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isSummer() {
        return summer;
    }

    public void setSummer(boolean summer) {
        this.summer = summer;
    }

    public int getNewBusinesses() {
        return newBusinesses;
    }

    public void setNewBusinesses(int newBusinesses) {
        this.newBusinesses = newBusinesses;
    }

    public int getNewBusinessThreshold() {
        return newBusinessThreshold;
    }

    public void setNewBusinessThreshold(int newBusinessThreshold) {
        this.newBusinessThreshold = newBusinessThreshold;
    }
}
