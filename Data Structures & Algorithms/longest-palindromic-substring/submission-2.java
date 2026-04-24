class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        String res = "";
        int max = 0;
        for(int c = 0; c < n; c++){
            for(int r = 0; r <= c; r++){
                if(r == c){
                    dp[r][c] = true;
                }
                else if(c == r + 1){
                    dp[r][c] = s.charAt(r) == s.charAt(c);
                }
                else{
                    dp[r][c] = dp[r+1][c-1] && (s.charAt(r) == s.charAt(c));
                }
                if(dp[r][c] && c-r+1 > max){
                    max = c-r+1;
                    res = s.substring(r, c+1);
                }
            }
        }
        return res;
    }
}
