import java.util.ArrayList;
import java.util.List;

/**
 * 采用标记数组记得控制好方向，自己写的很繁琐
 */
public class Q54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int maxRow = matrix.length - 1;
        int maxColumn = matrix[0].length - 1;
        boolean[][] flags = new boolean[maxRow + 1][maxColumn + 1];
        List<Integer> list = new ArrayList<>();
        int direction = 0; // 0 右，1 下，2 左，3 上
        int row = 0;
        int column = 0;
        while (true) {
            if (row > maxRow || row < 0 || column > maxColumn || column < 0 || flags[row][column]) {
                break;
            } else {
                list.add(matrix[row][column]);
                flags[row][column] = true;
            }
            switch (direction) {
                case 0: {
                    column++;
                    if (column > maxColumn || flags[row][column]) {
                        direction = 1;
                        column--;
                        row++;
                    }
                    break;
                }
                case 1: {
                    row++;
                    if (row > maxRow || flags[row][column]) {
                        direction = 2;
                        row--;
                        column--;
                    }
                    break;
                }
                case 2: {
                    column--;
                    if (column < 0 || flags[row][column]) {
                        direction = 3;
                        column++;
                        row--;
                    }
                    break;
                }
                case 3: {
                    row--;
                    if (row < 0 || flags[row][column]) {
                        direction = 0;
                        row++;
                        column++;
                    }
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Q54().spiralOrder(new int[][]{{1}}));
    }
}
