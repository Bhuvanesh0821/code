class Solution(object):
    def minOperations(self, nums, k):
        s = sum(nums)
        rem = s % k
        return rem  # minimum ops required
   