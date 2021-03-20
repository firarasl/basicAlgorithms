package assignment9;

import java.time.LocalDate;

public class IdentityCard extends Documents{

    public IdentityCard(String nationality, LocalDate birthdate) {
        super("1", nationality,birthdate, 10);
    }


}
