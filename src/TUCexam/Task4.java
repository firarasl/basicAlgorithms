package TUCexam;

public class Task4 {

    public static boolean numberCheck(int number){
        int helper= number;
        int helperRemain= number;

        int sum = 0;

        while(helper !=0){
            helperRemain = helper%10;
            sum += helperRemain*helperRemain*helperRemain;
            helper = helper/10;
        }

        if (sum== number){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
//    i had to make numbercheck static to test it
        System.out.println(numberCheck(153));
        System.out.println(numberCheck(120));
        System.out.println(numberCheck(371));
    }
}
