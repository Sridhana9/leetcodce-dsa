class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Expected sum of 0..n
        int sum = (n * (n + 1)) / 2;
        
        // Actual sum of given array
        int s2 = 0;
        for (int num : nums) {
            s2 += num;
        }
        
        // Missing number = difference
        return sum - s2;
    }
}
