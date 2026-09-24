class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;

        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];

        boolean[][] atlantic = new boolean[rows][cols];

        for(int row = 0; row < rows; row ++){

            dfs(heights, row, 0, pacific);

            dfs(heights, row, cols - 1, atlantic);
        }

        for(int col = 0; col < cols; col++){

            dfs(heights, 0, col, pacific);

            dfs(heights, rows - 1, col, atlantic);

        }

        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0; row < rows; row ++){

            for( int col = 0; col < cols; col++){

                if(pacific[row][col] && atlantic[row][col]){

                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
        
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited){

        int rows = heights.length;

        int cols = heights[0].length;

        if( row < 0 || row >= rows || col <0 || col >= cols || visited[row][col]){

            return;
        }

        visited[row][col] = true;

        int[][] directions = { 
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        for( int[] direction : directions) {
            
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols){

                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]){

                continue;
            }
            
            dfs(heights, newRow, newCol, visited);

        }

    }
}
