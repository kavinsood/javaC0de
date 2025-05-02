// Find how many 'blins' (pancakes) you can make yourself when babushka (grandma) isn't home

import java.util.Scanner;

public class blinsMaker {
    public static void main(String[] args) {
        int eggs;
        int milk; // millilitre
        int flour; // grams
        // Recipe for single blin
        int minEggs = 2;
        int minMilk = 200;
        int minFlour = 100;
        // Taking inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("How many eggs you have?");
        eggs = sc.nextInt();
        System.out.println("How much milk you have?");
        milk = sc.nextInt();
        System.out.println("How much flour you have?");
        flour = sc.nextInt();
        sc.close();
        // Calculating if there is enough for one meal
        if (eggs < minEggs || milk < minMilk || flour < minFlour) // One meal is four blins
            System.out.println("There is not enough for a single meal :(");
        else { // Calculate Minimum possible portions
            int eggPortions = eggs / minEggs;
            int milkPortions = milk / minMilk;
            int flourPortions = flour / minFlour;
            int smallest;
            if ((eggPortions < milkPortions && eggPortions < flourPortions)) {
                smallest = eggPortions;
            } else {
                if (milkPortions < eggPortions && milkPortions < flourPortions) smallest = milkPortions;
                else smallest = flourPortions;
            }
            System.out.println("You can make " + smallest * 4 + " blins, or " + smallest + " portions");
            System.out.println("You need " + smallest * minEggs + " eggs and " +
                    (eggs - (smallest * minEggs)) + " will not be used");
            System.out.println("You need " + smallest * minMilk + "ml milk and " +
                    (milk - (smallest * minMilk)) + " will not be used");
            System.out.println("You need " + smallest * minFlour + "g flour and " +
                    (flour - (smallest * minFlour)) + " will not be used");
        }
        System.out.println("Blinmaker shutting down...");
    }
}
/**
 * Variable            Data        Table
 * eggs, milk, flour   int         Store amount of food user has
 * min""               int         (constant) Store minimum amount required for 1 pancake
 * portions            int         (constant) Minimum portions required
 * smallest            int         Store smallest out of eggs, milk and flour
 */