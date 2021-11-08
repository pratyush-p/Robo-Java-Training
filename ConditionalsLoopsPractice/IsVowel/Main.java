import java.lang.*;

public class Main
{
    /**prints if the parameter is a vowel or not
    *@param(char letter) letter to test
    */
    public static boolean isVowel(char letter)
    {
        char letter_final = Character.toLowerCase(letter);
        if (letter_final == 'a' || letter_final == 'e' || letter_final == 'i' || letter_final == 'o' || letter_final == 'u') 
        {
          return true;
        } else {
          return false;
        }
        //System.out.println(letter_final);
    }
    public static void main(String[] args) {
        char test_letter = 'E';
        System.out.println(isVowel('E'));
    }
}
