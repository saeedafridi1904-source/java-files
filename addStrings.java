class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        // Loop until all digits and carry are processed
        while (i >= 0 || j >= 0 || carry > 0) {
            // Get numeric digit or 0 if index is out of bounds
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            // Calculate sum and update carry
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;

            // Prepend the current digit to result string (Inefficient O(N^2) string allocation)
            result = (sum % 10) + result;

            i--;
            j--;
        }

        return result;
    }
}