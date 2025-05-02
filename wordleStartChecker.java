// Deterministic factor for wordle starter accuracy:
// Does it include all most commonly used characters for its size?

import java.util.Scanner;

public class wordleStartChecker {
    static char[] list = {'e', 'a', 'r', 'i', 'o', 't', 'n', 's', 'l', 'c',
            'u', 'd', 'p', 'm', 'h', 'g', 'b', 'f', 'y', 'w', 'k', 'v', 'x', 'z', 'j', 'q'};
    static double[] freq = {56.88, 43.31, 38.64, 38.45, 36.51, 35.43, 33.92, 29.23,
            27.98, 23.13, 18.51, 17.25, 16.14, 15.36, 15.31, 12.59, 10.56, 9.24, 9.06,
            6.57, 5.61, 5.13, 1.48, 1.39, 1, 1};
    static int ntries;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many test 5-letter words do you want?");
        ntries = sc.nextInt();
        String word = "";
        for (int i = 1; i <= ntries; i++) {
            word += sc.next().trim();
        }
        compareWord(word.toLowerCase());
        sc.close();
    }

    static void compareWord(String word) {
        int length = word.length();
        // Create word with the highest accuracy for given length
        String check = "";
        int checkPercent = 0;
        for (int i = 0; i < length; i++) {
            check += list[i];
            checkPercent += freq[i];
        }
        // Check if word and check contains the same letters
        int flag = 0, wordPercent = 0;
        for (int i = 0; i < length; i++) {
            if (check.contains("" + word.charAt(i))) {
                flag += 1;
            }
            wordPercent += freq[findIndex(word.charAt(i))];
        }
        System.out.println(word + "\n" + check);
        if (flag == length) System.out.println("Your word(s) is an ideal wordle starter");
        if (flag < length) {
            double percent = (wordPercent * 100.0) / checkPercent;
            System.out.println("Your word isn't the ideal wordle starter. It is " +
                    Math.round((percent / ntries) * Math.pow(10, 2)) / Math.pow(10, 2) + "% of an ideal world");
        }
    }

    static int findIndex(char ch) {
        for (int i = 0; i < 26; i++) {
            if (list[i] == ch) return i;
        }
        return 0;
    }
}
