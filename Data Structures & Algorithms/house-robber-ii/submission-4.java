class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int r1 = robHelper(nums, 1, n-1);
        int r2 = robHelper(nums, 2, n);
        return Math.max(r1, r2);
    }

    private int robHelper(int[]nums, int s, int e){
        int n = nums.length;
        int[]dp = new int[n+1];
        dp[0] = 0;
        dp[s] = nums[s-1];
        for(int i = s+1; i<= e; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[e];
    }
}
