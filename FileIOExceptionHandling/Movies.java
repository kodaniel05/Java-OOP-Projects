import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A code that puts in order different movies
 *
 * <p>Purdue University -- CS18000 -- Spring 2022</p>
 *
 * @author Purdue CS
 * @version January 10, 2022
 */

public class Movies {
    private static final String INVALID_RATING = "Rating must be one of the following: PG, G, PG-13, NR, R";
    private static final String INVALID_SCORE = "Score must be between 0 and 10";
    private static final String INVALID_DURATION = "Duration must be between 0 and 300";
    private static final String INVALID_YEAR = "Year must be before 2024";

    public void makeRatingFile(String rating) {
        ArrayList<String> movieData = new ArrayList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader("movieData.txt"))) {
            String line = bfr.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[2].equals(rating)) {
                    movieData.add(parts[0] + " | " + parts[4]);
                }
                line = bfr.readLine();
            }

            writeToFile("ratings.txt", movieData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeScoreFile(double score, boolean greaterThan) {
        ArrayList<String> movieData = new ArrayList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader("movieData.txt"))) {
            String line = bfr.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    double movieScore = Double.parseDouble(parts[5]);
                    if ((greaterThan && movieScore > score) || (!greaterThan && movieScore <= score)) {
                        movieData.add(parts[0] + " | " + parts[4]);
                    }
                }
                line = bfr.readLine();
            }

            writeToFile("scores.txt", movieData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeDurationFile(int duration, boolean greaterThan) {
        ArrayList<String> movieData = new ArrayList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader("movieData.txt"))) {
            String line = bfr.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    int movieDuration = Integer.parseInt(parts[3]);
                    if ((greaterThan && movieDuration > duration) || (!greaterThan && movieDuration <= duration)) {
                        movieData.add(parts[0] + " | " + parts[4]);
                    }
                }
                line = bfr.readLine();
            }

            writeToFile("durations.txt", movieData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeYearFile(int year) {
        ArrayList<String> movieData = new ArrayList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader("movieData.txt"))) {
            String line = bfr.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int releaseYear = Integer.parseInt(parts[1]);
                    if (releaseYear == year) {
                        movieData.add(parts[0] + " | " + parts[4]);
                    }
                }
                line = bfr.readLine();
            }

            writeToFile("years.txt", movieData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateInput(String rating, double score, int duration, int year) throws InvalidInputException {
        if (!isValidRating(rating)) {
            throw new InvalidInputException(INVALID_RATING);
        }

        if (!isValidScore(score)) {
            throw new InvalidInputException(INVALID_SCORE);
        }

        if (!isValidDuration(duration)) {
            throw new InvalidInputException(INVALID_DURATION);
        }

        if (!isValidYear(year)) {
            throw new InvalidInputException(INVALID_YEAR);
        }
    }

     private boolean isValidRating(String rating) {
        return rating.equals("PG") || rating.equals("G") || rating.equals("PG-13")
                || rating.equals("NR") || rating.equals("R");
    }

    private boolean isValidScore(double score) {
        return score >= 0 && score <= 10;
    }

    private boolean isValidDuration(int duration) {
        return duration >= 0 && duration <= 300;
    }

    private boolean isValidYear(int year) {
        return year < 2024 && year >= 0 && String.valueOf(year).length() == 4;
    }

    private void writeToFile(String filename, ArrayList<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Movies movies = new Movies();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter Movie Rating:");
            String rating = scan.nextLine();

            System.out.println("Enter Movie Duration:");
            int duration = scan.nextInt();

            System.out.println("Enter Movie Score:");
            double score = scan.nextDouble();

            System.out.println("Will the filter be greater or less than? (true/false):");
            boolean greaterThan = scan.nextBoolean();

            System.out.println("Enter Movie Year:");
            int year = scan.nextInt();

            try {
                movies.validateInput(rating, score, duration, year);
                movies.makeRatingFile(rating);
                movies.makeDurationFile(duration, greaterThan);
                movies.makeScoreFile(score, greaterThan);
                movies.makeYearFile(year);
            } catch (InvalidInputException e) {
                
            }
        }
    }
}
