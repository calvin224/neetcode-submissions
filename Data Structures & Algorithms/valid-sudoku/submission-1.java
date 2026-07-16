class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Sets to keep track of seen numbers
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> columns = new HashSet<>();
        HashSet<Character> boxes = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            rows.clear();
            for (int c = 0; c < 9; c++) {
                char cell = board[r][c];
                if (cell != '.') {
                    if (!rows.add(cell)) {
                        return false; // Duplicate in row
                    }
                }
            }
        }

        for (int c = 0; c < 9; c++) {
            columns.clear();
            for (int r = 0; r < 9; r++) {
                char cell = board[r][c];
                if (cell != '.') {
                    if (!columns.add(cell)) {
                        return false; // Duplicate in column
                    }
                }
            }
        }

        for (int box = 0; box < 9; box++) {
            boxes.clear();
            int rowStart = (box / 3) * 3;
            int colStart = (box % 3) * 3;
            for (int r = rowStart; r < rowStart + 3; r++) {
                for (int c = colStart; c < colStart + 3; c++) {
                    char cell = board[r][c];
                    if (cell != '.') {
                        if (!boxes.add(cell)) {
                            return false; // Duplicate in 3x3 box
                        }
                    }
                }
            }
        }

        return true; // All checks passed
    }
}

