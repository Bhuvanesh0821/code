import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, dict, memo);
    }

    private List<String> backtrack(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int end = 1; end <= s.length(); end++) {
            String word = s.substring(0, end);
            if (dict.contains(word)) {
                List<String> subSentences = backtrack(s.substring(end), dict, memo);
                for (String sub : subSentences) {
                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}