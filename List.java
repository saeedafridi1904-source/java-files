import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Take each character from the first word
        for (char ch : words[0].toCharArray()) {
            boolean presentInAll = true;
            
            // Check if this character is present in every subsequent word
            for (int i = 1; i < words.length; i++) {
                int index = words[i].indexOf(ch);
                
                if (index == -1) {
                    // Character not found in this word
                    presentInAll = false;
                    break;
                }
            }
            
            // If the character was found in all words
            if (presentInAll) {
                result.add(String.valueOf(ch));
                
                // Remove the matched character from each subsequent word 
                // so duplicate characters aren't reused improperly
                for (int i = 1; i < words.length; i++) {
                    int index = words[i].indexOf(ch);
                    words[i] = words[i].substring(0, index) + words[i].substring(index + 1);
                }
            }
        }
        
        return result;
    }
}