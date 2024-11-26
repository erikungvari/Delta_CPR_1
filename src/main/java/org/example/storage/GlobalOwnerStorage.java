package org.example.storage;

import com.google.inject.Singleton;
import org.example.people.Owner;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GlobalOwnerStorage {
    public List<Owner> ownerStorage = new ArrayList<>();

    public List<Owner> getOwnerStorage() {
        return ownerStorage;
    }

    public void addOwner(Owner owner){
        ownerStorage.add(owner);
    }

}
