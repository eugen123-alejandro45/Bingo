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
                isBingo = true;
                System.out.println("");
                System.out.println("");
                System.out.println(cards[i]);

            }
        }
    }
}
