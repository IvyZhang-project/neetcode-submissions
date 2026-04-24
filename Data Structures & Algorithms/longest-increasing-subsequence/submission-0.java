class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(nums[i-1] > nums[j-1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }  
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
