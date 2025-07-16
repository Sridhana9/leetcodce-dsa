class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from last digit to first
        for (int i = n - 1; i >= 0; i--) {
            // If digit < 9, simply add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set to 0 and continue to propagate the carry
            digits[i] = 0;
        }

        // If all digits were 9, we need one extra digit at the beginning
        int[] result = new int[n + 1];
        result[0] = 1; // rest are already 0
        return result;
    }
}
