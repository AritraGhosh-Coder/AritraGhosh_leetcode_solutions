import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Use a Max-Heap to keep the heaviest stones at the top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // Smash stones until 1 or 0 stones remain
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest stone
            int x = maxHeap.poll(); // Second heaviest stone
            
            if (x != y) {
                maxHeap.offer(y - x);
            }
        }
        
        // Return the last stone's weight, or 0 if none are left
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}