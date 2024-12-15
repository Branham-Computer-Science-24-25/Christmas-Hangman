import java.util.Scanner;

/**
 * A class that allows the user (player) to pick a difficulty level and make guesses
 * (by inputting a character). It also determines if the user won or lost a hangman game.
 * @author Korie Coaquira and Jasmine Lim
 */ 

public class HangmanGame {
    public static void main (String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("CHRISTMAS HANGMAN");
        System.out.println("=====================================");
        
        //lets the user pick a difficulty level (1-3).
        System.out.println("Choose a difficulty level: " + "\n" + "Easy(1), Medium(2), or Hard(3)");
        int difficultyLevel = in.nextInt();
        //if the inputted level isn't from 1-3, then asks the user until a valid level is chosen.
        while (difficultyLevel < 1 || difficultyLevel > 3)
        {
            System.out.println("Not a valid level. Try again.");
            System.out.println("=====================================");
            System.out.println("Choose a difficulty level: " + "\n" + "Easy(1), Medium(2), or Hard(3)");
            difficultyLevel = in.nextInt();
        }
        
        DifficultyLevel level = new DifficultyLevel(difficultyLevel);
        Hangman player = new Hangman(level);
        
        //prints the hangman game (state), prints the underscores, and asks for a character
        //until the user wins or loses the game.
        do
        {
            System.out.println("=====================================");
            //prints the hangman game and underscores.
            System.out.println(player.getState());
            System.out.println(player.getGuessedWord());
            System.out.println();
            //asks for a character.
            System.out.println("Enter a character from to A to Z: ");
            char letter = in.next().charAt(0);
            //if the user input isn't a letter, then prints to try again.
            if (!(Character.isLetter(letter)))
            {
                System.out.println("Not a letter. Try again.");
            }
            //if the letter has already been guessed, then prints to try again.
            else if (player.letterInLetterBank(letter))
            {
                System.out.println("Letter already guessed. Try again.");
            }
            //if guessed letter is wrong, then hangman state is updated to add a body part.
            else if (!(player.letterInWord(letter)))
            {
                player.updateState();
                System.out.println("Incorrect guess.");
            }
            //if guessed letter is right, the an underscore is replaced.
            else
            {
                player.updateGuessedWord(letter);
                System.out.println("Correct guess!");
            }
        }
        while(!player.wonGame() && !player.lostGame());
        
        //prints final state of the hangman game once the game is finished.
        System.out.println("=====================================");
        System.out.println(player.getState());
        System.out.println(player.getGuessedWord());
        
        if (player.wonGame())
        {
            System.out.println("=====================================");
            System.out.println("Congratulations! The word is " + level.getWord() + "!");
        }
        else if (player.lostGame())
        {
            System.out.println("=====================================");
            System.out.println("You lost! Try again!");
        }
   }
}
