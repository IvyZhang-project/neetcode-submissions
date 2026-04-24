class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s == null || s.length() == 0){
            return res;
        }
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        int max = 0;
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(i == j){
                    dp[i][j] = true;
                }
                else if(j == i + 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if(dp[i][j] && (j-i+1) > max){
                    max = j-i+1;
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}
