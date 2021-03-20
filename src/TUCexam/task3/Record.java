package TUCexam.task3;

public class Record {

    String name;
    double prizeUnit;
    int amountUnit;
    ProductType productType;
    Record next;

    public Record(String name, double prizeUnit, int amountUnit, ProductType productType) {
        this.name = name;
        this.prizeUnit = prizeUnit;
        this.amountUnit = amountUnit;
        this.productType = productType;
        this.next=null;
    }
}
