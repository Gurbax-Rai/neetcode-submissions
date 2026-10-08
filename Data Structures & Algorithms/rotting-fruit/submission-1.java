class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int minutes = 0;

        // Gather rotten oranges
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    bfs.add(new int[]{row, col});
                }
            }
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                int[] curr = bfs.remove();
                int row = curr[0];
                int col = curr[1];

                checkAround(grid, row, col, bfs);
            }

            minutes++;
        }

        // Check for fresh oranges
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(0, minutes - 1);
    }

    private void checkAround(int[][] grid, int row, int col, Queue<int[]> bfs) {
        // Up
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            bfs.add(new int[]{row - 1, col});
        }

        // Down
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            bfs.add(new int[]{row + 1, col});
        }

        // Left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            bfs.add(new int[]{row, col - 1});
        }

        // Right
        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            bfs.add(new int[]{row, col + 1});
        }
    }
}
