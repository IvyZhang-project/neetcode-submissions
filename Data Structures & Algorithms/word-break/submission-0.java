class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(String word : wordDict){
                int l = word.length();
                if(i >= l && dp[i - l]){
                    dp[i] = dp[i] || word.equals(s.substring(i-l, i));
                }

            }
        }
        return dp[n];
    }
}
