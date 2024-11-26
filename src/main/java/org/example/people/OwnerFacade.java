package org.example.people;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.storage.GlobalOwnerStorage;

@Singleton
public class OwnerFacade {
    @Inject
    GlobalOwnerStorage globalOwnerStorage;
    public Owner createOwner(String name, String lastname, String personID){
        Owner owner = new Owner(name, lastname, personID);
        globalOwnerStorage.addOwner(owner);
        return owner;
    }
}
