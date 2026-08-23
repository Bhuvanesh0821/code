class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        int sum1 = 0, sum2 = 0, cnt1 = 0, cnt2 = 0;
        
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') cnt1++;
            else sum1 += c - '0';
        }
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') cnt2++;
            else sum2 += c - '0';
        }
        
        int totalQ = cnt1 + cnt2;
        if (totalQ % 2 == 1) return true; // Alice always wins
        
        int diff = sum1 - sum2;
        diff += 9 * (cnt1 - cnt2) / 2;
        return diff != 0; // Alice wins unless Bob can force diff to 0
    }
}