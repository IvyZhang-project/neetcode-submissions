class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0){
            return false;
        }
        return searchHelp(matrix, 0, m-1, target);
    }

    private boolean searchHelp(int[][]matrix, int s, int e, int target){
        int l = matrix.length;
        int w = matrix[0].length;

        if(s < 0 || e > l-1 || s > e){
            return false;
        }

        int mid = (s+e)/2;

        if(target <= matrix[mid][w-1] && target >= matrix[mid][0]){
            return searchRow(matrix, mid, 0, w-1, target);
        }

        else if(target < matrix[mid][0]){
            return searchHelp(matrix, s, mid-1, target);
        }

        else {
            return searchHelp(matrix, mid+1, e, target);
        }
    }

    private boolean searchRow(int[][]matrix, int row, int s, int e, int target){
        int l = matrix.length;
        int w = matrix[0].length;
        if(row < 0 || row >= l){
            return false;
        }
        if(s < 0 || e >= w || s > e){
            return false;
        }
        if(target < matrix[row][s] || target > matrix[row][e]){
            return false;
        }
        int mid = (s+e)/2;
        if(target == matrix[row][mid]){
            return true;
        }
        else if(target < matrix[row][mid]){
            return searchRow(matrix, row, s, mid-1, target);
        }
        else{
            return searchRow(matrix, row, mid+1, e, target);
        }
    }
}
