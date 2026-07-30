class Solution {
    private Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);
        
        // pruning: character counts must match
        if (!isAnagram(s1, s2)) {
            memo.put(key, false);
            return false;
        }
        
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // no swap: s1[0:i] vs s2[0:i], s1[i:] vs s2[i:]
            boolean noSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) 
                           && isScramble(s1.substring(i), s2.substring(i));
            
            // swap: s1[0:i] vs s2[n-i:], s1[i:] vs s2[0:n-i]
            boolean swap = isScramble(s1.substring(0, i), s2.substring(n - i)) 
                        && isScramble(s1.substring(i), s2.substring(0, n - i));
            
            if (noSwap || swap) {
                memo.put(key, true);
                return true;
            }
        }
        
        memo.put(key, false);
        return false;
    }
    
    private boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}