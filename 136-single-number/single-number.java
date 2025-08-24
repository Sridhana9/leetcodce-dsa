class Solution {
    public int singleNumber(int[] arr) {
        int n = arr.length;

        // Find minimum and maximum element
        int mini = arr[0], maxi = arr[0];
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        // Size of hash array = range of numbers
        int size = maxi - mini + 1;
        int[] hash = new int[size];

        // Hash the given array (shifted by mini)
        for (int i = 0; i < n; i++) {
            hash[arr[i] - mini]++;
        }

        // Find the single element
        for (int i = 0; i < n; i++) {
            if (hash[arr[i] - mini] == 1) {
                return arr[i];
            }
        }

        // Should never reach here for valid input
        return -1;
    }
}
