public class disariumNumber {
    int num;
    int size;

    disariumNumber(int nn) {
        this.num = nn;
        this.size = 0;
    }

    public static void main(String[] args) {
        disariumNumber o = new disariumNumber(135);
        o.countDigit();
        o.check();
        System.out.println(o.sumOfDigits(135, 3));
        
        disariumNumber o2 = new disariumNumber(89);
        o2.countDigit();
        o2.check();
        System.out.println(o2.sumOfDigits(89, 2));
        
        disariumNumber o3 = new disariumNumber(80);
        o3.countDigit();
        o3.check();
        System.out.println(o3.sumOfDigits(80, 2));
    }

    void countDigit() {
        this.size = String.valueOf(this.num).length();
    }

    int sumOfDigits(int n, int p) {
        return p == 0 ? 0 : (int) Math.pow(n % 10, p) +
                this.sumOfDigits(n / 10, p - 1);
    }

    void check() {
        if (this.num == this.sumOfDigits(this.num, this.size)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}