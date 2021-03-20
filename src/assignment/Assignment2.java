package assignment;

public class Assignment2 {

    static double calcSum(int n, double x) {
//        0.25 * sum (x+k) / x, k=0 to n
        if (x != 0) {
            double sum = 0;
            for (int k = 0; k <= n; k++) {
                sum += (x + k) / x;
            }
            sum = 0.25 * sum;
            return sum;
        } else {
            return 0;
        }
    }

    static int calcNested(int n, int x, int y) {
//        2 + sum (x + (product y, j=0 to k)), k=0 to n
        // in wolframAlpha alternate equations it shows division by y-1, that's why i check y!=1
        if (y != 1) {
            int sum = 0;
            int multiplication;
            for (int k = 0; k <= n; k++) {
                multiplication = 1;
                for (int j = 0; j <= k; j++) {
                    multiplication *= y;
                }
                sum = sum + x + multiplication;
            }
            return 2 + sum;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(calcSum(6, 3.0));
        System.out.println(calcNested(7, 6, 3));
    }
}
