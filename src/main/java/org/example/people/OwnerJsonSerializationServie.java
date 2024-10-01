package org.example.people;

public class OwnerJsonSerializationServie implements PersonSerializationService{
    public String serializeOwner(Owner owner){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"Name\":\"" + owner.getFirstname() + " " + owner.getLastname() + "\",");
        stringBuilder.append("\"ID\":\"" + owner.getPersonID() + "\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
