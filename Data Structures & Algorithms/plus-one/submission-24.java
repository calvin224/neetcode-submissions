class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry-over needed, return immediately
            }
            digits[i] = 0; // Set to 0 if it was 9 and continue the loop for carry
        }

        // If we reached here, all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Set the leading 1, rest are already 0 by default
        return result;
    }
}
