// Add time (hours and minutes) by passing arrays using Call by Reference

import java.util.Scanner;

public class adder {
    int[] a;

    adder() {
        a = new int[2];
    }

    public static void main(String[] args) {
        adder X = new adder();
        adder Y = new adder();
        X.readtime();
        Y.readtime();
        adder Z = new adder();
        Z.addtime(X, Y);
        Z.disptime();
    }

    void readtime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hours and minutes");
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        sc.close();
    }

    // Both arrays are passed as objects and final values are stored in calling object
    void addtime(adder X, adder Y) {
        this.a[0] = X.a[0] + Y.a[0];
        this.a[1] = X.a[1] + Y.a[1];
        if (this.a[1] > 60) {
            this.a[0] += 1;
            this.a[1] %= 60;
        }
    }

    void disptime() {
        System.out.println("hours = " + a[0] + " and minutes = " + a[1]);
    }
}
/**
 * Variable        Data        Table
 * a               int[]       Instance variable array
 * i               int         Used as count
 */