public class Q37 {

    public void solveSudoku(char[][] board) {
        recursion(board, 0, -1);
    }

    /**
     * 确定一个位置的元素
     */
    public boolean recursion(char[][] board, int row, int column) {
        if (row == 8 && column == 8) {
            return true;
        }
        if (column == 8) {
            row++;
            column = 0;
        } else {
            column++;
        }
        if (board[row][column] != '.') {
            return recursion(board, row, column);
        } else {
            for (char c = '1'; c <= '9'; c++) {
                if (isLegal(board, row, column, c)) {
                    board[row][column] = c;
                    boolean result = recursion(board, row, column);
                    if (result) {
                        return true;
                    } else {
                        board[row][column] = '.';
                    }
                }
            }
        }
        return false;
    }

    private boolean isLegal(char[][] board, int row, int column, int number) {
        // 检查垂直
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == number) {
                return false;
            }
        }
        // 检查水平
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        // 检查方格
        int x = row / 3 * 3; // 起始行号
        int y = column / 3 * 3; // 起始列号
        while (x < row / 3 * 3 + 2 || y < column / 3 * 3 + 2) { // 遍历前面元素
            if (board[x][y] == number) {
                return false;
            }
            y++;
            if (y == column / 3 * 3 + 3) {
                y = column / 3 * 3;
                x++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new Q37().recursion(board, 0, 0));
    }
}
