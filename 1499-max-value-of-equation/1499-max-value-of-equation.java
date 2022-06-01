/*
Equation can be rearranged like this:
=> yi+yj+|xi-xj|
=> yi+yj+xj-xi (since xi < xj)
=> (xj+yj)+(yi-xi)

Reason to use max heap or priority queue:
if 2nd part(yi-xi) of the equation increases then value of total equation will also increase that's why used priority queue with (yi-xi) as key. xi is stored as value because that's required in next iteration to verify this condition : xj-xi > k
*/
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        int max = Integer.MIN_VALUE;
        for(int[] point : points) {
            while(!maxHeap.isEmpty() && point[0] - maxHeap.peek().getValue() > k) {
                maxHeap.poll();
            }
            if(!maxHeap.isEmpty()) {
                max = Math.max(max, point[0] + point[1] + maxHeap.peek().getKey());
            }
            maxHeap.offer(new Pair<Integer, Integer>(point[1] - point[0], point[0]));
        }
        return max;
    }
}