class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp = new int[nums.length];
        int[] ep = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[i],dp[j]);
            }
            dp[i]+=1;
            
        }
        for(int i=nums.length-1;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]>nums[j]) ep[i] = Math.max(ep[i],ep[j]);

            }
            ep[i]+=1;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]>1 && ep[i]>1){
                dp[i]=dp[i]+ep[i]-1;
                max = Math.max(max,dp[i]);
            }  
        }
        if(max<3) return 0;
        return nums.length-max;
    }
}