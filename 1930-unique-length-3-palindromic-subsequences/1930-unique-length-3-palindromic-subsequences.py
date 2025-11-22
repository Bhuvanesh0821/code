class Solution(object):
    def countPalindromicSubsequence(self, s):
        res = 0
        for c in set(s):
            first = s.find(c)
            last = s.rfind(c)
            if first < last:
                mid = set(s[first+1:last])
                res += len(mid)
        return res
    