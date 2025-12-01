class Solution(object):
    def isPalindrome(self, x):
        # negative numbers are NOT palindrome
        # numbers ending with 0 are NOT palindrome (except 0)
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        rev = 0
        while x > rev:
            rev = rev * 10 + x % 10
            x //= 10
        
        # For odd digit numbers, rev//10 removes the middle digit
        return x == rev or x == rev // 10
