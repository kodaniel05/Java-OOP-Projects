/**
 * Challenge-06 -- Tea
 *
 * This program takes Tea
 *
 * @author Katie O'Daniel, YourLabSectionHere
 *
 * @version June 15, 2023
 *
 */
pu
public class Tea {
    private String name;
    private double price;
    private int stockAvailable;
    private String type;
    private int caffeineLevel;
    private int steepTemperature;
    private double steepTime;

    public Tea(String name, double price, String type, int stockAvailable) {
        this.name = name;
        this.price = price;
        this.stockAvailable = stockAvailable;
        this.type = type;

        switch (type) {
            case "Black":
                caffeineLevel = 5;
                steepTemperature = 212;
                steepTime = 4.5;
                break;
            case "Oolong":
                caffeineLevel = 4;
                steepTemperature = 200;
                steepTime = 2.0;
                break;
            case "Green":
                caffeineLevel = 3;
                steepTemperature = 185;
                steepTime = 2.5;
                break;
            case "White":
                caffeineLevel = 2;
                steepTemperature = 160;
                steepTime = 1.5;
                break;
            case "Herbal":
                caffeineLevel = 1;
                steepTemperature = 212;
                steepTime = 5.0;
                break;
            default:
                System.out.println("This is not a type of tea sold here");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public int getCaffeineLevel() {
        return caffeineLevel;
    }

    public double getSteepTime() {
        return steepTime;
    }

    public int getSteepTemperature() {
        return steepTemperature;
    }

    public void restock(int quantity) {
        if (quantity >= 0) {
            stockAvailable += quantity;
        } else {
            System.out.println("Error, invalid order");
        }
    }

    public double purchaseTea(int quantity) {
        if (quantity >= 0) {
            int availibility = 0;

            if (quantity > stockAvailable) {
                availibility = stockAvailable;
            } else {
                availibility = quantity;
            }

            double totalPrice = availibility * price;
            stockAvailable -= availibility;
            return totalPrice;
        } else {
            System.out.println("Error, invalid order");
            return 0.0;
        }
    }

    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            price = newPrice;
        } else {
            System.out.println("Error, invalid price");
        }
    }

    public String toString() {
        return "Tea Name : " + name + '\n' +
                "Type: " + type + '\n' +
                "Stock Available: " + stockAvailable + '\n' +
                "Price: $" + price + '\n' +
                "Steep Time: " + steepTime + '\n' +
                "Steep Temperature: " + steepTemperature + '\n' +
                "Caffeine Level: " + caffeineLevel;
    }
}
