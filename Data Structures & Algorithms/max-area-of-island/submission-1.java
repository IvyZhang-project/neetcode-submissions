class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][]grid, int i, int j){
        int area = 1;
        int[]posn = {i,j};
        grid[i][j] = 2;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(posn);
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[]p = queue.poll();
            int x = p[0];
            int y = p[1];
            for(int[]d: dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1){
                    grid[nx][ny] = 2;
                    area++;
                    int child[] = {nx, ny};
                    queue.add(child);
                }
            }

        }
        return area;
    }
}
