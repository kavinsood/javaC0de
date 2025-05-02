import java.util.Scanner;
import java.util.StringTokenizer;

public class wordShift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence: ");
        String sentence = sc.nextLine();
        StringTokenizer st = new StringTokenizer(sentence); // Default delimiter is used ' '
        System.out.println("Enter shift: ");
        int shift = sc.nextInt() % st.countTokens(), count = 0;
        sc.close();
        String s2 = "", s3 = "";
        // Append words to strings
        while (st.hasMoreTokens()) {
            if (count < st.countTokens() - shift) {
                s2 = s2 + st.nextToken() + " ";
                count++;
            } else
                s3 += st.nextToken() + " ";
        }
        System.out.println("Shifted sentence is:\n" + s3 + s2);
    }
}