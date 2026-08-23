class Solution {
    public boolean canBeEqual(String s1, String s2) {
        boolean group1 = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2))
                       || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));
        
        boolean group2 = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3))
                       || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
        
        return group1 && group2;
    }
}