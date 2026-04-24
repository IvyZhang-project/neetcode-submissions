class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        } 
        int half = sum/2;
        boolean[][]dp = new boolean[n+1][half+1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= half; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
            }

        }
        return dp[n][half];
    }
}
