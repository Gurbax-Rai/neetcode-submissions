class Solution {
    public int search(int[] nums, int target) {
        // Time O(log(n)) Space O(1)

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            int curr = nums[mid];

            if (curr > target) {
                right = mid - 1;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                return mid;
            }

            mid = left + (right - left) / 2;
        }

        return -1;
    }
}
