

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each digit
        for (int d : digits) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Check all 3-digit even numbers
        for (int i = 100; i <= 999; i += 2) {
            int x = i;
            int c = x % 10; x /= 10;
            int b = x % 10; x /= 10;
            int a = x;

            // Check if digits a, b, c are available in map
            if (map.containsKey(a)) {
                int afreq = map.get(a);
                map.put(a, afreq - 1);
                if (afreq == 1) map.remove(a);

                if (map.containsKey(b)) {
                    int bfreq = map.get(b);
                    map.put(b, bfreq - 1);
                    if (bfreq == 1) map.remove(b);

                    if (map.containsKey(c)) {
                        ans.add(i);
                    }

                    map.put(b, bfreq);
                }

                map.put(a, afreq);
            }
        }

        // Convert result list to array
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
