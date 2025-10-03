public class Main {
    public static void main(String[] args) {
        Flavor chocolate = new Flavor("Chocolate", 2.5);
        Flavor vanilla = new Flavor("Vanilla", 2.0);
        Flavor strawberry = new Flavor("Strawberry", 2.2);

        Flavor[] flavors = {chocolate, vanilla, strawberry};
        int[][] cupsSold = {{50, 60, 70, 80, 90, 100, 110}, {40, 50, 60, 70, 80, 90, 100}, {30, 40, 50, 60, 70, 80, 90}};

        Restaurant restaurant1 = new Restaurant("IceCream Palace", flavors, cupsSold, 10, true);
        Restaurant restaurant2 = new Restaurant("Sweet Treats", flavors, cupsSold, 12, false);

        Restaurant[] restaurants = {restaurant1, restaurant2};

        IceCream iceCreamChain = new IceCream(restaurants, true, 5, 3);


        System.out.println("Total Sales for Sweet Treats: $" + restaurant2.totalSales());

        iceCreamChain.applySummerDiscounts();

        System.out.println("After applying summer discounts:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName() + " - Total Sales: $" + restaurant.totalSales());
        }

        int closedRestaurants = iceCreamChain.closeBusinesses();
        System.out.println("Closed " + closedRestaurants + " restaurants due to excessive new businesses.");

        System.out.println("Final restaurant list:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName());
        }
    }
}
