class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int res = 0, cur = 0;
        for (int[] t : tasks) {
            if (cur < t[1]) {
                res += t[1] - cur;
                cur = t[1];
            }
            cur -= t[0];
        }
        return res;
    }
}