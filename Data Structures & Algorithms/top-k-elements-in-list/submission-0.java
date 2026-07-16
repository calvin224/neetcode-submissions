class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] results = new int[k];
        
        // Count the frequency of each element in the array
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Find the top k frequent elements
        for (int i = 0; i < k; i++) {
            int temp = 0;
            int maxKey = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > temp) {
                    temp = map.get(key);
                    maxKey = key;
                }
            }
            results[i] = maxKey;
            map.put(maxKey, -1); // Mark this element as processed
        }
        
        return results;
    }
}
