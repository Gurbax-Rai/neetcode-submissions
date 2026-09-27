class Solution {
    public int search(int[] nums, int target) {
        // Time O(log(n)) Space O(1)

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            int curr = nums[mid];
            
            if (curr == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // LEFT HALF IS SORTED

                if (target >= nums[left] && target < nums[mid]) {
                    // target is in left half
                    right = mid - 1;
                } else {
                    // target is in right half
                    left = mid + 1;
                }

            } else {
                // RIGHT HALF IS SORTED

                if (target > nums[mid] && target <= nums[right]) {
                    // target is in right half
                    left = mid + 1;
                } else {
                    // target is in left half
                    right = mid - 1;
                }
            }

            mid = left + (right - left) / 2;            
        }

        return -1;
    }
}
