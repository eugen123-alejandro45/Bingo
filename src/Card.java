import javax.swing.plaf.IconUIResource;

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

    public boolean isLine() {
        for (int row = 0; row < checked.length; row++) {
            boolean line = true;
            for (int col = 0; col < checked[0].length; col++) {
                if (!checked[row][col]) {
                    line = false;
                    break;
                }
            }
            if (line) {
                return true;
            }
        }
        return false;
    }

    public boolean isBingo() {
        for (int row = 0; row < checked.length; row++) {
            for (int col = 0; col < checked[0].length; col++) {
                if (checked[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBingo2() {
        for (int line = 0; line < checked.length; line++) {
            if (!isLine()) {
                return false;
            }
        }
        return true;
    }

    public int[] getMarketNumbers() {
       int[] markedNumbers = new int[15];
        for (int i = 0; i < markedNumbers.length; i++) {
            markedNumbers[i] = 0;
        }
        int counter = 0;
        for (int row = 0; row < checked.length; row++) {
            for (int col = 0; col < checked[0].length; col++) {
                if (checked[row][col]) {
                    markedNumbers[counter] = numbers[row][col];
                    counter++;
                }
            }
        }
        return markedNumbers;
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < numbers.length; row++) {
            boolean first = true;
            for (int col = 0; col < numbers[0].length; col++) {
                if (first) {
                    first = false;
                } else {
                    s += ", ";
                }
                if (checked[row][col]) {
                    s += "[" + numbers[row][col] + "]";
                } else {
                    s += numbers[row][col] + "";
                }
            }
            s += "\n";
        }
        return s;
    }
}
