package pl.polsl.lab.model;

import java.time.LocalDate;

public class SingletonModel {
   
    private static User instance;

    private SingletonModel() {        
    }
    
    public static User getInstance() {

        if(instance == null) {
            instance = new User();
                       
                instance.addClient(new Client("Pati", "Monika", "432789234", "2class"));
                instance.addClient(new Client("Bartek", "Klaudia", "506923876", "Good"));
                instance.addClient(new Client("Michal", "Krzysztof", "123456780", "Bad"));
            
        }
        return instance;
    }   
}
