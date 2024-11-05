package org.example.accounts;

import com.google.inject.Singleton;

@Singleton
public class ShareFactory {

    public Share createShare(String name, int part, double balance, double dividend){
        return new Share(name, part, balance, dividend);
    }
}
