class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele:stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int y = pq.remove();
            int x = pq.remove();
            int r = y-x;
            pq.add(r);
        }
        return pq.remove();
    }
}