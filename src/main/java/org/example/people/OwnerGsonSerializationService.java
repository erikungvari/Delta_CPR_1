package org.example.people;

import com.google.gson.Gson;

public class OwnerGsonSerializationService implements PersonSerializationService {

    @Override
    public String serializeOwner(Owner owner) {
        Gson gson = new Gson();
        return  gson.toJson(owner, Owner.class);
    }
}
