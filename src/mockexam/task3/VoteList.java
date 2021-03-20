package mockexam.task3;

public class VoteList {
    //    String member;
    Ballot front;
    Ballot rear;

    public VoteList() {
        front = null;
    }

    public VoteList importVotes(Vote[] votes) {
        VoteList voteList = new VoteList();
        for (int i = 0; i < votes.length; i++) {
            if (i == 0) {
//                first add
                Ballot ballotNode = new Ballot(votes[i]);
                ballotNode.next = front;
                front = ballotNode;
            } else {
//                add at the end
                Ballot ballotNode = new Ballot(votes[i]);
//                YES -> NO -> UNDECIDED
                if (front.vote == Vote.YES) {
//                    add at first
                    ballotNode.next = front;
                    front = ballotNode;
                } else if (front.vote == ballotNode.vote) {
//                        if current node is equal to the upcoming node then add at the end
                    front.next = ballotNode;
                } else if ((front.vote == Vote.NO && ballotNode.vote == Vote.YES) ||
                        (front.vote == Vote.UNDECIDED && ballotNode.vote == Vote.NO)) {
                    front.next = front;
                    front = ballotNode;
                }
            }
        }

        return voteList;
    }

    public Vote countVotes(VoteList votelist) {
        int yes=0;
        int no=0;
        for (Ballot it = front; it != null; it = it.next) {
            if (it.vote == Vote.YES) {
                yes++;
            }
            else if(it.vote == Vote.NO) {
                no++;
            }
        }

        if (no>yes)
            return Vote.NO;
        else if (no<yes)
            return Vote.YES;
        else
            return Vote.UNDECIDED;

    }



}
