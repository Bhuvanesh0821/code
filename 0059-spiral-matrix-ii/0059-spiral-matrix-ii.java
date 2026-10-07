class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bot = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bot && left <= right) {
            for (int j = left; j <= right; j++) res[top][j] = num++;
            top++;

            for (int i = top; i <= bot; i++) res[i][right] = num++;
            right--;

            if (top <= bot) {
                for (int j = right; j >= left; j--) res[bot][j] = num++;
                bot--;
            }

            if (left <= right) {
                for (int i = bot; i >= top; i--) res[i][left] = num++;
                left++;
            }
        }
        return res;
    }
}