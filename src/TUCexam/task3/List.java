package TUCexam.task3;
public class List {
    public Record front;
    Record rear;

    public List() {
        front = null;
    }

    public void remove(Record recordToRemove) {
        Record it = this.front;

        // special case: list is empty
        if (it == null) {
            rear = null;
            return;
        }

        if (it.productType.equals(recordToRemove.productType)) {
            front = it.next;
            return;
        }

        while (it.next != null) {
            if (it.next.productType.equals(recordToRemove.productType)) {
                it.next = it.next.next;
                if (it.next == null) {
                    rear = it;
                }
                return;
            }
            it = it.next;

            // special case: data is in the last node
            if (it == null) {
                return;
            }
        }
    }


    public void addAtEnd(Record recordToAdd) {
        if (front == null){
            front = recordToAdd;
            front.next=null;
        }
        else {
            for (Record record = front; record != null; record = record.next) {
                if (record.next == null) {
                    record.next = recordToAdd;
                    break;
                }
            }
        }
    }


    public void add(Record receivedRecord){
        boolean hasIt = false;

        Record currentRecord = front;
        for (int i = 1; currentRecord != null; i++) {
            if (currentRecord.name.equals(receivedRecord.name)){
                hasIt=true;
                currentRecord.amountUnit=receivedRecord.amountUnit;
            }
            currentRecord = currentRecord.next;
        }

        if (hasIt==false){
            addAtEnd(receivedRecord);
        }

    }

    public void merge(List listToMerge){
//        finding the last node of first list and setting its next node to the front of the second list
        Record lastOfFirst;
        for (Record record = this.front; record != null; record = record.next) {
            if (record.next == null) {
                lastOfFirst = record;
                record.next= listToMerge.front;
            }

        }
    }





    public void splitByType(ProductType type){
        List newList = new List();

        for (Record record = this.front; record != null; record = record.next) {
            if (record.productType.equals(type)) {
                newList.addAtEnd(record);
                remove(record);
            }

        }

    }

    public double calculateTotal(){

        double sum = 0;
        for (Record record = this.front; record != null; record = record.next) {

            sum+=record.prizeUnit;
        }

        return sum;
    }
}