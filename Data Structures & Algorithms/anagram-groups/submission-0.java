class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Correctly instantiate the list
        List<List<String>> list = new ArrayList<>();
        // Boolean array to track visited strings
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;
            List<String> templist = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                if (!visited[j] && anagram(strs[i], strs[j])) {
                    templist.add(strs[j]);
                    visited[j] = true;
                }
            }
            list.add(templist);
        }

        return list;
    }

    public static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // Initialize HashMaps
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Populate the HashMaps
        for (int i = 0; i < str1.length(); i++) {
            char charFromStr1 = str1.charAt(i);
            char charFromStr2 = str2.charAt(i);

            // Update map1 with characters from string str1
            map1.put(charFromStr1, map1.getOrDefault(charFromStr1, 0) + 1);
            // Update map2 with characters from string str2
            map2.put(charFromStr2, map2.getOrDefault(charFromStr2, 0) + 1);
        }

        // Compare the two maps
        return map1.equals(map2);
    }
}
