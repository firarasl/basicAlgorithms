package assignment7;


public class LinkedListCustom {
    public Node front;
    Node rear;

    public LinkedListCustom() {
        front = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = front;
        front = newNode;
    }

    public void sort(int[][] m){

        int counter=0;
        int[] sorted1Darray= new int[m.length*2-1];
        int helper;

//        turning 2d into 1d TAKING ONLY INDIVIDUALS FROM EACH DIAGONAL ( was said in the assignment)

        for (int i = 0; i < m[0].length; i++) {
            sorted1Darray[counter]=m[i][0];
            counter++;
            if (i==m[0].length-1){
                for (int k = 1; k < m.length; k++) {
                    sorted1Darray[counter]= m[i][k];
                    counter++;
                }
            }
        }



//        sorting 1d
        for (int i = 0; i < sorted1Darray.length - 1; i++) {
            if (sorted1Darray[i] > sorted1Darray[i + 1]) {
                helper = sorted1Darray[i + 1];
                sorted1Darray[i + 1] = sorted1Darray[i];
                sorted1Darray[i] = helper;
                i = -1;
            }
        }

//        filling 1d into linked list
        for (int i = 0; i < sorted1Darray.length; i++) {
            this.addAt(i, sorted1Darray[i]);
        }
    }


    @Override
    public String toString() {
        String toString = "";
        for (Node it = front; it != null; it = it.next) {
            toString+=it.toString();
        }
        return toString;
    }


    public void addAt(int index, int data) {
        if (index == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node it = front;
            for (int i = 1; it != null && i < index; i++) {
                it = it.next;
            }
            if (it != null) {
                newNode.next = it.next;
                if (newNode.next == null)
                    rear = newNode;
                it.next = newNode;
            }

        }
    }

}