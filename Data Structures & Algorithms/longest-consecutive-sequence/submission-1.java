class Solution {
    public int longestConsecutive(int[] nums) {
        //sort array
        if(nums.length == 0){
            return 0;
        }
        int[] newarray = new int[nums.length];
        newarray = quicksort(nums);

        int max = 1; // At least one element means the longest sequence is at least 1
        int temp = 1; // Start with 1 since a single element is a sequence of length 1

        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is part of a consecutive sequence
            if (nums[i] == nums[i - 1] + 1) {
                temp++;
            } else if (nums[i] != nums[i - 1]) {
                // Update max if needed and reset temp for a new sequence
                max = Math.max(max, temp);
                temp = 1; // Reset to 1 because we are starting a new sequence
            }
        }

        // Final check to update max in case the longest sequence ends at the last element
        return Math.max(max, temp);
    }

    public static int[] quicksort(int[] arr){
        int[] array = arr;
        quicksorthelper(array,0,arr.length-1); // 0 (low)
        return arr;
    }

    public static void quicksorthelper(int[] arr, int low, int high) {
        if (low < high) {
            // Find pivot element such that
            // elements smaller than pivot are on the left of pivot
            // elements greater than pivot are on the right of pivot
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quicksorthelper(arr, low, pi - 1);
            quicksorthelper(arr, pi + 1, high);
        }
    }

    // This function takes the last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller (smaller than pivot)
    // to the left of pivot and all greater elements to the right of pivot
    private static int partition(int[] arr, int low, int high) {
        // Pivot (Element to be placed at right position)
        int pivot = arr[high];

        // Index of smaller element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
