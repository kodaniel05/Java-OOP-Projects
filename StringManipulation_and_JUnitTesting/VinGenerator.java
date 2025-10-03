import java.util.Scanner;

/**
 * HW-03 --VinGenerator
 *
 * This program takes in input from user and returns a VIN
 *
 * @author Katie O'Daniel, YourLabSectionHere
 *
 * @version June 15, 2023
 *
 */

public class VinGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Origin Country Code:");
        int countryCode = scanner.nextInt();
        String codeFinal = String.format("%4s", Integer.toBinaryString(countryCode)).replace(' ', '0');
        scanner.nextLine();

        System.out.println("Enter the Vehicle Make:");
        String make = scanner.nextLine().toUpperCase();
        make = make.substring(0 , 2);
        codeFinal += make;

        System.out.println("Enter the Color of the Vehicle:");
        String colorSum = scanner.nextLine();
        colorSum = colorSum.toLowerCase();
        String asciiString = String.valueOf((int) colorSum.charAt(0) 
            + (int) colorSum.charAt(1) + (int) colorSum.charAt(2));
        asciiString = asciiString.substring(asciiString.length() - 2);
        codeFinal += asciiString;


        System.out.println("Enter the Model of the Vehicle:");
        String model = scanner.nextLine().toUpperCase();
        String modelCode =  model.charAt(0) + model.substring(model.length() - 1);
        codeFinal += modelCode;

        System.out.println("Enter the Year of the Vehicle:");
        String year = scanner.nextLine();
        year = year.substring(year.length() - 2);
        codeFinal += year;

        System.out.println("Enter the Delivery Destination:");
        String destination = scanner.nextLine().toUpperCase().substring(0 , 2);
        codeFinal += destination;


        System.out.println("Enter the Fuel Type:");
        String fuelType = scanner.nextLine().toUpperCase().substring(0 , 1);
        codeFinal += fuelType;


        System.out.println("Enter the Estimated Kilometers Per Liter:");
        float perLiter = scanner.nextFloat();
        int convert = (int) ( perLiter / 0.42514);
        codeFinal += convert;
        scanner.nextLine();

        codeFinal = codeFinal.replaceAll("I" , "1").replaceAll("O" , "0");
        System.out.println("The Assigned VIN is " + codeFinal);



    } //End main method

} //End VinGenerator class
