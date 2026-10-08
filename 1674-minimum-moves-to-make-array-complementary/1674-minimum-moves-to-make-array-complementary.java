class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] d = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            int lo = Math.min(a, b), hi = Math.max(a, b);
            d[2] += 2;
            d[lo + 1] -= 1;
            d[a + b] -= 1;
            d[a + b + 1] += 1;
            d[hi + limit + 1] += 1;
        }
        int res = n, cur = 0;
        for (int t = 2; t <= 2 * limit; t++) {
            cur += d[t];
            res = Math.min(res, cur);
        }
        return res;
    }
}