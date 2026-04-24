class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int target = s.length();
        boolean[]dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 1; i <= target; i++){
            for(String word: wordDict){
                int l = word.length();
                if(i >= l){
                    dp[i] = dp[i - l] && s.substring(i-l, i).equals(word);
                }
                if(dp[i]){
                        break;
                }
            }
        }
        return dp[target];
    }
}
