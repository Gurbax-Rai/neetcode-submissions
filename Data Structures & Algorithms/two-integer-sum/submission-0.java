class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        seen.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (seen.containsKey(target - curr)) {
                return new int[]{seen.get(target - curr), i};
            }

            seen.put(curr, i);
        }

        return new int[]{0,0};
    }
}
