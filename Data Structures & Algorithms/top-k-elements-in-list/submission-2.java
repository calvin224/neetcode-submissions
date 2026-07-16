class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        // Count occurrences
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Bucket: index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {

            int num = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }


        int[] result = new int[k];
        int index = 0;

        // Start from highest frequency
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {

            if (buckets[i] != null) {

                for (int num : buckets[i]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}