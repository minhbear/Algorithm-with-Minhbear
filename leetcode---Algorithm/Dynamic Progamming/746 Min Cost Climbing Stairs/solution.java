class solution{

    //Idea: The main idea is that calculate the minimum sum cost need to pay to go at the top, is not mean we need to go at index cost.length - 1. 
    //We need to go at index cost.length instead because the top is cost.length index. This is abstract way to undexstand deeply what we need to do
    // So we need to build an array to keep tract at index i in staircase how much money is minimum to pay

    //We can see another thing that the the money to pay at index i is the cost[i] + Min(money pay at index i-1 AND money pay at index i-2 )
    //THis is the formula we go to keep tract the money at each entry the array pay and at the end we will return the money at index pay[cost.length] that 
    //is the money we need to pay is the minimum

    //Time complexity O(n) Space complexity O(n)
    public static int minCostClimbingStairs(int[] cost) {
        
        //Array to keep track minimum to pay and go at the index i
        int[] minPay = new int[cost.length + 1];
        minPay[0] = cost[0];
        minPay[1] = cost[1];
        for (int i = 2; i < minPay.length; i++) {
            if(i != cost.length)
                minPay[i] = cost[i] + Math.min(minPay[i-1], minPay[i-2]);
            else{
                minPay[i] = minPay[i] + Math.min(minPay[i-1], minPay[i-2]);
            }
            
        }

        return minPay[cost.length];
    }

    //Improve solution 
    public static int minCostClimbingStairs1(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }

    public static void main(String[] args) {
        // int[] arr = {10,15,20};
        int[] arr = {1,100,1,1,1,100,1,1,100,1};

        System.out.println(minCostClimbingStairs(arr));
    }
}