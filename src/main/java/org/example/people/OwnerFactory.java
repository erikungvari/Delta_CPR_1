package org.example.people;

public class OwnerFactory {
    private PersonIDValidator idValidator;

    public OwnerFactory() {
        this.idValidator = new PersonIDValidator();
    }

    public Owner createOwner(String name, String lastname, String personID){
        if(!this.idValidator.isPersonIdValid(personID)){
            System.out.println("Invalid person: " + personID);
        }
        return new Owner(name, lastname, personID);
    }
}
