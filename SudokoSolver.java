public class SudokoSolver implements Solver {

    private int[][] puzzle;

    public int[][] solve() {
        int[][] board = getPuzzle();
        
        if (solve(board)) {
            return board;
        } else {
            return null;
        }

    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = new int[puzzle.length][puzzle.length];
        for (int i = 0; i < (puzzle.length); i++) {
            for (int j = 0; j < (puzzle.length); j++) {
                this.puzzle[i][j] = puzzle[i][j];
            }
        }
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

   public static boolean isColVaild(int[][] solver, int col, int a) {

        for (int i = 0; i < solver.length; i++) {
            if (solver[i][col] == a) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRowVaild(int[][] solver, int row, int a) {
        
        for (int i = 0; i < solver.length; i++) {
            if (solver[row][i] == a) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBoxVaild(int[][] solver, int row, int col, int a) {
        int boxSize = (int)Math.sqrt(solver.length);
        int boxRow = row - row % boxSize;
        int boxCol = col - col % boxSize;

        for (int c = boxRow; c < boxRow + boxSize; c++) {
            for (int d = boxCol; d < boxCol + boxSize; d++) {
                if (solver[c][d] == a) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isVaild(int[][] solver, int row, int col, int number) {
        return isRowVaild(solver, row, number) && isColVaild(solver, col, number) && isBoxVaild(solver, row, col, number);
    }
    


    public static boolean solve(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }
        //reclusion and backtracking
        for (int num = 1; num <= board.length; num++) {
            if (isVaild(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
}
