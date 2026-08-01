class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // max contribution from left/right subtree — ignore if negative
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // best path THROUGH this node (can use both children) — candidate for global answer
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);

        // return value: max path a PARENT can extend upward (only one branch allowed)
        return node.val + Math.max(leftGain, rightGain);
    }
}