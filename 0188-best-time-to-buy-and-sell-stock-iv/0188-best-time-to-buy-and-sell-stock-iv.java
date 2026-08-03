class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // Edge case: if k >= n/2, it's unlimited transactions (Stock II)
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] hold = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(hold, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int t = 1; t <= k; t++) {
                hold[t] = Math.max(hold[t], sell[t - 1] - price);
                sell[t] = Math.max(sell[t], hold[t] + price);
            }
        }

        return sell[k];
    }
}