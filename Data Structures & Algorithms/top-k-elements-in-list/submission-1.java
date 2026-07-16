class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        // count occurrences
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {

            int maxNum = 0;
            int maxCount = 0;

            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxNum = entry.getKey();
                }
            }

            result[i] = maxNum;

            // remove so we don't pick it again
            freq.remove(maxNum);
        }

        return result;
    }
}