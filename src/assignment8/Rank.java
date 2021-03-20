package assignment8;

public enum Rank {
//    using uppercase because constants r usually uppercase
    ACE(1), DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    public final int value;


    Rank(int value) {
        this.value= value;
    }


    public int getValue() {
        return value;
    }
    public static Rank findByValue(int value){
        for(Rank rank : values()){
            if( rank.getValue() == value){
                return rank;
            }
        }
        return null;
    }


}
