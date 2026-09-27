class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Time O() Space O(1)

        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            // Skips duplicate currs;
            if (i == 0 || curr != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (left == i) {
                        left++;
                    } else if (right == i) {
                        right--;
                    }

                    if (left != right) {
                        int sum = nums[left] + nums[right];
                        if (sum == -1 * curr) {
                            triplets.add(new ArrayList<>(List.of(curr, nums[left], nums[right])));
                            // Skips duplicate lefts and rights
                            int cL = nums[left];
                            int cR = nums[right];
                            while (left < right && nums[left] == cL) {
                                left++;
                            }
                            while (right > left && nums[right] == cR) {
                                right--;
                            }
                        } else if (sum > -1 * curr) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }

        return triplets;
    }
}
