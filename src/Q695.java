/**
 * DFS 获取到所有岛屿的面积取最大值，
 * 主要逻辑是遍历过的地方标志要置为 0，防止重复遍历
 */
public class Q695 {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, getArea(i, j, grid));
            }
        }
        return maxArea;
    }

    public int getArea(int row, int column, int[][] grid) {
        if (row < 0 || row >= grid.length) {
            return 0;
        }
        if (column < 0 || column >= grid[row].length) {
            return 0;
        }
        if (grid[row][column] == 0) {
            return 0;
        }
        grid[row][column] = 0;
        return 1 + getArea(row, column - 1, grid) +
                getArea(row - 1, column, grid) +
                getArea(row, column + 1, grid) +
                getArea(row + 1, column, grid);
    }

    public static void main(String[] args) {
        int[][] data = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(new Q695().maxAreaOfIsland(data));
    }
}
