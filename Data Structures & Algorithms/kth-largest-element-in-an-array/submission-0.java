class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            minHeap.offer(curr);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
