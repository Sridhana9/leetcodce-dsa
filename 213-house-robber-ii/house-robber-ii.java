class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robLine(nums, 0, nums.length - 2),
                        robLine(nums, 1, nums.length - 1));
    }

    private int robLine(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int cur = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
