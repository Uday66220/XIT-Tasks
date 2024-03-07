/*
 * Given an integer n, break into  the sum of k positive integers, and return the maximum product of those integers.
Input:
Integer n
Desired Output:
Maximum product of numbers whose sum is n.
Example 1:
n=5;
5 can be written as sum of following numbers.
Possible Sums:
1.            1+1+1+1+1,
2.            1+4,
3.            1+1+3,
4.            1+1+1+2,
5.            2+3,
6.            1+2+2.....etc
Product of these integers:
1.            1*1*1*1*1=1,
2.            1*4=4,
3.            1*1*3=3,
4.            1*1*1*2=2
5.            2*3=6,
6.            1*2*2=4.....etc
Output returned should be maximum product which in the above case is 6.
Example 2:
n=10;
Desired Output : 36
Integers : 3,3,4 or 3,3,2,2
 */

//approach

/*The maximum product can be obtained be repeatedly cutting parts of size 3 
while size is greater than 4, keeping the last part as size of 2 or 3 or 4.
*/

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