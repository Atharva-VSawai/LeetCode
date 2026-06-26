
// Define the solution class required by LeetCode.
class Solution {

// Implement the Sudoku validation method.
    public boolean isValidSudoku(char[][] board) {

// Track seen digits for each row.
        boolean[][] rows = new boolean[9][9];

// Track seen digits for each column.
        boolean[][] cols = new boolean[9][9];

// Track seen digits for each 3x3 box.
        boolean[][] boxes = new boolean[9][9];

// Traverse every cell in the board.
        for (int r = 0; r < 9; r++) {

// Traverse every column for the current row.
            for (int c = 0; c < 9; c++) {

// Read the current cell value.
                char ch = board[r][c];

// Skip empty cells.
                if (ch == '.') {
                    continue;
                }

// Convert digit character '1' to '9' into index 0 to 8.
                int num = ch - '1';

// Compute box index based on row and column.
                int box = (r / 3) * 3 + (c / 3);

// If already seen in row, column, or box, board is invalid.
                if (rows[r][num] || cols[c][num] || boxes[box][num]) {
                    return false;
                }

// Mark digit as seen in the current row.
                rows[r][num] = true;

// Mark digit as seen in the current column.
                cols[c][num] = true;

// Mark digit as seen in the current 3x3 box.
                boxes[box][num] = true;
            }
        }

// If no conflicts were found, the board is valid.
        return true;
    }
}