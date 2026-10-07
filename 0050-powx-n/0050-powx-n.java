class Solution {
    public double myPow(double x, int n) {
        long e = Math.abs((long) n);
        double res = 1;

        while (e > 0) {
            if ((e & 1) == 1) res *= x;
            x *= x;
            e >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }
}