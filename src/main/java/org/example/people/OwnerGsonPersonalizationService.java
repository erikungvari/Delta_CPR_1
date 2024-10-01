package org.example.people;

import com.google.gson.Gson;

public class OwnerGsonPersonalizationService implements PersonSerializationService {

    @Override
    public String serializeOwner(Owner owner) {
        Gson gson = new Gson();
        return  gson.toJson(owner, Owner.class);
    }
}
