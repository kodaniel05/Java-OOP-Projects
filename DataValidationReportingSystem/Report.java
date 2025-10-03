import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * A code that manges stock market records in log files containing a variety of information
 *
 * <p>Purdue University -- CS18000 -- L35
 *
 * @author Katie O'Daniel Purdue CS
 * @version Oct 30, 2021
 */
public class Report {
    private int minPrice;
    private int maxPrice;
    private ArrayList<Company> companyList;

    public Report(int minPrice, int maxPrice, ArrayList<Company> companyList) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.companyList = companyList;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    public void generateReport() {
        try {
            FileWriter writer = new FileWriter("Report.txt");

            for (Company company : companyList) {
                writer.write(company.getName() + " Report\n");

                int[] prices = company.getPrices();
                boolean allWithinRange = true;

                for (int i = 0; i < prices.length; i++) {
                    if (prices[i] < minPrice) {
                        allWithinRange = false;
                        writer.write("Below Minimum Price at " + i + " with " + prices[i] + ".\n");
                    } else if ( prices[i] > maxPrice) {
                        writer.write("Above  Minimum Price at " + i + " with " + prices[i] + ".\n");
                    }
                }

                if (allWithinRange) {
                    writer.write("All prices are within the range.\n");
                }

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReportMax() {
        try {
            FileWriter writer = new FileWriter("ReportMax.txt");
            for (Company company : companyList) {
                int[] prices = company.getPrices();
                int maxPrice1 = prices[0];
                for (int price : prices) {
                    if (price > maxPrice1) {
                        maxPrice1 = price;
                    }
                }
                writer.write(company.getName() + "-" + maxPrice1 + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
