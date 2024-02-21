//Write a function that merges two unsorted lists into a new sorted list

import java.util.*;

public class MergeUnsortedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of first Array : ");
        int n1 = sc.nextInt();
        System.out.println("Enter size of second Array : ");
        int n2 = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        System.out.println("Enter elements of first Array :");
        for (int i = 0; i < n1; i++) {
            arr1.add(sc.nextInt());
        }
        System.out.println("Enter elements of second Array :");
        for (int i = 0; i < n2; i++) {
            arr2.add(sc.nextInt());
        }
        listsort(arr1, arr2);
    }

    // merging two lists then sorting
    public static void listsort(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        l1.addAll(l2);
        Collections.sort(l1);
        System.out.println("Sorted List : ");
        System.out.println(l1);
    }
}
