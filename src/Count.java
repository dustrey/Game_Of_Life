public class Count
{
    //check for live cells and update counter
    public int neighborCount (char[][] grid, int i, int j) {
        int neighborCounter = 0;
        for (int row = i - 1; row <= i + 1; row++) {
            for (int col = j - 1; col <= j + 1; col++) {
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                    if (grid[row][col] == 'X')
                        neighborCounter++;
                }
            }
        }
        if (grid[i][j] == 'X')
            neighborCounter--;
        return neighborCounter;
    }
}
