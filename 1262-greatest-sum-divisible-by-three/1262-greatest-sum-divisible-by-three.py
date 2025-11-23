class Solution(object):
    def maxSumDivThree(self, nums):
        dp = [0, float('-inf'), float('-inf')]
        for x in nums:
            r = x % 3
            a, b, c = dp  # old values
            dp[(0 + r) % 3] = max(dp[(0 + r) % 3], a + x)
            dp[(1 + r) % 3] = max(dp[(1 + r) % 3], b + x)
            dp[(2 + r) % 3] = max(dp[(2 + r) % 3], c + x)
        return dp[0]
 