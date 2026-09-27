class Solution {
    public int characterReplacement(String s, int k) {
        // Time O(n) Space O(1)

        Map<Character, Integer> seen = new HashMap<>();

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char curr = s.charAt(right);
            if (!seen.containsKey(curr)) {
                seen.put(curr, 0);
            }
            seen.put(curr, seen.get(curr) + 1);

            int freq = findMostFreq(seen);

            while ((right - left + 1) - freq > k) {
                seen.put(s.charAt(left), seen.get(s.charAt(left)) - 1);
                left++;
            } 

            if (right - left + 1 > max) {
                max = right - left + 1;
            }
            
            right++;
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
