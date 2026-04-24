class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        int res = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res = Math.max(res, dfs(matrix, i, j, dp));
            }
        }
        return res;
    }

    private int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};

    private int dfs(int[][]matrix, int i, int j, int[][]dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        dp[i][j] = 1;

        for(int[]d: dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && matrix[ni][nj] < matrix[i][j]){
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, ni, nj, dp)+1);
            }
        }
        return dp[i][j];
    }


}
