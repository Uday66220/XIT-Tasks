/*for use case 2: Person 1 Standing at Floor 1 requests for the elevator service first.
Person 2 from floor 8 requests for the elevator service second
Person 3 from floor 3 request for the elevator service third.
Elevator is at floor 0.
Now Elevator should receive Person 1 first Person 3 second and Person 2 at the last. */
import java.util.*;
class Service{
    static int num_Floors;
    static int npe;
    static int currentFloor=0;
    public static void move_to_floor(int[] arr)
    {
        if(currentFloor==0)
        {
            System.out.println(arr[0]);      //elevator moving to the first person (fcfs)
            currentFloor=arr[0];
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=1;i<arr.length;i++)
        {
            hm.put(arr[i],0);
        }
        floor_diff(hm,currentFloor);

    }
    //floor difference is updated recursively after updating the current floor
    public static void floor_diff(HashMap<Integer,Integer> hm,int cf)
    {
        if(hm.isEmpty())
        {
            return;
        }
        int min=Integer.MAX_VALUE;
        int k=cf;
        for (Integer n:hm.keySet()) 
        { 
            if(min>Math.abs(cf-n)){
                min=Math.abs(cf-n);
                k=n;
            }
            hm.put(n,Math.abs(cf-n));
        }
        
        hm.remove(k);
        System.out.println(k);
        floor_diff(hm,k);;
        
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of Floors : ");
        int num_Floors=sc.nextInt();
        System.out.print("Enter Number of Persons entering : ");
        int npe=sc.nextInt();
        int[] arr=new int[npe];
        System.out.println("Enter floor numbers :");
        for (int i=0;i<npe;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Sequence of floors :");
        move_to_floor(arr);
    }
}


/*
Enter Number of Floors : 10
Enter Number of Persons entering : 3
Enter floor numbers :
1
8
3
Sequence of floors :
1
3
8


Enter Number of Floors : 10
Enter Number of Persons entering : 4
Enter floor numbers :
6
3
8
2
Sequence of floors :
6
8
3
2
 */