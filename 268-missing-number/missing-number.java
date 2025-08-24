class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                if (nums[i]==arr[j]) arr[j]=0;
            }

        }
        int ans=0;
        for(int i=0;i<n+1;i++){
            if(arr[i]!=0){
                ans=arr[i];
            }
        }
        return ans;
    }
}