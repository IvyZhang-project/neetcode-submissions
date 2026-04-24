class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][]grid, int i, int j){
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        int n = grid.length;
        int m = grid[0].length;
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[]d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '1'){
                dfs(grid, ni, nj);
            }
        }
        return;
    }
}
