class Solution {
    public int orangesRotting(int[][] grid) {
        int count=0;
        boolean changed=true;
        while(changed){
            changed = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    if(i+1 < grid.length && grid[i+1][j]==1){
                       grid[i+1][j]=3;
                       changed=true;
                    }
                    if(j+1<grid[0].length && grid[i][j+1]==1){
                         grid[i][j+1]=3;
                         changed=true;
                    }
                    if(i-1 >= 0 && grid[i-1][j]==1){
                         grid[i-1][j]=3;
                         changed=true;
                    }
                    if(j-1 >= 0 && grid[i][j-1]==1){
                         grid[i][j-1]=3;
                         changed=true;
                    }
                }
            }
        }
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == 3){
                        grid[i][j] = 2;
                    }
                }
            }

            if(changed) count++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return count;
    }
}