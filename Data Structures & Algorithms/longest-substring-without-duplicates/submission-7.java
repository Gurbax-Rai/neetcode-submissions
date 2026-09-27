class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> seen = new HashSet<>();

        int max = 1;
        int left = 0;
        int right = 1;

        seen.add(s.charAt(left));

        while (right < s.length()) {
            char curr = s.charAt(right);
            if (!seen.contains(curr)) {
                seen.add(curr);
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
            } else {
                while (left < right && s.charAt(left) != curr) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }

        return max;
    }
}
