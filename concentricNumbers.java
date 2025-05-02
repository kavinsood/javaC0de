/**
 * Given a positive integer n, print the matrix filled with rectangle pattern as shown below:
 * a a a a a
 * a b b b a
 * a b c b a
 * a b b b a
 * a a a a a
 * where a = n, b = n – 1,c = n – 2 and so on.
 */

import java.util.Scanner;

class concentricNumbers {
    public static void main(String[] args) {
        // Taking inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no");
        int n = sc.nextInt();
        sc.close();
        // This program is done using the distance formula
        n = 2 * n - 1;
        int m = (n - 1) / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Math.max(Math.abs(i - m), Math.abs(j - m)) + 1 + " ");
            }
            System.out.println();
        }
    }
}
/**
 * Variable        Data        Table
 * n               int         Store number entered by user
 * n, m            int         Used for calculation
 * i, j            int         Iterators
 */