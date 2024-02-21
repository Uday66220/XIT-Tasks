
//Write a function to remove duplicates from an array
import java.util.*;

class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrlist = new ArrayList<>();
        System.out.print("Enter size of an array : ");
        int n = sc.nextInt(); // no of elements in arraylist
        System.out.println("Enter array elements :");
        for (int i = 0; i < n; i++) {
            arrlist.add(sc.nextInt());
        }
        System.out.println(removeduplicates(arrlist));
    }

    public static ArrayList<Integer> removeduplicates(ArrayList<Integer> al) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer i : al) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                al.remove(i);
            }
        }
        return al;
    }
}