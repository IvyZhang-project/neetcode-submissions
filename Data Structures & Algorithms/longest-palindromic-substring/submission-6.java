class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int max = 0;
        boolean[][]dp = new boolean[n+1][n+1];
        dp[0][0] = true;
        for(int j = 1; j <= n; j++){
            for(int i = 1; i <= j ; i++){
                if(i == j){
                    dp[i][j] = true;
                }
                else if(j-i == 1){
                    dp[i][j] = s.charAt(i-1) == s.charAt(j-1); 
                }
                else{
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i-1) == s.charAt(j-1));
                }
                if(dp[i][j] && j-i+1 > max){
                    max = j-i+1;
                    res = s.substring(i-1, j);
                }

            }
        }
        return res;
    }
}
