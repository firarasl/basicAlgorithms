package assignment9;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DocumentOffice {
    private String countryCode;
    private LocalDate date;
    List<Documents> database= new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public DocumentOffice(String countryCode, int date ) {
        this.countryCode = countryCode;

        try{
            this.date = LocalDate.parse(Integer.toString(date), formatter);
        }
        catch (DateTimeParseException ex){
            System.out.println("Give DocumentOffice a proper date! DDMMYYYY");
//        System.exit(1);
        }
    }




    public boolean addPenalty(Person person, int points){
        String documentId2= "2"+person.getNationality()+"-"+person.getBirthdate().format(formatter);

        List<Documents> personsOldDrivingLicense=database.stream()
                .filter(c -> documentId2.equals(c.getDocumentID()))
                .collect(Collectors.toList());

        if(personsOldDrivingLicense.size() >0){
            ((DriversLicense) personsOldDrivingLicense.get(0)).setPenaltyPoints(points);
            if (((DriversLicense) personsOldDrivingLicense.get(0)).getPenaltyPoints() > 20){
                personsOldDrivingLicense.get(0).setValid(false);
            }
            return true;
        }else{
            return false;
        }

    }

    public boolean updateDate(int newDate){


        try{
            LocalDate convertedNewDate = LocalDate.parse(Integer.toString(newDate), formatter);
            if(convertedNewDate.isAfter(this.date)){
                this.date=convertedNewDate;
                return true;
            }else{
                return false;
            }
        }
        catch (DateTimeParseException ex){
            System.out.println("Give DocumentOffice a proper date! DDMMYYYY");
            return false;
        }


    }

    public String returnDatabase(){
        List<Documents> result = this.database.stream().sorted((o1, o2)->o1.getDocumentID().
                compareTo(o2.getDocumentID())).
                collect(Collectors.toList());
        String answer = "";
        for (int i = 0; i < result.size(); i++) {
            answer+="Entry Nr."+(i+1) +" "+result.get(i).getDocumentID()+" - "+ result.get(i).getExpirationDate().format(formatter2) + "\n";
        }
        return answer;
    }
    public Documents[] find( Person person){
        String documentId1= "1"+person.getNationality()+"-"+person.getBirthdate().format(formatter);
        String documentId2= "2"+person.getNationality()+"-"+person.getBirthdate().format(formatter);
        List<Documents> answer= new ArrayList<>();
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getDocumentID().equals(documentId1) || database.get(i).getDocumentID().equals(documentId2)){
                answer.add(database.get(i));
            }
        }
        Documents[] util= new Documents[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            util[i] = answer.get(i);
        }
return util;
//        return (Documents[]) database.stream()
//                .filter(c -> c.getDocumentID().equals(documentId1 ) || c.getDocumentID().equals(documentId2 ))
//                .collect(Collectors.toList()).toArray();
    }
    public boolean requestDocuments(Person person, int number){

        boolean generatedValidCard = false;
        if(number== 1 || number== 2){
            // looking for old identitycard of the person
            String documentId1= "1"+person.getNationality()+"-"+person.getBirthdate().format(formatter);
            String documentId2= "2"+person.getNationality()+"-"+person.getBirthdate().format(formatter);
            List<Documents> personsOldIdentityCard= database.stream()
                    .filter(c -> documentId1.equals(c.getDocumentID()))
                    .collect(Collectors.toList());

            List<Documents>  personsOldDrivingLicense=database.stream()
                    .filter(c -> documentId2.equals(c.getDocumentID()))
                    .collect(Collectors.toList());


            if (number== 1 && this.countryCode.equals(person.getNationality())){
                if(personsOldIdentityCard.size() >0 ) {
                    personsOldIdentityCard.get(0).setExpirationDate(LocalDate.now().plusYears(10));
                }
                else{
                    Documents newIdentityCard= new IdentityCard(person.getNationality(), person.getBirthdate());
                    database.add(newIdentityCard);
                }
                generatedValidCard = true;
            }
            else if (number== 2 && ChronoUnit.YEARS.between(person.getBirthdate(), LocalDate.now()) >=18){

                if(personsOldIdentityCard.size() >0 ){
//                  found the identitycard
                    if(personsOldDrivingLicense.size() >0 ){
                        if (((DriversLicense) personsOldDrivingLicense.get(0)).getPenaltyPoints() >20){
                            return false;
                        }
                        else{
                            personsOldDrivingLicense.get(0).setExpirationDate(LocalDate.now().plusYears(15));
                        }
                    }else{
                        Documents newDrivingLicense= new DriversLicense(person.getNationality(), person.getBirthdate());
                        database.add(newDrivingLicense);
                    }
                    generatedValidCard = true;
                }
            }
        }

        return generatedValidCard;
    }
}
