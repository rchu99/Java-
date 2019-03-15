/*
 *
 * Name:
 * Date:
 * Section:
 *
 * Program Description
 *
 */
import java.util.Scanner;

public class Histogram {

    /*
    * Class Scope Variable Declarations
     */
    static final int SENTINAL = -999;    // sentinal value to signal end of input
    static final int MAX_NUMBERS = 20;    // maximum amount of values user can enter
    static final int NUM_BINS = 10;
    static final int UPPER_BOUND = 100;
    static final int LOWER_BOUND = 0;
    static final int BIN_SIZE = 10;

    /*
     * Class Methods
     */
    public static int[] calculateHistogram(double[] numbers, int numEntered) {
        int[] histogramCount = new int[NUM_BINS];
        int t = 0;
        //Creates an array of integers based on BIN_SIZE
        for (int j = BIN_SIZE; t < NUM_BINS; j+=BIN_SIZE, t++) {
            histogramCount[t] += j;
        }
        int[] newArr = new int[NUM_BINS];
        // Iterates through numbers and adds 1 if it is less than BIN_SIZE at i index
        for (int x = 0; x < numEntered; x++) {
            for (int i = 0; i < histogramCount.length; i++) {
                if (numbers[x] <= histogramCount[i]) {
                    newArr[i]++;
                    break;
                }
            }
        }
        return newArr;
    }

    public static String getHistogramAsString(int[] histogram) {
        String[] stars = new String[NUM_BINS];
        int i =0;
        int j =0;
        for (int x = LOWER_BOUND; x < UPPER_BOUND; x+=BIN_SIZE) {
            stars[i] = "(" + x + ".." + (BIN_SIZE + x) + "]";
            i++;
        }
        String str = "";
        
        for (i = 0; i < histogram.length; i++) {
            str += stars[i] + " ";
            while (histogram[j] != 0) {
                str += "*";
                histogram[j] -= 1;
            }
            str += "\n";
            j++;
        }
        return str;
    }
        
//        String[] StringHistogram = {"[0..10]: ", "(10..20]: ", "(20..30]: ", "(30..40]: ", "(40..50]: ", "(50..60]: ", "(60..70]: ", "(70..80]: ", "(80..90]: ", "(90..100]: "};
//        int x = 0;
//        String[] buckets = new String[NUM_BINS];
//        for (int t = 0; t < NUM_BINS; t++) {
//            buckets[t] = StringHistogram[t];
//        }
//        
//        
//        String histo = "";
//        for (int j = 0; j < NUM_BINS; j++) {
//            histo += buckets[j] + "\n";
//        }
//        return histo;
    

    public static boolean validInput(int[] numbers) {
        boolean check = true;
        for (int x = 0; x < numbers.length; x++) {
            if (!(numbers[x] < UPPER_BOUND) || !(numbers[x] > LOWER_BOUND)) 
                check = false;
        }
        return check;
    }

    /*
     * We have already completed getHeaderAsString() for you. 
     * You will also notice that this method is called from the 
     * main function. 
     *
     */
    public static String getHeaderAsString(String me) {

        // Create an instance of the StringBuilder class
        // which allows us to create an object of 
        // a series of strings that can then be converted 
        // into one large string via the toString method.
        //
        StringBuilder sb = new StringBuilder();

        sb.append(System.getProperty("line.separator"));
        sb.append("Welcome to the Histogram Program " + me + "!");
        me = getFirstName(me);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("This program will print out a histogram of the numbers");
        sb.append(System.getProperty("line.separator"));
        sb.append("input by you " + getFirstName(me) + ".");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("Please enter up to " + MAX_NUMBERS + " doubles or " + SENTINAL + " to stop input!");
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }

    /* 
     * Method to return the first name of the user in case
     * the full name was entered. 
     */
    public static String getFirstName(String name) {
        // Note that add the " " to string to be sure
        // there is something to split
        return (name + " ").split(" ")[0];
    }

    /*
     * We strongly encourage you to follow the guidelines 
     * stated in the specification to ensure that you properly 
     * test all methods of your program. However this method
     * is for you to write as you prefer.
     *
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.print( "And who am I working with today? " );
        String user = scan.nextLine();
        // Begin with a welcome message
        System.out.println( getHeaderAsString(user) );
        
        // Complete your program
        double arr[] = new double[MAX_NUMBERS];
        int count = 0;
        double input = 0;

        while (input != SENTINAL && input != -1 && count != MAX_NUMBERS) {
            System.out.print("Please enter a number: ");
            input = scan.nextDouble();
            if (input > UPPER_BOUND || input < LOWER_BOUND) {
                System.out.println("Error, num out of range");
            } else {
                arr[count] = input;
                count++;
            }
        }
        int newArr[] = calculateHistogram(arr, count);
        System.out.print(getHistogramAsString(newArr));

    }
}
