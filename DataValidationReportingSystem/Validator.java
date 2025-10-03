import java.io.File;
import java.io.FileNotFoundException;
/**
 * A code that manges stock market records in log files containing a variety of information
 *
 * <p>Purdue University -- CS18000 -- L35
 *
 * @author Katie O'Daniel Purdue CS
 * @version Oct 30, 2021
 */
public class Validator {
    public static int checkPrice(int price) throws InvalidPriceException {
        if (price >= 0) {
            return price;
        } else {
            throw new InvalidPriceException("Invalid Price Format: " + price);
        }
    }

    public static int checkValueFormat(String line, String valueType) throws WrongFormatException {
        if (valueType.equals("MaxValue")) {
            if (line.matches("Max:\\d+")) {
                String[] parts = line.split(":");
                return Integer.parseInt(parts[1]);
            } else {
                throw new WrongFormatException("Invalid " + valueType + " error");
            }
        } else if (valueType.equals("MinValue")) {
            if (line.matches("Min:\\d+")) {
                String[] parts = line.split(":");
                return Integer.parseInt(parts[1]);
            } else {
                throw new WrongFormatException("Invalid " + valueType + " error");
            }
        } else if (valueType.equals("CompanyNumberValue")) {
            if (line.matches("CompanyNumber:\\d+")) {
                String[] parts = line.split(":");
                return Integer.parseInt(parts[1]);
            } else {
                throw new WrongFormatException("Invalid " + valueType + " error");
            }
        } else {
            throw new WrongFormatException("Invalid" + valueType + " error");
        }
    }

    public static void checkFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File: " + fileName + " is invalid");
        }
    }
}
