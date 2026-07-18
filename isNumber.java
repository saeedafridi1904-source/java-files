class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } 
            else if (ch == '+' || ch == '-') {
                // Signs can only appear at the very beginning or right after an 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (ch == '.') {
                // A dot cannot appear after another dot or after an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } 
            else if (ch == 'e' || ch == 'E') {
                // An exponent cannot appear twice, and it must be preceded by at least one digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure digits follow the exponent
            } 
            else {
                // Any other character makes the number invalid
                return false;
            }
        }
        
        // The string is only valid if it ended with a valid digit sequence
        return seenDigit;
    }
}