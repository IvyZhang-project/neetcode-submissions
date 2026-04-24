class Solution {
    private int res = 0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && grid[i][j] != '2'){
                    dfs(grid, i, j);
                    res++;
                }
                
            }
        }
        return res;
    }

    private int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};

    private void dfs(char[][]grid, int i, int j){
        if(grid[i][j] == '2'){
            return;
        }
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '2';
        for(int[]d: dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '1'){
                dfs(grid, ni, nj);
            }
        }
        return;
    }
}
