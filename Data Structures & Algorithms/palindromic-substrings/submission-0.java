class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        for(int c = 0; c < n; c++){
            for(int r = 0; r <= c; r++){
                if(r == c){
                    dp[r][c] = true;
                }
                else if(c == r + 1){
                    dp[r][c] = s.charAt(r) == s.charAt(c);
                }
                else{
                    dp[r][c] = (s.charAt(r) == s.charAt(c)) && dp[r+1][c-1];
                }
                if(dp[r][c]){
                    res = res + 1;
                }
            }
        }
        return res;
    }
}
