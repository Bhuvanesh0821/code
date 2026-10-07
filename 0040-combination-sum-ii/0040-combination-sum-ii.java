class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] c, int rem, int start, List<Integer> cur, List<List<Integer>> res) {
        if (rem == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < c.length && c[i] <= rem; i++) {
            if (i > start && c[i] == c[i - 1]) continue;
            cur.add(c[i]);
            dfs(c, rem - c[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}