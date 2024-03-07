import java.util.*;

class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Positive Integer :");
        int n = sc.nextInt();
        System.out.println("Maximum Product is : " + product(n));
    }

    public static int product(int n) {
        int result = 1;
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        while (n > 4) {
            result = result * 3;
            n -= 3;
        }
        result = result * n;
        return result;
    }
}