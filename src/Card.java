public class Card {
    private int[][] numbers;
    private boolean[][] checked;

    public Card(CardsGenerator generator) {
        numbers = new int[3][5];
        checked = new boolean[3][5];

        for (int row = 0; row < numbers.length; row++) {
            numbers[row] = generator.getNumbersInRow();
        }

        for (int row = 0; row < checked.length; row++) {
            for (int col = 0; col < checked[0].length; col++) {
                checked[row][col] = false;
            }
        }
    }

    public void markNumber(int n) {
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[0].length; col++) {
                if (numbers[row][col] == n) {
                    checked[row][col] = true;
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[0].length; col++) {
                
            }
        }
        return s;
    }
}
