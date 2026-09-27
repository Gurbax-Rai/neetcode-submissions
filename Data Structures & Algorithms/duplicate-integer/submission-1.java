class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];

            if (prev == curr) {
                return true;
            }
        }

        return false;


        // Time O(n) Space O(n)
        // HashSet<Integer> seen = new HashSet<>();

        // for (int num : nums) {
        //     if (seen.contains(num)) {
        //         return true;
        //     } else {
        //         seen.add(num);
        //     }
        // }

        // return false;
    }
}