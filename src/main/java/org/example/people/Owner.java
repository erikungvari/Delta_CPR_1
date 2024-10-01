package org.example.people;

public class Owner {
    private String firstname;
    private String lastname;
    private String personID;

    public Owner(String firstname, String lastname, String personID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.personID = personID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPersonID() {
        return personID;
    }
}