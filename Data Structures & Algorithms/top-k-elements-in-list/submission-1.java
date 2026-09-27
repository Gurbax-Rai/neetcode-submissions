class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(counts.get(a), counts.get(b))
        );

        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.put(num, counts.get(num) + 1);
        }

        for (int num : counts.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (counts.get(num) > counts.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
