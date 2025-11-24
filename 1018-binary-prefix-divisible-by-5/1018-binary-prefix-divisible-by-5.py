class Solution(object):
    def prefixesDivBy5(self, nums):
        ans = []
        curr = 0  # will store x % 5
        
        for bit in nums:
            curr = (curr * 2 + bit) % 5
            ans.append(curr == 0)
        
        return ans
