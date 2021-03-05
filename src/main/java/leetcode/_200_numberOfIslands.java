package leetcode;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class _200_numberOfIslands {
    /**
     * Intuition: Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'.
     * Algorithm: Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
     * During DFS, every visited node should be set as '0' to mark as visited node. Count the number of root nodes that trigger DFS,
     * this number would be the number of islands since each DFS starting at some root identifies an island.
     */

    /**
     * Time complexity : O(M×N) where MM is the number of rows and NN is the number of columns.
     * Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
     */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numsfIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numsfIsland += dfs(grid, i, j);
                }
            }
        }

        return numsfIsland;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        return 1;
    }
}
