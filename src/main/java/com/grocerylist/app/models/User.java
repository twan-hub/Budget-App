package com.grocerylist.app.models;

import com.grocerylist.app.models.data.GroceryListRepository;
import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class User extends AbstractEntity{

//    @OneToMany
//    private GroceryListRepository groceryListRepository;
    @NotNull
    private String username;
    @NotNull
    private String passHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.passHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password,passHash);
    }
}
