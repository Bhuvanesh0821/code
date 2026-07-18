class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> window = new HashMap<>();
            int left = i;
            int matched = 0;
            
            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String word = s.substring(right, right + wordLen);
                
                if (!wordMap.containsKey(word)) {
                    window.clear();
                    matched = 0;
                    left = right + wordLen;
                    continue;
                }
                
                window.put(word, window.getOrDefault(word, 0) + 1);
                matched++;
                
                while (window.get(word) > wordMap.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    matched--;
                    left += wordLen;
                }
                
                if (matched == wordCount) {
                    result.add(left);
                }
            }
        }
        
        return result;
    }
}