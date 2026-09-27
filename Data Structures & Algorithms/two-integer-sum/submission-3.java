class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Time O(n) Space O(n)

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if (seen.containsKey(target - curr)) {
                return new int[]{seen.get(target - curr), i};
            } else {
                seen.put(curr, i);
            }
        }

        return new int[]{0,0};
    }
}
