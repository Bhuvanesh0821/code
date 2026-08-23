class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        Arrays.fill(word, '\0');
        char nextChar = 'a';
        
        // Step 1: Greedily assign letters based on lcp > 0 grouping
        for (int i = 0; i < n; i++) {
            if (word[i] == '\0') {
                if (nextChar > 'z') return ""; // more than 26 groups needed - impossible
                word[i] = nextChar;
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = nextChar;
                    }
                }
                nextChar++;
            }
        }
        
        // Step 1.5: Sanity check - lcp[i][j] > 0 must mean same char, == 0 must mean different char
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean sameChar = word[i] == word[j];
                boolean positiveLcp = lcp[i][j] > 0;
                if (sameChar != positiveLcp) return "";
            }
        }
        
        // Step 2: Recompute the actual LCP matrix from constructed word via DP, verify match
        int[][] realLcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    realLcp[i][j] = realLcp[i + 1][j + 1] + 1;
                } else {
                    realLcp[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (realLcp[i][j] != lcp[i][j]) return "";
            }
        }
        
        return new String(word);
    }
}