
class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] boxes = new int[9];
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int bit = 1 << (board[r][c] - '1');
                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[boxIndex(r, c)] |= bit;
                }
            }
        }

        solve();
    }

    private boolean solve() {
        int bestR = -1;
        int bestC = -1;
        int bestMask = 0;
        int minChoices = 10;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    int used = rows[r] | cols[c] | boxes[boxIndex(r, c)];
                    int mask = (~used) & 0x1FF;
                    int choices = Integer.bitCount(mask);

                    if (choices == 0) return false;

                    if (choices < minChoices) {
                        minChoices = choices;
                        bestR = r;
                        bestC = c;
                        bestMask = mask;

                        if (choices == 1) break;
                    }
                }
            }
            if (minChoices == 1) break;
        }

        if (bestR == -1) return true;

        int box = boxIndex(bestR, bestC);

        while (bestMask != 0) {
            int bit = bestMask & -bestMask;
            int digit = Integer.numberOfTrailingZeros(bit);

            board[bestR][bestC] = (char) ('1' + digit);
            rows[bestR] |= bit;
            cols[bestC] |= bit;
            boxes[box] |= bit;

            if (solve()) return true;

            rows[bestR] ^= bit;
            cols[bestC] ^= bit;
            boxes[box] ^= bit;
            board[bestR][bestC] = '.';

            bestMask &= bestMask - 1;
        }

        return false;
    }

    private int boxIndex(int r, int c) {
        return (r / 3) * 3 + c / 3;
    }
}
