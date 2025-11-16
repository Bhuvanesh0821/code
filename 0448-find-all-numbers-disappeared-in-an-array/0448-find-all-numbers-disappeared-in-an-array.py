class Solution(object):
    def findDisappearedNumbers(self, nums):
        for i in range(len(nums)):
            index = abs(nums[i]) - 1     # find the index corresponding to the value
            if nums[index] > 0:
                nums[index] *= -1        # mark that the number (index+1) exists

        missing = []
        for i in range(len(nums)):
            if nums[i] > 0:              # positive means index+1 never appeared
                missing.append(i + 1)

        return missing
  