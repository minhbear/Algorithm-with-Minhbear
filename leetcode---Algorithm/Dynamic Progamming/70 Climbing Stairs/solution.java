import java.util.ArrayList;

class solution {

    // use Recursion to find possible case and add 1 if we find true case to array
    // list
    // return size of array list is the numbers of way can climb

    // BUT TIME LIMIT EXCEEDED
    public static int climbStairs(int n) {
        // int count = 0;
        ArrayList<Integer> countList = new ArrayList<>();
        recursion(n, countList);
        return countList.size();
    }

    private static void recursion(int step, ArrayList<Integer> countList) {
        if (step == 0) {
            countList.add(1);
            return;
        }

        if (step < 0) {
            return;
        }

        if (step >= 2) {
            recursion(step - 2, countList);
            recursion(step - 1, countList);
        }

        if (step < 2 && step >= 1) {
            recursion(step - 1, countList);
        }
    }

    /**
     * Solution 2
     * We use Hashmap to keep tract step proper n and memorize that to calculate
     * another step
     * 
     * To understand more solution to, please go to folder Hash Table and Find
     * Folder 70 Climbing Stairs
     * We will keep the link to go Hash Table Folder here:
     * https://github.com/ResupFPT/leetcode---Algorithm/tree/main/Hash%20Table/70%20Climbing%20Stairs
     */

    // Dynamic Progamming Solution
    // We see that with 1 step we have 1 ways to go - 1 steps
    // With 2 steps we have 2 ways to go: 1+1 or 2
    // SO when step is 3 we have 3 ways to go is 1+1+1 or 2+1 or 1+2
    // SO is means that with 3 step we can calculate the numbers of ways by sum of
    // the ways go with 1 steps or 2 steps
    // SO the Idea that steps(n) = steps(n-1) + steps(n-2)

    //Use Array + Loop
    public static int climbStairs2(int n) {
        int[] steps = new int[46];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }

    //Use Array with recursion
    public static int climbStairs3(int n) {
        int[] countList = new int[46];
        countList[1] = 1;
        countList[2] = 2;
        return recursion(n, countList);
    }

    private static int recursion(int step, int[] countList) {
        if (countList[step] == 0) {
            countList[step] = recursion(step - 1, countList) + recursion(step - 2, countList);
        }
        
        return countList[step];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs3(45));
    }
}
