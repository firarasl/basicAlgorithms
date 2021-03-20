package assignment8;

public class Deck {
    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private Card[][] cards;

    public Deck() {
        cards = new Card[numSuits][numRanks];
        for (int suit = Suit.DIAMONDS.getValue(); suit <= Suit.SPADES.getValue(); suit++) {
            for (int rank = Rank.ACE.getValue(); rank <= Rank.KING.getValue(); rank++) {
                cards[suit-1][rank-1] = new Card(rank, suit);
            }
        }
    }

    public Card getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
}