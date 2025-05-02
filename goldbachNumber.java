/*A Goldbach number is a positive even integer that can be expressed as the sum of two odd primes.
Note: All even integer numbers greater than 4 are Goldbach numbers.
Example:
6 = 3 + 3
10 = 3 + 7
10 = 5 + 5
Hence, 6 has one odd prime pair 3 and 3. Similarly, 10 has two odd prime pairs, i.e. 3, 7 and 5, 5.
Write a program to accept an even integer N where N > 9 and N < 50. Find all the odd prime pairs whose sum is equal to the number N.
*/

import java.util.Scanner;

public class goldbachNumber {
    public static void main(String[] args) {
        // Taking inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int num = sc.nextInt();
        sc.close();
        if (num < 0 || num % 2 != 0 || num <= 9 || num >= 50) { // Checking if number is invalid
            System.out.println("Invalid input");
            System.exit(0);
        }
        if (num % 2 == 0 && num > 4) { // If num is even and greater than 4, then its goldback
            // Finding pairs
            System.out.println("It is a goldbach number \nPairs are:");
            for (int i = 3; i < num; i += 2) {
                for (int j = 3; j < num; j += 2) {
                    if (isPrime(i) && isPrime(j) && i + j == num && i <= j) { // If both numbers are odd primes and they add to the original no, they are required pairs
                        System.out.println(i + " " + j); // Printing the pairs
                    }
                }
            }
        } else {
            System.out.println("It's not a goldbach number");
        }
    }

    public static boolean isPrime(int num) { // Checking if number is a prime
        int flag = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag += 1;
                break;
            }
        }
        return flag == 0;
    }
}