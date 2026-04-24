class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int[]dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int cur = s.charAt(i-1) - '0';
            int prev = s.charAt(i-2) - '0';
            int num = prev * 10 + cur;
            if(cur == 0){
                if(prev == 0){
                    return 0;
                }
                if(num >= 1 && num <= 26){
                    dp[i] = dp[i-2];
                }
            }
            else if(prev == 0 || num > 26){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
