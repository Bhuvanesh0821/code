import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        backtrack(result, new StringBuilder(), digits, 0, mapping);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder sb, String digits, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(result, sb, digits, index + 1, mapping);
            sb.deleteCharAt(sb.length() - 1); // undo
        }
    }
}