
//Find the missing number in a given integer array of 1 to 100
import java.util.*;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println("Missing Numbers :"); // missing number from 1 to size of an array
        for (int i = 1; i < n + 1; i++) {
            if (!arr.contains(i)) {
                System.out.println(i);
            }
        }
    }
}
