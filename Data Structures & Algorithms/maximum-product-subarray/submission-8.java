class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[]dpmin = new int[n+1];
        int[]dpmax = new int[n+1];
        dpmin[0] = 1;
        dpmax[0] = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <=n ; i++){
            dpmin[i] = Math.min(Math.min(nums[i-1], dpmin[i-1]*nums[i-1]), dpmax[i-1] * nums[i-1]);
            dpmax[i] = Math.max(Math.max(nums[i-1], dpmin[i-1]*nums[i-1]), dpmax[i-1]*nums[i-1]);
            res = Math.max(res, dpmax[i]);
        }
        return res;
    }
}
