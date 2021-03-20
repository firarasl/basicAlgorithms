package assignment9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Documents {
    private String documentID;
    private LocalDate expirationDate;
    private boolean valid = true;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return  "DOCUMENT!!! documentID='" + documentID + '\'' +
                ", expirationDate=" + expirationDate +
                ", valid=" + valid +
                ", formatter=" + formatter +
                "}\n";
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Documents(String firstDigit, String nationality, LocalDate birthdate, int duration) {
        this.documentID = firstDigit+nationality+"-"+birthdate.format(formatter);
        this.expirationDate = LocalDate.now().plusYears(duration);
    }
}
