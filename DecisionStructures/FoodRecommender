import java.util.Scanner;

/**
 * Challenge-03 --FoodRecommender
 *
 * This program takes in input from user and returns a VIN
 *
 * @author Katie O'Daniel, DEMOOOOOO PLEASE DO NOT LIKE EDIT
 *
 * @version June 15, 2023
 *
 */
public class FoodRecommender {
    public static final String WELCOME_MESSAGE = "Welcome to the Food Recommender!";
    public static final String INITIAL_FOOD = "Do you want to have good food?";
    public static final String SPICY = "Do you like spicy food?";
    public static final String CHINESE = "Do you want to try spicy Chinese Food?";
    public static final String INDIAN = "Do you want to try spicy Indian Food?";
    public static final String ETHIOPIAN = "Do you want to try spicy Ethiopian food?";
    public static final String SEA_FOOD = "Do you like sea food?";
    public static final String SUSHI = "Do you like traditional sushi?";
    public static final String BEEF = "Do you like beef?";
    public static final String PORK = "Do you like pork?";
    public static final String LAMB = "Do you like lamb?";
    public static final String SOUP = "Do you want soup with beef?";
    public static final String GOODBYE_MESSAGE = "Thank you for using" +
            " the Food Recommender!";
    public static final String HOT_POT = "Sichuan hot pot is a great choice!";
    public static final String VINDALOO = "Vindaloo is a great choice!";
    public static final String DORO_WAT = "Doro wat is very good!";
    public static final String PENNE = "Penne all’arrabbiata is delicious!";
    public static final String SALMON_SUSHI = "Salmon sushi will fulfill you!";
    public static final String BBQ_SUSHI = "BBQ bacon sushi is a great combination of sushi and meat!";
    public static final String FRUIT_SALAD = "Sweet fruit salad is a great choice!";
    public static final String PORK_QUESADILLAS = "Pork quesadillas are very tasty!";
    public static final String LAMB_CHOPS = "Rosemary roast lamb chops are a great choice!";
    public static final String BIBIMBAP = "Beef and veggie bibimbap will fulfill you!";
    public static final String PHO_SOUP = "Vietnamese beef and noodle pho soup is very good!";
    // ------------------------- DO NOT MODIFY ABOVE -------------------------
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);

        System.out.println(INITIAL_FOOD);
        String foodRecommender = scanner.nextLine().toLowerCase();

        if (foodRecommender.equals("yes")) {
            System.out.println(SPICY);
            String spicyFood = scanner.nextLine().toLowerCase();
            if (spicyFood.equals("yes")) {
                System.out.println(CHINESE);
                String chineseFood = scanner.nextLine().toLowerCase();
                if (chineseFood.equals("yes")) {
                    System.out.println(HOT_POT);
                } else if (chineseFood.equals("no")) {
                    System.out.println(INDIAN);
                    String indianFood = scanner.nextLine().toLowerCase();
                    if (indianFood.equals("yes")) {
                        System.out.println(VINDALOO);
                    } else if (indianFood.equals("no")) {
                        System.out.println(ETHIOPIAN);
                        String ethiopianFood = scanner.nextLine().toLowerCase();
                        if (ethiopianFood.equals("yes")) {
                            System.out.println(DORO_WAT);
                        } else if (ethiopianFood.equals("no")) {
                            System.out.println(PENNE);
                        }
                    }
                }
            } else {
                if (spicyFood.equals("no")) {
                    System.out.println(SEA_FOOD);
                    String seaFood = scanner.nextLine().toLowerCase();
                    if (seaFood.equals("no")) {
                        System.out.println(BEEF);
                        String beef = scanner.nextLine().toLowerCase();
                        if (beef.equals("no")) {
                            System.out.println(PORK);
                            String pork = scanner.nextLine().toLowerCase();
                            if (pork.equals("yes")) {
                                System.out.println(PORK_QUESADILLAS);
                            } else if (pork.equals("no")) {
                                System.out.println(LAMB);
                                String lamb = scanner.nextLine().toLowerCase();
                                if (lamb.equals("yes")) {
                                    System.out.println(LAMB_CHOPS);
                                }
                                if (lamb.equals("no")) {
                                    System.out.println(FRUIT_SALAD);
                                }
                            }
                        } else if (beef.equals("yes")) {
                            System.out.println(SOUP);
                            String beefSoup = scanner.nextLine().toLowerCase();
                            if (beefSoup.equals("yes")) {
                                System.out.println(PHO_SOUP);
                            } else if (beefSoup.equals("no"))
                                System.out.println(BIBIMBAP);
                        }
                    } else if (seaFood.equals("yes")) {
                        System.out.println(SUSHI);
                        String sushi = scanner.nextLine().toLowerCase();
                        if (sushi.equals("yes")) {
                            System.out.println(SALMON_SUSHI);
                        } else if (sushi.equals("no")) {
                            System.out.println(BBQ_SUSHI);
                        }
                    }
                }
            }
        }
        System.out.println(GOODBYE_MESSAGE);

    }
}
