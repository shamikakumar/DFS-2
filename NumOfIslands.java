// Approach 1: BFS
// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We traverse the matrix and when we find a '1', we start a BFS on that node
// We need to mark visited nodes. We can set to '0' once visited
// We also keep track of a count var whenever we encounter a 1 while traversing

class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public int numIslands(char[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int count = 0;
        for(int i=0;i<n;i++)  
        {
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1')
                {
                    count++;
                    grid[i][j] = '0';
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir:dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr>=0 && nr<n && nc>=0 && 
                            nc<m && grid[nr][nc]=='1')
                            {
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }  
        return count;
    }
}

// Approach 2: DFS
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We traverse the matrix and when we find a '1', we start a DFS on that node
// We need to mark visited nodes. We can set to '0' once visited
// We also keep track of a count var whenever we encounter a 1 while traversing

class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private void dfs(char[][] grid, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        for(int[] dir:dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc, m, n);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int count = 0;
        for(int i=0;i<n;i++)  
        {
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }  
        return count;
    }
}