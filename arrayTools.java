import java.util.Arrays;
import java.util.Scanner;

public class arrayTools {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = input();
        print(arr);
        transpose(arr);
        rotate(arr);
        System.out.println("Enter number to multiply with");
        multiply1(arr, sc.nextInt());

    }

    static int[][] input() {
        System.out.println("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int c = sc.nextInt();
        System.out.println("Enter " + (r * c) + " elements");
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    static void print(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static void transpose(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[][] trans = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                trans[i][j] = arr[j][i];
            }
        }
        System.out.println("Transposed array: ");
        print(trans);
    }

    static void rotate(int[][] arr) {
        int[][] rot = new int[arr.length][arr[0].length];
        for (int i = 0, k = 2; i < rot.length; i++, k--) {
            for (int j = 0; j < rot[i].length; j++) {
                rot[j][k] = arr[i][j];
            }
        }
        System.out.println("pi/2 rad rotated clockwise matrix: ");
        print(rot);
    }

    static void multiply1(int[][] a, int b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] *= 2;
            }
        }
        System.out.println("Product matrix: ");
        print(a);
    }

    static void addSubtract(int[][] a, int[][] b) {
        if (a.length != b.length && a[0].length != b[0].length) {
            System.out.println("Matrices have different sizes!");
            return;
        }
        int[][] sum = new int[a.length][a[0].length];
        int[][] difference = new int[a.length][a[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
                difference[i][j] = a[i][j] - b[i][j];
            }
        }
        System.out.println("Sum of the matrices: ");
        print(sum);
        System.out.println("Difference between the matrices: ");
        print(difference);
    }

    static void arraySums(int[][] arr, int r, int c) {
        System.out.println("\nSum of left diagonals\n");
        int dL = 0, dR = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    System.out.print(arr[i][j] + " ");
                    dL += arr[i][j];
                }
            }
        }
        System.out.println(dL);
        System.out.println("\nSum of right diagonals\n");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i + j == (r - 1)) {
                    System.out.print(arr[i][j] + " ");
                    dR += arr[i][j];
                }
            }
        }
        System.out.println(dR);
    }

    static void rowShift(int[][] arr, int n) {
        int tmp;
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    tmp = arr[0][j];
                    arr[0][j] = arr[i][j];
                    arr[i][j] = tmp;
                }
            }
        }
    }
}