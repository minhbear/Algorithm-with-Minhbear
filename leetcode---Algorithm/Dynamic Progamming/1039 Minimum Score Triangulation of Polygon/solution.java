public class solution {
    //https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286705/JavaC%2B%2BPython-DP
    public static int minScoreTriangulation(int[] values) {
        int n = values.length;
        //create dynamic array to store value
        int[][] dp = new int[n][n];

        //to form triangle j need to be >= i+2
        for (int d = 2; d < n; d++) {
            for (int i = 0; i+d< dp.length; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                //choose point k in range(i,j)
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Integer.min(dp[i][j], dp[i][k] + dp[k][j] + values[i]*values[k]*values[j]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        // int[] values = {1,2,3};
        // int[] values = {3,7,4,5};
        int[] values = {1,3,1,4,1,5};
        System.out.println(minScoreTriangulation(values));
    }
}
