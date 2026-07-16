class Solution {
    public boolean isPalindrome(String s) {
         int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Move i forward if the character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            // Move j backward if the character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare characters at i and j (case-insensitive)
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            // Move pointers
            i++;
            j--;
        }

        return true; // All checks passed
    }
}
