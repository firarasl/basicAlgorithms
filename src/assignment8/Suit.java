package assignment8;

public enum Suit {
    DIAMONDS(1), CLUBS(2), HEARTS(3), SPADES(4);
    public final int value;


    Suit(int value) {
        this.value= value;
    }

    public int getValue() {
        return value;
    }

    public static Suit findByValue(int value){
        for(Suit suit : values()){
            if( suit.getValue() == value){
                return suit;
            }
        }
        return null;
    }

}
