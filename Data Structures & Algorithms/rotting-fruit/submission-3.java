class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int minutes = 0;
        int fresh = 0;

        // Gather rotten oranges and count fresh oranges
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    bfs.add(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        while (!bfs.isEmpty() && fresh > 0) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                int[] curr = bfs.remove();
                int row = curr[0];
                int col = curr[1];

                fresh -= checkAround(grid, row, col, bfs);
            }

            minutes++;
        }

        // If fresh oranges remain, they could not be reached
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }

    private int checkAround(int[][] grid, int row, int col, Queue<int[]> bfs) {
        int rotted = 0;

        // Up
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            bfs.add(new int[]{row - 1, col});
            rotted++;
        }

        // Down
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            bfs.add(new int[]{row + 1, col});
            rotted++;
        }

        // Left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            bfs.add(new int[]{row, col - 1});
            rotted++;
        }

        // Right
        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            bfs.add(new int[]{row, col + 1});
            rotted++;
        }

        return rotted;
    }
}