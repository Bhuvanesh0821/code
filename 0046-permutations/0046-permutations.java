class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // snapshot, since current keeps changing
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already-placed numbers
            
            used[i] = true;
            current.add(nums[i]);
            
            backtrack(nums, current, used, result); // recurse to fill next position
            
            current.remove(current.size() - 1); // backtrack: undo choice
            used[i] = false;
        }
    }
}