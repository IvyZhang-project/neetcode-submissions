class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][]dp = new boolean [n][n];
        int max = 1;
        int l = 0;
        int r = 0;
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(i == j){
                    dp[i][j] = true;
                }
                else if(j == i + 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if(dp[i][j] && j-i+1 >= max){
                    max = j-i+1;
                    l = i;
                    r = j;
                }

            }
        }
        return s.substring(l, r+1);
        
    }
}
