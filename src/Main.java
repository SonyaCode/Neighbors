import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Grid grid = new Grid();
        int boxesFilled = 0;
        System.out.println(grid);

        while (boxesFilled < 25) {
            int dice = grid.roll();
            System.out.println("You rolled a 10-sided dice. Dice: " + dice);
            System.out.print("Where do you want to put the number " + dice + " at (row, column)? ");
            String input = scan.nextLine();

            int row = convertRowToInt(input);
            int column = convertColToInt(input);


            while (!grid.isEmpty(row, column)) {
                System.out.println("This space is already occupied.");
                System.out.print("Where do you want to put the number " + dice + " at (row, column)? ");
                input = scan.nextLine();
                row = convertRowToInt(input);
                column = convertColToInt(input);

            }
            if (grid.isEmpty(row, column)) {
                grid.addNum(dice, row, column);
                boxesFilled++;
            }

            System.out.println(grid);

        }

        System.out.println("Your total score: " + grid.calculateScore());
    }

    public static int convertRowToInt(String row) {
        String rowInStr = row.substring(0, row.indexOf(","));
        return Integer.parseInt(rowInStr);
    }

    public static int convertColToInt(String column) {
        String colInStr = column.substring(column.indexOf(",") + 2);
        return Integer.parseInt(colInStr);
    }
}