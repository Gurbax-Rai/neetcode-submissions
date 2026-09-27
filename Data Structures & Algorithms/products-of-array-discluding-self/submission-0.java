class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int leftProd = 1;
        int rightProd = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProd;
            leftProd = leftProd * nums[i];
        }

        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = result[i] * rightProd;
            rightProd = rightProd * nums[i];
        }

        return result;
    }
}  
