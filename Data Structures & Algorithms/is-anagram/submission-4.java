class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            counts[curr]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int curr = t.charAt(i) - 'a';
            counts[curr]--;
            if (counts[curr] < 0) {
                return false;
            }
        }

        return true;
    }
}
