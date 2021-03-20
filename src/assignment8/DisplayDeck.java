package assignment8;

public class DisplayDeck {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (int suit = Suit.DIAMONDS.getValue(); suit <=  Suit.SPADES.getValue(); suit++) {
            for (int rank = Rank.ACE.getValue(); rank <= Rank.KING.getValue(); rank++) {
                Card card = deck.getCard(suit, rank);
                System.out.format("%s of %s%n",
                        Card.rankToString(card.getRank()),
                        Card.suitToString(card.getSuit()));
            }
        }
    }
}
