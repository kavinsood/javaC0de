/* Finding potential of each word in a sentence, printing words in ascend
ing order of their potential
 * Potential is the sum of positions of each letter in a word */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class potential {
    public static void main(String[] args) throws IOException {
        // Getting Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter sentence in upper case: ");
        String sentence = br.readLine();
        // Variables
        sentence = sentence.trim();
        sentence += " ";
        char ch;
        String word = "";
        int length = sentence.length();
        int sum = 0;
        int counter = 1;
        int[] arrSum = new int[length];
        String[] arrStr = new String[length];
        //Printing potential of each word. Each word and it's sum stored an array
        System.out.println("\nPotential: ");
        for (int i = 0; i < length; i++) {
            ch = sentence.charAt(i);
            if (ch != ' ') {
                sum += ch - 64;
                word += ch;
            } else {
                arrSum[counter] = sum;
                arrStr[counter] = word;
                System.out.println(word + ": " + sum);
                sum = 0;
                word = "";
                counter += 1;
            }
        }
        // Sorting words based on potential using Bubble Sort
        int temp;
        String tem;
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < (counter - i - 1); j++) {
                if (arrSum[j] > arrSum[j + 1]) {
                    //Swapping potential values
                    temp = arrSum[j];
                    arrSum[j] = arrSum[j + 1];
                    arrSum[j + 1] = temp;
                    //Swapping corresponding word
                    tem = arrStr[j];
                    arrStr[j] = arrStr[j + 1];
                    arrStr[j + 1] = tem;
                }
            }
        }
        //Printing the final values
        System.out.println();
        for (int i = 1; i < counter; i++)
            System.out.print(arrStr[i] + " ");
        System.out.println();
    }
}
/**
 * Variable data table
 * Variable Data type Function
 * sentence String Used to store sentence entered
 * ch char Used in calculations
 * word String Used to store words from sentence
 * length int Used to store length
 * sum int Used in calculations
 * counter int Used as a counter
 * arrSum[] int Used to store potential of each word
 * arrStr[] String Used to store each word
 * temp int Used in swapping in sorting
 */