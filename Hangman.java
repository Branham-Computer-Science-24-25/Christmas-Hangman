import java.util.Scanner;

/**
 * A class that determines whether a letter exists in an unknown word, replaces
 * the underscores of the word with the correct character, checks if a letter
 * has already been guessed, increments the number of wrong guesses when a
 * letter does not exist in an unknown word, and updates the state of the hangman game
 * according to the wrong guesses.
 * @author Korie Coaquira and Jasmine Lim
 */ 
 
public class Hangman
{
    private DifficultyLevel level; //per difficulty level, there is a DIFFERENT corresponding word.
    private int wrongGuesses;
    private String state; //a string of the hanging stand; body parts of Rudolph are added as wrongGuesses increments.
    private String letterBank; //the letters previously guessed.
    private String guessedWord; //a string of the underscores; letters are added if an inputted letter is correct.
    
    /**
     * Constructs a base Hangman game according to a diffculty level.
     * @param level an object from the DifficultyLevel class that holds the unknown word
     */ 
    public Hangman(DifficultyLevel level)
    {
        this.level = level;
        
        //initializes wrong guesses counter, letterBank, and the base state of the Hangman.
        wrongGuesses = 0;
        state = "  ---------\n   |      |\n          | \n          |\n          |\n          |\n          | \n        ===== ";
        letterBank = "";
        
        //represents the unknown word through underscores.
        if (level.getWord().equals("Elf"))
        {
            guessedWord = "_ _ _";
        }
        else if (level.getWord().equals("Gift"))
        {
            guessedWord = "_ _ _ _";
        }
        else
        {
            guessedWord = "_ _ _ _ _ _ _";
        }
    }
    
    /**
     * Checks if a letter has been guessed before.
     * @param aLetter the letter to check
     * @return true if the letter has been guessed previously, false if not
     */ 
    public boolean letterInLetterBank(char aLetter)
    {
        //converted to lower-case in case the letter is capitalized.
        char letter = Character.toLowerCase(aLetter);
        //the indexOf String method returns -1 if a letter doesn't exist in a String object.
        if (letterBank.indexOf(letter) != -1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a letter is in the unknown word.
     * @param aLetter the letter to check
     * @return true if the letter is within the unknown word, false if not
     */ 
    public boolean letterInWord(char aLetter)
    {
        //converted to lower-case in case the letter is capitalized.
        char letter = Character.toLowerCase(aLetter);
        //converted to lower-case because the unknown word has capitalized letters.
        String word = level.getWord().toLowerCase();
        //the indexOf String method returns -1 if a letter doesn't exist in a String object.
        if (word.indexOf(letter) != -1)
        {
            //adds the letter to the bank of previously guessed letters.
            letterBank += letter;
            return true;
        }
        letterBank += letter;
        //increments wrongGuesses if the letter doesn't exist in the unknown word.
        wrongGuesses++;
        return false;
    }
    
    /** 
    * Returns the current state of the hangman game. 
    * @return the state
    */ 
    public String getState()
    {
        return state;
    }
    
    /**
     * Updates the state of the Hangman game based on the amount of wrong guesses.
     */ 
    public void updateState()
    {
        //adds Rudolph's head and antlers.
        if (wrongGuesses == 1)
        {
            state = "  ---------\n   |      |\n \\| |/    | \n  \\ /     |\n   O      |\n          |\n          | \n        =====";
        }
        //adds Rudolph's body.
        else if (wrongGuesses == 2)
        {
            state = "  ---------\n   |      |\n \\| |/    | \n  \\ /     |\n   O      |\n    \\___  |\n          | \n        =====";
        }
        //adds Rudolph's front legs.
        else if (wrongGuesses == 3)
        {
            state = "  ---------\n   |      |\n \\| |/    | \n  \\ /     |\n   O      |\n    \\___  |\n    /     | \n        =====";
        }
        //adds Rudolph's back legs.
        else if (wrongGuesses == 4)
        {
            state = "  ---------\n   |      |\n \\| |/    | \n  \\ /     |\n   O      |\n    \\___  |\n    /   \\ | \n        =====";
            
        }
    }
    
    /** 
    * Returns the guessed word so far.
    * @return the guessed word
    */ 
    public String getGuessedWord()
    {
        return guessedWord;
    }
    
    /**
     * Replaces an underscore with a letter.
     * @param aLetter the letter to replace an underscore with
     */ 
    public void updateGuessedWord(char aLetter)
    {
        //converted to lower-case in case the letter is capitalized.
        char letter = Character.toLowerCase(aLetter);
        //locates the underscore to replace.
        int place = level.getWord().toLowerCase().indexOf(letter) * 2;
        guessedWord = guessedWord.substring(0, place) + level.getWord().charAt(place/2) + guessedWord.substring(place + 1);
    }
    
    /**
     * Checks if the unknown word is correctly guessed.
     * @return true if the letters of guessedWord matches the unknown word, false if not
     */ 
    public boolean wonGame()
    {
        Scanner in = new Scanner(guessedWord);
        //delimiter used to gather each individual character of guessedWord while ignoring the spaces. 
        in.useDelimiter(" ");
        String wordSoFar = "";
        while (in.hasNext())
        {
            wordSoFar += in.next();
        }
        if (wordSoFar.equals(level.getWord()))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if there are 4 wrong guesses (lost).
     * @return true if the number of wrong guesses is 4, false if not
     */ 
    public boolean lostGame()
    {
        if (wrongGuesses == 4)
        {
            return true;
        }
        return false;
    }
}
