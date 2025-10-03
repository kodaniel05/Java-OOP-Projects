import javax.swing.*;
import java.io.*;
import java.net.*;
/**
 * A server that handles the computations for seaching a file 
 *
 * <p>Purdue University -- CS18000 -- Fall 2022 -- challenge  11 -- Challenge 
 *
 * @author Katie O'daniel
 * @version Nov 5th, 2022
 */
public class SearchClient {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        String hostName = JOptionPane.showInputDialog("Enter the server host name:");
        int portNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter the server port number:"));

        try (Socket socket = new Socket(hostName, portNumber);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)) {

            JOptionPane.showMessageDialog(null, "Connection established with the server.", "Connected", JOptionPane.INFORMATION_MESSAGE);

            boolean searchAgain = true;

            while (searchAgain) {
                String searchText = JOptionPane.showInputDialog("Enter the text to search:");
                pw.println(searchText);

                String response = br.readLine();

                if (response.equals("0")) {
                    JOptionPane.showMessageDialog(null, "No results found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int numResults = Integer.parseInt(response);

                    String[] results = new String[numResults];

                    for (int i = 0; i < numResults; i++) {
                        results[i] = br.readLine();
                    }

                    String selectedResult = (String) JOptionPane.showInputDialog(null, "Select a search result:", "Search Results",
                            JOptionPane.QUESTION_MESSAGE, null, results, results[0]);

                    if (selectedResult != null) {
                        int selectedIndex = -1;

                        for (int i = 0; i < numResults; i++) {
                            if (results[i].equals(selectedResult)) {
                                selectedIndex = i;
                                break;
                            }
                        }

                        if (selectedIndex != -1) {
                            pw.println(selectedIndex);

                            String description = br.readLine();
                            JOptionPane.showMessageDialog(null, "Description:\n" + description, "Result Description", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                int choice = JOptionPane.showConfirmDialog(null, "Do you want to search again?", "Search Again", JOptionPane.YES_NO_OPTION);
                searchAgain = (choice == JOptionPane.YES_OPTION);
            }

            JOptionPane.showMessageDialog(null, "Thank you for using the search application. Goodbye!", "Farewell", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection failed. Please check the server and try again.", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
