class Solution(object):
    def twoSum(self, nums, target):
        seen = {}  # value -> index

        for i, num in enumerate(nums):
            remaining = target - num
            if remaining in seen:
                return [seen[remaining], i]  # found the pair
            seen[num] = i  # store number's index
        
        # problem guarantees exactly one answer, so no need for extra return
