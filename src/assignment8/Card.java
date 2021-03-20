package assignment8;

public class Card {
    private final Rank rank;
    private final Suit suit;


    public Card(int rank, int suit) {
        assert isValidRank(rank);
        assert isValidSuit(suit);

        this.rank = Rank.findByValue(rank);
        this.suit = Suit.findByValue(suit);
    }

    public int getSuit() {
        return suit.getValue();
    }

    public int getRank() {
        return rank.getValue();
    }

    public static boolean isValidRank(int rank) {
        return Rank.ACE.getValue() <= rank && rank <= Rank.KING.getValue();
    }

    public static boolean isValidSuit(int suit) {
        return Suit.DIAMONDS.getValue() <= suit && suit <= Suit.SPADES.getValue();
    }

    public static String rankToString(int rank) {
//        converting enum from uppercase to capitalized
        String rankString = Rank.findByValue(rank).toString();
        return rankString.substring(0,1).toUpperCase() + rankString.substring(1).toLowerCase();

    }

    public static String suitToString(int suit) {
        String suitString = Suit.findByValue(suit).toString();
        return suitString.substring(0,1).toUpperCase() + suitString.substring(1).toLowerCase();
    }

    public static void main(String[] args) {

        // using Intellij, added -ea in VM line inside configuration
        assert rankToString(Rank.ACE.getValue()).equals( "Ace");
        assert rankToString(Rank.DEUCE.getValue() ).equals("Deuce") ;
        assert rankToString(Rank.THREE.getValue() ).equals("Three");
        assert rankToString(Rank.FOUR.getValue() ).equals("Four");
        assert rankToString(Rank.FIVE.getValue() ).equals("Five");
        assert rankToString(Rank.SIX.getValue() ).equals("Six");
        assert rankToString(Rank.SEVEN.getValue() ).equals("Seven") ;
        assert rankToString(Rank.EIGHT.getValue() ).equals("Eight");
        assert rankToString(Rank.NINE.getValue() ).equals("Nine");
        assert rankToString(Rank.TEN.getValue() ).equals("Ten");
        assert rankToString(Rank.JACK.getValue() ).equals("Jack");
        assert rankToString(Rank.QUEEN.getValue() ).equals("Queen") ;
        assert rankToString(Rank.KING.getValue() ).equals("King");

        assert suitToString(Suit.DIAMONDS.getValue()).equals("Diamonds") ;
        assert suitToString(Suit.CLUBS.getValue()).equals("Clubs") ;
        assert suitToString(Suit.HEARTS.getValue()).equals("Hearts") ;
        assert suitToString(Suit.SPADES.getValue()).equals("Spades");

    }
}
