package org.example;

import org.example.accounts.exceptions.NoMoneyOnAccountException;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        try {
            app.run();
        } catch (NoMoneyOnAccountException e) {
            throw new RuntimeException(e);
        }
    }
}