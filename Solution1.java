import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public String[] findWords(String[] words) {
        // Map ASCII values of 'a' through 'z' to their respective row numbers (1, 2, or 3)
        // ASCII 'a' is 97, 'z' is 122
        int[] charToRow = new int[128];
        
        // Row 1: "qwertyuiop"
        String row1 = "qwertyuiop";
        for (int i = 0; i < row1.length(); i++) {
            charToRow[row1.charAt(i)] = 1; // Store 1 at ASCII index of character
        }
        
        // Row 2: "asdfghjkl"
        String row2 = "asdfghjkl";
        for (int i = 0; i < row2.length(); i++) {
            charToRow[row2.charAt(i)] = 2; // Store 2 at ASCII index of character
        }
        
        // Row 3: "zxcvbnm"
        String row3 = "zxcvbnm";
        for (int i = 0; i < row3.length(); i++) {
            charToRow[row3.charAt(i)] = 3; // Store 3 at ASCII index of character
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            
            // Get row number of the first character using its ASCII value
            int targetRow = charToRow[lowerWord.charAt(0)];
            boolean isValid = true;
            
            // Check if all other characters match the target row
            for (int i = 1; i < lowerWord.length(); i++) {
                char c = lowerWord.charAt(i);
                if (charToRow[c] != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}