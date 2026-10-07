class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            cur.add(c[i]);
            dfs(c, rem - c[i], i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}