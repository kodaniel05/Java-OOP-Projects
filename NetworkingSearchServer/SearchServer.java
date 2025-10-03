import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**
 * A server that handles the computations for seaching a file
 *
 * <p>Purdue University -- CS18000 -- Fall 2022 -- challenge  11 -- Challenge
 *
 * @author Katie O'daniel
 * @version Nov 5th, 2022
 */
public class SearchServer {
    public static void main(String[] args) {
        int port = 4242;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server running and waiting for connection");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected.");

                    while (true) {
                        String searchText = br.readLine();

                        if (searchText == null) {
                            break;
                        }

                        String[] searchResults = searchDatabase(searchText);
                        pw.println(searchResults.length);

                        for (String result : searchResults) {
                            pw.println(result);
                        }

                        if (searchResults.length > 0) {
                            int selectedIndex = Integer.parseInt(br.readLine());
                            String selectedDescription = getDescription(selectedIndex);
                            pw.println(selectedDescription);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] searchDatabase(String searchText) {
        ArrayList<String> results = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("searchDatabase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[1];
                String description = parts[2];
                if (title.contains(searchText) || description.contains(searchText)) {
                    results.add(title);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results.toArray(new String[0]);
    }

    private static String getDescription(int selectedIndex) {
        try (BufferedReader br = new BufferedReader(new FileReader("searchDatabase.txt"))) {
            int currentIndex = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (currentIndex == selectedIndex) {
                    return line.split(";")[2];
                }
                currentIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Description not found";
    }
}
