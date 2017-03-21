package _06design.P12_6;

/**
 * Created by jakecoll on 11/5/16.
 */
import java.util.Scanner;

public class ArithmeticGame {

    /**
     * main() method implement a new ArithmeticGame
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome, please enter your name: ");

        String userName = in.nextLine();

        //declare and initializes a player based on the user's inputed name
        Player player = new Player(userName);

        //while loop executes while Player object is on level 1
        //while loop declares and initializes a Level1Question objects, prints out question in human readable format
        //and takes in answer as input and checks and adjust Player object appropriately
        while(player.checkLevel1())
        {
            Level1Question question = new Level1Question();
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Enter your answer: ");
            int nUserAnswer = in.nextInt();
            System.out.println(checkLevel1Answer(player,question,nUserAnswer));
            System.out.println(checkLevel(player));

        }

        //while loop executes while Player object is on level 2
        //while loop declares and initializes a Level2Question objects, prints out question in human readable format
        //and takes in answer as input and checks and adjust Player object appropriately
        while(player.checkLevel2())
        {
            Level2Question question = new Level2Question();
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Enter your answer: ");
            int nUserAnswer = in.nextInt();
            System.out.println(checkLevel2Answer(player,question,nUserAnswer));
            System.out.println(checkLevel(player));
        }

        //while loop executes while Player object is on level 3
        //while loop declares and initializes a Level3Question objects, prints out question in human readable format
        //and takes in answer as input and checks and adjust Player object appropriately
        while(player.checkLevel3())
        {
            Level3Question question = new Level3Question();
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Enter your answer: ");
            int nUserAnswer = in.nextInt();
            System.out.println(checkLevel3Answer(player,question,nUserAnswer));
            System.out.println(checkLevel(player));
        }

        //If players finishes level three a game over message is printed and main() method is exited
        System.out.println("GAME OVER. RESTART TO PLAY AGAIN");
        System.exit(0);

    }

    /**
     * method checks a player's answer to a level 1 question
     * if answer is correct then score is increment and congrats method printed
     * otherwise wrong answer message printed
     * @param player
     * @param question
     * @param userAnswer
     * @return
     */
    public static String checkLevel1Answer(Player player, Level1Question question, int userAnswer)
    {
        if (userAnswer==question.getAnswer())
        {
            player.rightAnswer();
            return "Your answer is correct! Your score is now " + player.getScore();
        }
        else {
            return "Your answer was wrong. Try again!";
        }
    }

    /**
     * method checks a player's answer to a level 2 question
     * if answer is correct then score is increment and congrats method printed
     * otherwise wrong answer message printed
     * @param player
     * @param question
     * @param userAnswer
     * @return
     */
    public static String checkLevel2Answer(Player player, Level2Question question, int userAnswer)
    {
        if (userAnswer==question.getAnswer())
        {
            player.rightAnswer();
            return "Your answer is correct! Your score is now " + player.getScore();
        }
        else {
            return "Your answer was wrong. Try again!";
        }
    }

    /**
     * method checks a player's answer to a level 3 question
     * if answer is correct then score is increment and congrats method printed
     * otherwise wrong answer message printed
     * @param player
     * @param question
     * @param userAnswer
     * @return
     */
    public static String checkLevel3Answer(Player player, Level3Question question, int userAnswer)
    {
        if (userAnswer==question.getAnswer())
        {
            player.rightAnswer();
            return "Your answer is correct! Your score is now " + player.getScore();
        }
        else {
            return "Your answer was wrong. Try again!";
        }
    }

    /**
     * Method checks the level of a player and either
     * 1) prints how many points players needs until next level
     * 2) changes the level of the player and prints congrats message
     * @param player
     * @return
     */
    public static String checkLevel(Player player)
    {
        if (player.getScore() < 5)
        {
            int nPtsToGo = 5 - player.getScore();
            return "You have " + nPtsToGo + " points left to reach next level";
        } else {
            if (player.checkLevel1())
            {
                player.advanceToLevel2();
                return "You've advanced to LEVEL 2!";
            }
            if (player.checkLevel2())
            {
                player.advanceToLevel3();
                return "You've advance to LEVEL3!";
            }
            else
            {
                player.gameOver();
                return "YOU'VE WON!";
            }
        }
    }
}
