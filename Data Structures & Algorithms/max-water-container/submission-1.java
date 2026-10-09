class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            max = Math.max(max, width * height);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
