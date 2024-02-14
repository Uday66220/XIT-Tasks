import java.util.*;
class Task2Atm{
    public static List<List<Integer>> combinations;
    public static int max = Integer.MIN_VALUE;
    public static Map<Integer, Integer> result;
    /* finding different possible combinations and selecting the combination with more
        number of denominations as efficient and storing in result Hashmap
    */
    public static void Withdraw(int index, int[][] atm, int amount, List<Integer> l) {
        if(index == atm.length) {
            if(amount == 0) {
                HashMap<Integer, Integer> hm = new HashMap<>();
                for(int i: l)
				{
					hm.put(i, hm.getOrDefault(i, 0) + 1);
				}
                if(hm.size() > max) {
                    result = hm;
                    max = hm.size();
                }
                combinations.add(new ArrayList<>(l));
                return ;
            }
            return ;
        }
    
        
        if(amount - atm[index][0] >= 0 && atm[index][1] > 0) {
            l.add(atm[index][0]);
            atm[index][1] -= 1;
            Withdraw(index, atm, amount - atm[index][0], l);
            atm[index][1] += 1;
            l.remove(l.size() - 1);
        }
        
        Withdraw(index + 1, atm, amount, l);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int[][] atm=new int[4][2];
        combinations=new ArrayList<>();
        result=new HashMap<>();
        //using two dimensional array to store denominations and number of available
        atm[0][0] = 2000; atm[1][0] = 500; atm[2][0] = 200; atm[3][0] = 100;
        System.out.println("Enter number of 2000 denomination : ");
        atm[0][1]=sc.nextInt();
        System.out.println("Enter number of 500 denomination : ");
        atm[1][1]=sc.nextInt();
        System.out.println("Enter number of 200 denomination : ");
        atm[2][1]=sc.nextInt();
        System.out.println("Enter number of 100 denomination : ");
        atm[3][1]=sc.nextInt();
        System.out.println("Enter the amount to Withdraw");
        int amount=sc.nextInt();
        if(amount<100)
        {
            System.out.println("Amount should be greater than 100");
            return;
        }
        Withdraw(0,atm,amount,new ArrayList<>());
        //System.out.println(combinations);
        System.out.println("Denominations Received from Atm :");
        for(Integer k:result.keySet())
        {
                System.out.println(k+" -- "+result.get(k));
        }
		for(int i = 0; i < 4; i++) {
		    atm[i][1] -= result.getOrDefault(atm[i][0], 0);
		}
		System.out.println("Denominations remaining in ATM: ");
		for(int[] rem: atm) {
		    System.out.println(rem[0] + " -- " + rem[1]);
		}
    }
}



//TEST CASES


/*
Enter number of 2000 denomination : 
5
Enter number of 500 denomination :
10
Enter number of 200 denomination :
15
Enter number of 100 denomination :
10
Enter the amount to Withdraw
300
Denominations Received from Atm :
100 -- 1
200 -- 1
Denominations remaining in ATM:
2000 -- 5
500 -- 10
200 -- 14
100 -- 9


Enter number of 2000 denomination : 
4
Enter number of 500 denomination :
5
Enter number of 200 denomination :
6
Enter number of 100 denomination :
10
Enter the amount to Withdraw
8000
Denominations Received from Atm :
2000 -- 3
500 -- 3
100 -- 1
200 -- 2
Denominations remaining in ATM:
2000 -- 1
500 -- 2
200 -- 4
100 -- 9
 */