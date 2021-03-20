package assignment9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String nationality;
    private LocalDate birthdate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public Person(String nationality, int birthdate) {
        this.nationality = nationality;
        try{
            this.birthdate = LocalDate.parse(Integer.toString(birthdate), formatter);
        }
        catch (DateTimeParseException ex){
            System.out.println("Give person a proper birthday! DDMMYYYY");
//        System.exit(1);
        }
    }
}
