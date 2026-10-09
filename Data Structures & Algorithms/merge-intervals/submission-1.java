class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = merged.get(merged.size() - 1);

            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            } else {
                merged.add(curr);
            }
        }

        int[][] result = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }

        return result;
    }
}
