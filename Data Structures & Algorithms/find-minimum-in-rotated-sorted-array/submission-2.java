class Solution {
    public int findMin(int[] nums) {
        // Time O(log(n)) Space O(1)

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        int min = nums[left];

        while (left <= right) {
            int curr = nums[mid];
            
            if (curr < min) {
                min = curr;
            }

            if (nums[left] < min) {
                min = nums[left];
            }

            if (curr >= nums[left]) {
                // LEFT HALF IS SORTED

                left = mid + 1;

            } else {
                // RIGHT HALF IS SORTED

                right = mid - 1;
            }

            mid = left + (right - left) / 2;            
        }

        return min;
    }
}
