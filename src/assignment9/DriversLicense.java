package assignment9;

import java.time.LocalDate;

public class DriversLicense extends Documents {
    private int penaltyPoints = 0;

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public DriversLicense(String nationality, LocalDate birthdate) {
        super("2", nationality,birthdate, 15);
    }
}
