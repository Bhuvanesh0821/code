class Solution {
    public boolean isNumber(String s) {
        String pattern = "^[+-]?([0-9]+\\.?[0-9]*|\\.[0-9]+)([eE][+-]?[0-9]+)?$";
        return s.matches(pattern);
    }
}