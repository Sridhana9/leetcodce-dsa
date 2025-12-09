class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > far) return false;      // cannot reach this index
            far = Math.max(far, i + nums[i]);
        }

        return true;
    }
}
