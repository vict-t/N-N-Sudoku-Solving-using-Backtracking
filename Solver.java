public interface Solver {
    
    /**
     * Solve the sudoku puzzle by filling in all numbers without conflict.
     * @return a deep copy of the solved puzzle; or null if it cannot be solved.
     */
    public int[][] solve();
    
    /**
     * Store a deep copy of the given sudoku puzzle.
     * @param puzzle the givens or clues of the sudoku puzzle.
     */
    public void setPuzzle(int[][] puzzle);
    
    /**
     * @return a deep copy of the sudoku puzzle of its current state. 
     */
    public int[][] getPuzzle();
    
}
