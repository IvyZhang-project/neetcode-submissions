class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String res = "";
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
                if(c-r+1 > max && dp[r][c]){
                    max = c -r + 1;
                    res = s.substring(r, c+1);
                }
            }
        }
        return res;
    }
}
