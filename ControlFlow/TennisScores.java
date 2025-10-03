import java.util.Scanner;

/**
 * A Tennis Scores calculator. 
 *
 * @author Purdue CS
 * @version June 14, 2021
 */
public class TennisScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter Player One Name: ");
        String playerOne = scanner.nextLine();
        System.out.println("Enter Player Two Name: ");
        String playerTwo = scanner.nextLine();
        System.out.println("Enter Game Scores:");
        String scores = scanner.nextLine();

        scanner.close();



        // The values of each of the scores are defined below, you should use these int variables in your calculations. 
        int currentScoreIndex = 0;
        int playerOneGameOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int playerOneGameNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int playerOneGameTen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameEleven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameEleven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameTwelve = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTwelve = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameThirteen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameThirteen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        // Todo: Implement your solution below!
        int totalPlayerOne = playerOneGameOne + playerOneGameTwo + playerOneGameThree + playerOneGameFour +
                playerOneGameFive + playerOneGameSix + playerOneGameSeven + playerOneGameEight + playerOneGameNine
                + playerOneGameTen + playerOneGameEleven + playerOneGameTwelve + playerOneGameThirteen;
        int totalPlayerTwo = playerTwoGameOne + playerTwoGameTwo + playerTwoGameThree + playerTwoGameFour
                + playerTwoGameFive + playerTwoGameSix + playerTwoGameSeven + playerTwoGameEight + playerTwoGameNine
                + playerTwoGameTen + playerTwoGameEleven + playerTwoGameTwelve + playerTwoGameThirteen;

        if (totalPlayerOne > totalPlayerTwo) {
            System.out.println("The winner is: " + playerOne);
        } else if (totalPlayerTwo > totalPlayerOne) {
            System.out.println("The winner is: " + playerTwo);
        }

        System.out.println(playerOne + " scored " + totalPlayerOne + " points.");
        System.out.println(playerTwo + " scored " + totalPlayerTwo + " points.");


        String winning = "";

        if (playerOneGameOne > playerTwoGameOne) {
            winning += "W-";
        } else if (playerOneGameOne < playerTwoGameOne) {
            winning += "L-";
        }

        if (playerOneGameTwo > playerTwoGameTwo) {
            winning += "W-";
        } else if (playerOneGameTwo < playerTwoGameTwo) {
            winning += "L-";
        }

        if (playerOneGameThree > playerTwoGameThree) {
            winning += "W-";
        } else if (playerOneGameThree < playerTwoGameThree) {
            winning += "L-";
        }

        if (playerOneGameFour > playerTwoGameFour) {
            winning += "W-";
        } else if (playerOneGameFour < playerTwoGameFour) {
            winning += "L-";
        }

        if (playerOneGameFive > playerTwoGameFive) {
            winning += "W-";
        } else if (playerOneGameFive < playerTwoGameFive) {
            winning += "L-";
        }

        if (playerOneGameSix > playerTwoGameSix) {
            winning += "W-";
        } else if (playerOneGameSix < playerTwoGameSix) {
            winning += "L-";
        }

        if (playerOneGameSeven > playerTwoGameSeven) {
            winning += "W-";
        } else if (playerOneGameSeven < playerTwoGameSeven) {
            winning += "L-";
        }

        if (playerOneGameEight > playerTwoGameEight) {
            winning += "W-";
        } else if (playerOneGameEight < playerTwoGameEight) {
            winning += "L-";
        }

        if (playerOneGameNine > playerTwoGameNine) {
            winning += "W-";
        } else if (playerOneGameNine < playerTwoGameNine) {
            winning += "L-";
        }

        if (playerOneGameTen > playerTwoGameTen) {
            winning += "W-";
        } else if (playerOneGameTen < playerTwoGameTen) {
            winning += "L-";
        }

        if (playerOneGameEleven > playerTwoGameEleven) {
            winning += "W-";
        } else if (playerOneGameEleven < playerTwoGameEleven) {
            winning += "L-";
        }

        if (playerOneGameTwelve > playerTwoGameTwelve) {
            winning += "W-";
        } else if (playerOneGameTwelve < playerTwoGameTwelve) {
            winning += "L-";
        }

        if (playerOneGameThirteen > playerTwoGameThirteen) {
            winning += "W";
        } else if (playerOneGameThirteen < playerTwoGameThirteen) {
            winning += "L";
        }

        System.out.println( playerOne + " Game Log: " + winning );

        String score = "";
        if (playerTwoGameOne > playerOneGameOne) {
            score += "W-";
        } else if (playerTwoGameOne < playerOneGameOne) {
            score += "L-";
        }

        if (playerTwoGameTwo > playerOneGameTwo) {
            score += "W-";
        } else if (playerTwoGameTwo < playerOneGameTwo) {
            score += "L-";
        }

        if (playerTwoGameThree > playerOneGameThree) {
            score += "W-";
        } else if (playerTwoGameThree < playerOneGameThree) {
            score += "L-";
        }

        if (playerTwoGameFour > playerOneGameFour) {
            score += "W-";
        } else if (playerTwoGameFour < playerOneGameFour) {
            score += "L-";
        }

        if (playerTwoGameFive > playerOneGameFive) {
            score += "W-";
        } else if (playerTwoGameFive < playerOneGameFive) {
            score += "L-";
        }

        if (playerTwoGameSix > playerOneGameSix) {
            score += "W-";
        } else if (playerTwoGameSix < playerOneGameSix) {
            score += "L-";
        }

        if (playerTwoGameSeven > playerOneGameSeven) {
            score += "W-";
        } else if (playerTwoGameSeven < playerOneGameSeven) {
            score += "L-";
        }

        if (playerTwoGameEight > playerOneGameEight) {
            score += "W-";
        } else if (playerTwoGameEight < playerOneGameEight) {
            score += "L-";
        }

        if (playerTwoGameNine > playerOneGameNine) {
            score += "W-";
        } else if (playerTwoGameNine < playerOneGameNine) {
            score += "L-";
        }

        if (playerTwoGameTen > playerOneGameTen) {
            score += "W-";
        } else if (playerTwoGameTen < playerOneGameTen) {
            score += "L-";
        }

        if (playerTwoGameEleven > playerOneGameEleven) {
            score += "W-";
        } else if (playerTwoGameEleven < playerOneGameEleven) {
            score += "L-";
        }

        if (playerTwoGameTwelve > playerOneGameTwelve) {
            score += "W-";
        } else if (playerTwoGameTwelve < playerOneGameTwelve) {
            score += "L-";
        }

        if (playerTwoGameThirteen > playerOneGameThirteen) {
            score += "W";
        } else if (playerTwoGameThirteen < playerOneGameThirteen) {
            score += "L";
        }

        System.out.println(playerTwo + " Game Log: " + score);

        int perfectGamesPlayerOne = 0;
        int perfectGamesPlayerTwo = 0;

        for (int gameIndex = 0; gameIndex < 13; gameIndex++) {
            int playerOnePerfectScore = Integer.parseInt(scores.substring(gameIndex * 6, gameIndex * 6 + 2));
            int playerTwoPerfectScore = Integer.parseInt(scores.substring(gameIndex * 6 + 3, gameIndex * 6 + 5));

            if (playerTwoPerfectScore == 0) {
                perfectGamesPlayerOne++;
            }

            if (playerOnePerfectScore == 0) {
                perfectGamesPlayerTwo++;
            }
        }

        System.out.println(playerOne + " Perfect Games: " + perfectGamesPlayerOne);
        System.out.println(playerTwo + " Perfect Games: " + perfectGamesPlayerTwo);


    }
}
