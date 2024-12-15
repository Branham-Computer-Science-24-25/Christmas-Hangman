/**
 * A class in which each difficulty level (1-3) corresponds to a different unknown word
 * that the PLAYER must guess.
 * @author Korie Coaquira and Jasmine Lim
 */ 

public class DifficultyLevel
{
   private String word;
   
   /**
    * Constructs a DifficultyLevel object based on a difficulty level (1-3). 
    * @param difficultyLevel a value between 1 to 3, 1 being the easiest level and 3 being the hardest
    * difficultyLevel is checked to have a value of 1, 2, or 3 in the HangmanGame class.
    */  
   public DifficultyLevel(int difficultyLevel)
   {
       //a difficulty level of 1 makes the unknown word "Elf".
       if (difficultyLevel == 1)
       {
           word = "Elf";
       }
       //a difficulty level of 2 makes the unknown word "Gift".
       else if (difficultyLevel == 2)
       {
           word = "Gift";
       }
       //a difficulty level of 3 makes the unknown word "Chimney".
       else
       {
           word = "Chimney";
       }
   }
   
   /** 
    * Returns the unknown word.
    * @return the word that needs to be guessed
    */ 
   public String getWord()
   {
       return word;   
   }
}
