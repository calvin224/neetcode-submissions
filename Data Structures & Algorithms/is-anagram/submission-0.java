class Solution {
    public boolean isAnagram(String s, String t) {
    // If the lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Initialize HashMaps
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Populate the HashMaps
        for (int i = 0; i < s.length(); i++) {
            char charFromS = s.charAt(i);
            char charFromT = t.charAt(i);

            // Update map1 with characters from string s
            map1.put(charFromS, map1.getOrDefault(charFromS, 0) + 1);
            // Update map2 with characters from string t
            map2.put(charFromT, map2.getOrDefault(charFromT, 0) + 1);
        }

        // Compare the two maps
        return map1.equals(map2);
  }
}



