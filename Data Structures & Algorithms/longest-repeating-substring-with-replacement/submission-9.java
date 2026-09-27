class Solution {
    public int characterReplacement(String s, int k) {
        // Time O(n) Space O(n)

        Map<Character, Integer> seen = new HashMap<>();

        int max = 0;
        int left = 0;
        int right = 0;

        seen.put(s.charAt(left), 1);

        while (right < s.length()) {
            int freq = findMostFreq(seen);

            if ((right - left + 1) - freq <= k) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
                right++;
                if (right < s.length()) {
                    char curr = s.charAt(right);
                    if (!seen.containsKey(curr)) {
                        seen.put(curr, 0);
                    }
                    seen.put(curr, seen.get(curr) + 1);
                }
            } else {
                seen.put(s.charAt(left), seen.get(s.charAt(left)) - 1);
                left++;
            }
        }

        return max;
    }

    public int findMostFreq(Map<Character, Integer> seen) {
        int max = 0;
        for (char curr : seen.keySet()) {
            if (seen.get(curr) > max) {
                max = seen.get(curr);
            }
        }
        return max;
    }
}
