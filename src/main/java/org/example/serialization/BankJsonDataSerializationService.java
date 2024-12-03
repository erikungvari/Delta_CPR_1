package org.example.serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankJsonDataSerializationService {

    @Inject
    private Gson gson;

    public String serializeBank(BankJsonData data) {
        return gson.toJson(data);
    }
}
