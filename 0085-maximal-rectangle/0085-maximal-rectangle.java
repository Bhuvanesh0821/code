class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        
        for (char[] row : matrix) {
            // update histogram heights for this row
            for (int j = 0; j < cols; j++) {
                heights[j] = (row[j] == '0') ? 0 : heights[j] + 1;
            }
            // run largest rectangle in histogram on updated heights
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}