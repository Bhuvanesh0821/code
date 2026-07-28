class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // group duplicates together
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            // skip duplicate: if same value as previous AND previous wasn't used
            // (means we're about to repeat a choice already explored at this level)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            current.add(nums[i]);
            
            backtrack(nums, current, used, result);
            
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}