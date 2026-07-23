class Solution {
    public boolean isMatch(String s, String p) {
        // Base case: If pattern is empty, string must also be empty
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // Check if the first character matches (or if '.' is used)
        boolean firstMatch = (!s.isEmpty() && 
                              (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // Case 1: The next character in pattern is '*'
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Choice A: Ignore the '*' and its preceding element (match 0 times)
            // Choice B: Use the '*' to match current char (if first match is true) and stay on p
            return (isMatch(s, p.substring(2)) || 
                   (firstMatch && isMatch(s.substring(1), p)));
        } 
        
        // Case 2: Standard matching without '*'
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}