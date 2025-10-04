class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // For each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int nextGreater = -1;
            boolean found = false;

            // Find position of num in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == num) {
                    found = true;
                }
                // If found, check for next greater element
                if (found && nums2[j] > num) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            ans[i] = nextGreater;
        }

        return ans;
    }
}