class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        //3 3 3 3 3 4 4 4 2 2 
        Map<Integer, Integer> freq = new HashMap<>();
        for(int answer : answers) {
            freq.put(answer + 1, freq.getOrDefault(answer + 1, 0) + 1);
        }
        //3 + 1 -> 5
        //4 + 1 -> 3
        //2 + 1 -> 2
        for(int key : freq.keySet()) {
            int val = freq.get(key);
            int q = val / key;
            int r = val % key;
             ans += q * key;
             if(r > 0) {
                ans += key;
             }
             System.out.println(key + " " + val + " " + ans);
        }
        return ans;
    }
}