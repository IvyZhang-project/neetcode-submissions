class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s == null ||  n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[]dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int cur = s.charAt(i-1) - '0';
            int prev = s.charAt(i-2) - '0';
            int num = prev * 10 + cur;
            if(cur == 0){
                if(num > 0 && num <= 26){
                    dp[i] = dp[i-2];
                }
                else{
                    return 0;
                }  
            }
            else{
                if(num > 10 && num <=26){
                    dp[i] = dp[i-1] + dp[i-2];
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[n];
    }
}
