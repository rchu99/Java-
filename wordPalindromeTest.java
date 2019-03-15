
import java.util.Scanner;
/**
 *
 * @author Raymond
 */
public class wordPalindromeTest {
    public static void main(String[] args) {

    Scanner userInput = new Scanner(System.in);

    System.out.println("TYPE in a word or sentence to see if it is a Palindrome hehe ecksdee:");

    String input = userInput.nextLine();
    if (isWordPalindrome(input)) {
    System.out.println("True! it is a Palindrome");
    } else { 
        System.out.println("False! it is not a Palindrome");
    }
    System.out.println("bye");
    userInput.close();

  }
  
  public static boolean isWordPalindrome(String s) {
      String a = s.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
      String[] arrString = a.split("\\s+");
      
      int beg, end = arrString.length - 1; 
      beg = 0;
      while (beg <= arrString.length/2) {
          if (!arrString[beg].equals(arrString[end])) {
              return false;
          }
          beg++;
          end--;
      }
      return true;
    }
}
