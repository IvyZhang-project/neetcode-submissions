class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][]grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        int[]posn = {i,j};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(posn);
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[]p = queue.poll();
            grid[p[0]][p[1]] = '2';
            for(int[]d: dir){
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                if(x >=0 && x < n && y >= 0 && y < m && grid[x][y] == '1'){
                    int child[] = {x,y};
                    queue.add(child);
                }
            }
        }
        return;        
    }
}

