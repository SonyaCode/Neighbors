public class Grid {
    private int[][] grid;


    public Grid() {
        grid = new int[5][5];
    }

    public int roll() {
        return (int) (Math.random() * 10) + 1;
    }

    public boolean isEmpty(int row, int col) {
        if (grid[row][col] != 0) {
            return false;
        }
        return true;
    }

    public void addNum(int num, int row, int col) {
        grid[row][col] = num;
    }

    public int calculateScore() {
        int score = 0;
        int consecutiveCount = 1;

        // horizontal
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 1; col++) {
                if (grid[row][col] == grid[row][col + 1]) {
                    consecutiveCount++;
                } else if (consecutiveCount > 1) {
                    score += consecutiveCount * grid[row][col];
                    consecutiveCount = 1;
                }
            }
            if (consecutiveCount > 1) {
                score += consecutiveCount * grid[row][grid.length - 1];
                consecutiveCount = 1;
            }
        }


        // vertical
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length - 1; row++) {
                if (grid[row][col] == grid[row + 1][col]) {
                    consecutiveCount++;
                } else if (consecutiveCount > 1) {
                    score += consecutiveCount * grid[row][col];
                    consecutiveCount = 1;
                }
            }

            if (consecutiveCount > 1) {
                score += consecutiveCount * grid[grid.length - 1][col];
                consecutiveCount = 1;
            }
        }

        return score;
    }

    public String toString() {
        String gridForm = "    0 1 2 3 4\n   ----------\n";

        for (int row = 0; row < grid.length; row++) {
            gridForm += row + " | ";
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    gridForm += "_ ";
                } else {
                    gridForm += grid[row][col] + " ";
                }

            }

            gridForm += "\n";
        }

        return gridForm;
    }




}


