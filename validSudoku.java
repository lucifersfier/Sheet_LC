/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */

class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Sets for rows, columns, and 3x3 boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue; // skip empty cells

                int boxIndex = (r / 3) * 3 + (c / 3);

                // check row
                if (rows[r].contains(val)) return false;
                rows[r].add(val);

                // check column
                if (cols[c].contains(val)) return false;
                cols[c].add(val);

                // check box
                if (boxes[boxIndex].contains(val)) return false;
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}




/*
Uses 3 arrays of HashSet<Character>:

rows[i] → digits in row i

cols[j] → digits in column j

boxes[k] → digits in 3×3 sub-box (index k = (r/3)*3 + (c/3)).

Iterates over all cells. For each filled digit:

If it’s already in the corresponding row/col/box → invalid.

Otherwise, add it and continue.

If no conflicts are found, the board is valid.
 */