class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();

        for (String p : path.split("/")) {
            if (p.isEmpty() || p.equals(".")) continue;
            if (p.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(p);
            }
        }

        if (st.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append("/").append(st.pollLast());
        return sb.toString();
    }
}