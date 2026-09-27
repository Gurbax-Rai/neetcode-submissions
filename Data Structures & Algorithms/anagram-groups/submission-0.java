class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            StringBuilder key = new StringBuilder();

            int[] counts = new int[26];

            for (int i = 0; i < word.length(); i++) {
                int curr = word.charAt(i) - 'a';
                counts[curr]++;
            }

            for (int count : counts) {
                key.append("" + count).append("#");
            }

            if (!groups.containsKey(key.toString())) {
                groups.put(key.toString(), new ArrayList<String>());
            }
            groups.get(key.toString()).add(word);
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : groups.keySet()) {
            result.add(groups.get(key));
        }

        return result;
    }
}
