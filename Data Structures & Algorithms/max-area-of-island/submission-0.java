class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                max = Math.max(max, dfs(grid, row, col));
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
            || grid[row][col] == 0) {
            return 0;
        }

        // grid[row][col] == 1
        grid[row][col] = 0;
        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) +
               dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}
