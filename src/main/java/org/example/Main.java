package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.accounts.exceptions.NoMoneyOnAccountException;

public class Main {
    public static void main(String[] args) {
        try {
            //App app = new App();
            //app.run();
            Injector injector = Guice.createInjector(new BankInjector());
            App app = injector.getInstance(App.class);
            app.run();
        } catch (NoMoneyOnAccountException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}