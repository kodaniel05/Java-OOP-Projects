import java.util.Scanner;
/**
 * Project 02 --TimeKeeper
 *
 * This program helps you find your CS lab
 *
 * @author Katie O'Daniel,
 *
 * @version June 15, 2023
 *
 */
public class TimeKeeper {

    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";
    private static void viewCurrentLabSchedule(LabManager labs) {
        System.out.println(labs.getLabOne());
        System.out.println(labs.getLabTwo());
        System.out.println(labs.getLabThree());
    }

    private static void listLabsByAvailability(LabManager labs) {
        if (labs.getLabOne().listAvailabilities().equals("No Availabilities")) {
            System.out.println("Lab One: No Availabilities");
        } else {
            System.out.println("Lab One:\n" + labs.getLabOne().listAvailabilities());
        }

        if (labs.getLabTwo().listAvailabilities().equals("No Availabilities")) {
            System.out.println("Lab Two: No Availabilities");
        } else {
            System.out.println("Lab Two:\n" + labs.getLabTwo().listAvailabilities());
        }

        if (labs.getLabThree().listAvailabilities().equals("No Availabilities")) {
            System.out.println("Lab Three: No Availabilities");
        } else {
            System.out.println("Lab Three:\n" + labs.getLabThree().listAvailabilities());
        }
    }

    private static void listLabsByReservation(LabManager labs) {
        if (labs.listReservedLabs().equals("No Reservations")) {
            System.out.println(labs.listReservedLabs());
        } else {
            System.out.println(labs.listReservedLabs());
        }
    }

    private static void addReservation(LabManager labs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(labLocationPrompt);
        String location = scanner.nextLine();
        System.out.print(reservationTimePrompt);
        String time = scanner.nextLine();
        System.out.print(reservationNamePrompt);
        String name = scanner.nextLine();
        System.out.print(reservationEnrollmentPrompt);
        int enrollment = scanner.nextInt();

        String result = labs.addReservation(location, time, name, enrollment);
        System.out.println(result);
    }

    private static void removeReservation(LabManager labs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(labLocationPrompt);
        String location = scanner.nextLine();
        System.out.print(reservationTimePrompt);
        String time = scanner.nextLine();

        String result = labs.removeReservation(location, time);
        System.out.println(result);
    }

    private static void modifyReservation(LabManager labs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(labLocationPrompt);
        String location = scanner.nextLine();
        System.out.print(reservationTimePrompt);
        String time = scanner.nextLine();
        System.out.print(reservationNameUpdate);
        String name = scanner.nextLine();
        System.out.print(reservationEnrollmentUpdate);
        int enrollment = scanner.nextInt();

        String result = labs.modifyReservation(location, time, name, enrollment);
        System.out.println(result);
    }

    private static void calculateStatistics(LabManager labs) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println(statisticsMenu);
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println(totalCapacity + labs.calculateTotalCapacity());
                    break;
                case "2":
                    System.out.println(totalUtilization + labs.calculateTotalUtilization());
                    break;
                case "3":
                    System.out.println(availableSeats + labs.calculateAvailableSeats());
                    break;
                case "4":
                    return;
                default:
                    System.out.println(invalidInput);
            }
        } while (Integer.parseInt(choice) != 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean initialized = false;

        int labOneCapacity = 0;
        String labOneLocation = "";
        int labTwoCapacity = 0;
        String labTwoLocation = "";
        int labThreeCapacity = 0;
        String labThreeLocation = "";

        Session emptySession = new Session("" , 0);
        Lab labOne = new Lab(emptySession , emptySession , labOneCapacity , labOneLocation);
        Lab labTwo = new Lab(emptySession , emptySession , labTwoCapacity , labTwoLocation);
        Lab labThree = new Lab(emptySession , emptySession , labThreeCapacity , labThreeLocation);
        LabManager labs = new LabManager(labOne , labTwo , labThree);
        System.out.println(welcomePrompt);



        while (true) {
            String choice = "";
            if (!initialized) {
                System.out.println(initializeMenu);
                choice = scanner.nextLine();

                switch (choice) {
                    case ("1"):
                        System.out.println(enterLabCapacity + "1");
                        labOneCapacity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(enterLabLocation + "1");
                        labOneLocation = scanner.nextLine();

                        System.out.println(enterLabCapacity + "2");
                        labTwoCapacity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(enterLabLocation + "2");
                        labTwoLocation = scanner.nextLine();

                        System.out.println(enterLabCapacity + "3");
                        labThreeCapacity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(enterLabLocation + "3");
                        labThreeLocation = scanner.nextLine();

                        emptySession = new Session("" , 0);
                        labOne = new Lab(emptySession , emptySession , labOneCapacity , labOneLocation);
                        labTwo = new Lab(emptySession , emptySession , labTwoCapacity , labTwoLocation);
                        labThree = new Lab(emptySession , emptySession , labThreeCapacity , labThreeLocation);

                        labs = new LabManager(labOne , labTwo , labThree);

                        initialized = true;
                        break;
                    case ("2"):
                        System.out.println(exitMessage);
                        return;
                    default:
                        System.out.println(invalidInput);
                        break;
                }
            } else {
                System.out.println(ongoingMenu);
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        viewCurrentLabSchedule(labs);
                        break;
                    case "2":
                        listLabsByAvailability(labs);
                        break;
                    case "3":
                        listLabsByReservation(labs);
                        break;
                    case "4":
                        addReservation(labs);
                        break;
                    case "5":
                        removeReservation(labs);
                        break;
                    case "6":
                        modifyReservation(labs);
                        break;
                    case "7":
                        calculateStatistics(labs);
                        break;
                    case "8":
                        System.out.println(exitMessage);
                        return;
                    default:
                        System.out.println(invalidInput);
                        break;
                }
            }
        }





    }


}