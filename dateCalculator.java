import java.util.Scanner;

public class dateCalculator {
    public static boolean isLeapYear(int y) {
        boolean ret = false;

        if (y % 400 == 0) {
            ret = true;
        } else if (y % 100 == 0) {
            ret = false;
        } else ret = y % 4 == 0;

        return ret;
    }

    public static String computeDate(int day, int year) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] monthNames = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY",
                "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

        boolean leap = isLeapYear(year);

        if (leap) {
            monthDays[1] = 29;
        }

        int i = 0;
        int daySum = 0;
        for (i = 0; i < monthDays.length; i++) {
            daySum += monthDays[i];
            if (daySum >= day) {
                break;
            }
        }

        int date = day + monthDays[i] - daySum;

        StringBuffer sb = new StringBuffer();
        sb.append(date);
        sb.append("TH ");
        sb.append(monthNames[i]);
        sb.append(", ");
        sb.append(year);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("DAY NUMBER: ");
        int dayNum = in.nextInt();
        System.out.print("YEAR: ");
        int year = in.nextInt();
        System.out.print("DATE AFTER (N DAYS): ");
        int n = in.nextInt();
        in.close();
        if (dayNum < 1 || dayNum > 366) {
            System.out.println("DAY NUMBER OUT OF RANGE");
            return;
        }

        if (n < 1 || n > 100) {
            System.out.println("DATE AFTER (N DAYS) OUT OF RANGE");
            return;
        }

        String dateStr = computeDate(dayNum, year);

        int nDays = dayNum + n;
        int nYear = year;
        boolean leap = isLeapYear(year);

        if (leap && nDays > 366) {
            nYear = nYear + 1;
            nDays = nDays - 366;
        } else if (nDays > 365) {
            nYear = nYear + 1;
            nDays = nDays - 365;
        }

        String nDateStr = computeDate(nDays, nYear);

        System.out.println();
        System.out.println("DATE: " + dateStr);
        System.out.println("DATE AFTER " + n + " DAYS: " + nDateStr);
    }
}