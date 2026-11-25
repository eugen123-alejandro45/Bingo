public class Game {
    private Card[] cards;
    private Drum drum;

    public Game(int numCards) {
        drum = new Drum(1, 90);
        cards = new Card[numCards];
        CardsGenerator generator = new CardsGenerator();
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(generator);
        }
    }

    public void playForLine() {
        boolean isLine = false;
        while (!isLine) {
            int n = drum.extractBall();
            for (int i = 0; i < cards.length; i++) {
                cards[i].markNumber(n);
                if (cards[i].isLine()) {
                    isLine = true;
                    System.out.println("LINE COMPLETED by card N." + (i + 1));
                    System.out.println(cards[i]);
                }
            }
        }
    }

    public void playForBingo () {
        boolean isBingo = false;
        while (!isBingo) {
            int n = drum.extractBall();
            for (int i = 0; i < cards.length; i++) {
                cards[i].markNumber(n);
                if (cards[i].isBingo()) {
                    isBingo = true;
                    System.out.println("BINGO by card n." + (i + 1) + ":");
                    System.out.println(cards[i]);
                }
            }
        }
    }

    public void printExtractedNumbers() {
        boolean[] marked = new boolean[91];
        for (int i = 0; i < cards.length; i++) {
            int[] numbers = cards[i].getMarketNumbers();
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] != 0) {
                    marked[numbers[j]] = true;
                }
            }
        }
        System.out.println("Extracted numbers: ");
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public void play() {
        playForLine();
        playForBingo();
        printExtractedNumbers();
    }
}
