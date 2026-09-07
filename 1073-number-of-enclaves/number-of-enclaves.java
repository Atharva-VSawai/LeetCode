import java.util.*;

class Solution {
    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add boundary land to queue
        for(int i = 0; i < rows; i++) {

            if(grid[i][0] == 1) {
                q.add(new int[]{i, 0});
                grid[i][0] = 0;
            }

            if(grid[i][cols - 1] == 1) {
                q.add(new int[]{i, cols - 1});
                grid[i][cols - 1] = 0;
            }
        }

        for(int j = 0; j < cols; j++) {

            if(grid[0][j] == 1) {
                q.add(new int[]{0, j});
                grid[0][j] = 0;
            }

            if(grid[rows - 1][j] == 1) {
                q.add(new int[]{rows - 1, j});
                grid[rows - 1][j] = 0;
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // BFS
        while(!q.isEmpty()) {

            int[] curr = q.poll();

            for(int[] dir : directions) {

                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if(newRow >= 0 && newRow < rows &&
                   newCol >= 0 && newCol < cols &&
                   grid[newRow][newCol] == 1) {

                    grid[newRow][newCol] = 0;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        // Count remaining land
        int count = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}