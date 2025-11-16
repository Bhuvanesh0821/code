class Solution(object):
    def makeLargestSpecial(self, s):
        def helper(t):
            count = 0
            start = 0
            parts = []

            for i, ch in enumerate(t):
                count += 1 if ch == '1' else -1

                # Found a complete special substring
                if count == 0:
                    # Recurse on inside part
                    inner = helper(t[start + 1 : i])
                    parts.append("1" + inner + "0")
                    start = i + 1

            # Sort to get lexicographically largest arrangement
            parts.sort(reverse=True)
            return "".join(parts)

        return helper(s)
