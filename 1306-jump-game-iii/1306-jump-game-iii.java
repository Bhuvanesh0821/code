class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] seen = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        seen[start] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) return true;
            int a = i + arr[i], b = i - arr[i];
            if (a < n && !seen[a]) { seen[a] = true; q.add(a); }
            if (b >= 0 && !seen[b]) { seen[b] = true; q.add(b); }
        }
        return false;
    }
}