import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A code that manges stock market records in log files containing a variety of information
 *
 * <p>Purdue University -- CS18000 -- L35
 *
 * @author Katie O'Daniel Purdue CS
 * @version Oct 30, 2021
 */
public class DataSystem {
    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Usage: java DataSystem <fileLog.txt>");
//            return;
//        }
        String fileName = args[0];
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter fileName: ");
        //String fileName= scanner.nextLine();

        try {
            Validator.checkFile(fileName);

            Report report = processLogFile(fileName);

            report.generateReport();

            report.generateReportMax();

            System.out.println("Reports generated successfully.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (WrongFormatException | InvalidPriceException e) {
            e.printStackTrace();
        }
    }


    private static Report processLogFile(String fileName) 
        throws IOException, WrongFormatException, InvalidPriceException {
        ArrayList<Company> companies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int maxPrice = -1;
            int minPrice = -1;
            int companyNumber = -1;
            boolean isHeaderProcessed = false;

            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Max:")) {
                    maxPrice = Validator.checkValueFormat(line, "MaxValue");
                } else if (line.startsWith("Min:")) {
                    minPrice = Validator.checkValueFormat(line, "MinValue");
                } else if (line.startsWith("CompanyNumber:")) {
                    companyNumber = Validator.checkValueFormat(line, "CompanyNumberValue");
                    isHeaderProcessed = true;
                } else {
                    if (!isHeaderProcessed) {
                        throw new WrongFormatException("Invalid data format");
                    }

                    String[] parts = line.split(":");
                    if (parts.length != 2) {
                        throw new WrongFormatException("Invalid data format");
                    }

                    String companyName = parts[0];
                    String[] priceData = parts[1].split(",");
                    int[] prices = new int[priceData.length];

                    for (int i = 0; i < priceData.length; i++) {
                        prices[i] = Validator.checkPrice(Integer.parseInt(priceData[i]));
                    }

                    companies.add(new Company(companyName, prices));

                }
            }

            if (companies.size() != companyNumber) {
                throw new WrongFormatException("Invalid CompanyNumberValue");
            }




            return new Report(minPrice, maxPrice, companies);
        }
    }



}