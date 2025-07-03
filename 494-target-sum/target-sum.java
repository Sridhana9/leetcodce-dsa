class Solution {
    static int sum;
    public int ways(int i,int[] nums,int res, int k,int[][] dp){
        if(i>=nums.length){
            if(res==k) return 1;//valid way
            else return 0;  
        }
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];
        int add = ways(i+1,nums,res-nums[i],k,dp);
        int sub = ways(i+1,nums,res+nums[i],k,dp);
        return dp[i][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum =0;
        for(int ele:nums){
            sum+=ele;
        }
        
        int[][] dp= new int[nums.length][2*sum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<2*sum+1;j++){
                dp[i][j]=-1;
            }
        }
        return ways(0,nums,0,target,dp);
    }
}