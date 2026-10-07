class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;

            while (j < s.length()) {
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k++;
                sb.append(k - j).append(s.charAt(j));
                j = k;
            }
            s = sb.toString();
        }
        return s;
    }
}