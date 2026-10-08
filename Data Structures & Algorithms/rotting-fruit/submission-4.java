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

                // Up
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    fresh--;
                    bfs.add(new int[]{row - 1, col});
                }

                // Down
                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    fresh--;
                    bfs.add(new int[]{row + 1, col});
                }

                // Left
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    fresh--;
                    bfs.add(new int[]{row, col - 1});
                }

                // Right
                if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    fresh--;
                    bfs.add(new int[]{row, col + 1});
                }
            }

            minutes++;
        }

        if (fresh == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}