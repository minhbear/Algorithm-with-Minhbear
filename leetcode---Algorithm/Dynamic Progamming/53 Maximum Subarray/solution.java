class solution{
    //solution 1
    //Time Limit Exceeded O(n^2)
    public static int maxSubArray1(int[] nums) {
        int[] sum = new int[nums.length];
        int maxSum = nums[0];
        sum[0] = nums[0];

        //Quy hoach dong
        for (int i = 0; i < sum.length; i++) {
            if(sum[i] == 0 && i != 0){
                sum[i] = sum[i-1] + nums[i];
            }

            //calculate the max sum
            for (int j = 0; j <= i; j++) {
                int sum_j_i = sum[i] - sum[j] + nums[j];
                maxSum = Math.max(maxSum, sum_j_i);
            }
        }

        return maxSum;
    }

    //solution 2
    //Time complexity O(n)
    public static int maxSubArray2(int[] nums) {
        int[] maxSumsArr = new int[nums.length];
        maxSumsArr[0] = nums[0];
        int maxSum = maxSumsArr[0];

        //definition
        /**
         * Max sum of subarray at nums[i] is must have nums[i]
         * Is mean subarray that can have at least i or i with the rest of element before i
         * we just need to calculate max sum of all element before i and compare nums[i] with nums[i] + maxsum[i-1] 
         */
        for (int i = 1; i < nums.length; i++) {
            maxSumsArr[i] = Math.max(nums[i], nums[i] + maxSumsArr[i-1]);
            maxSum = Math.max(maxSum, maxSumsArr[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray2(nums);
        System.out.println(result);
    }
}