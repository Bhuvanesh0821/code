class Solution(object):
    def smallestRepunitDivByK(self, k):
        # If k has factor 2 or 5 → impossible
        if k % 2 == 0 or k % 5 == 0:
            return -1
        
        rem = 0
        for length in range(1, k + 1):
            rem = (rem * 10 + 1) % k
            if rem == 0:
                return length
        
        return -1
