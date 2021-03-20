package mockexam.task3;

public class Ballot {

    Vote vote;
    Ballot next;

    Ballot(Vote vote) {
        this.vote = vote;
        this.next = null;
    }

    public String toString() {
        return " [" + this.vote + "] ";
    }
}
