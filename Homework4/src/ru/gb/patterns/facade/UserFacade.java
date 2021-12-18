package ru.gb.patterns.facade;

import java.util.ArrayList;
import java.util.List;

public class UserFacade {

    private User createManager(long id, String name, String surname, String patronimic){
       User.UserBuilder builder =  User.builder();
       builder.withId(id);
       builder.withName(name);
       builder.withSurname(surname);
       builder.withPatranimic(patronimic);
       User user = builder.build();
       setManagerRoles(user);
       return user;
    }

    private User createCustomer(long id, String name, String surname, String patronimic){
        User.UserBuilder builder =  User.builder();
        builder.withId(id);
        builder.withName(name);
        builder.withSurname(surname);
        builder.withPatranimic(patronimic);
        User user = builder.build();
        setCustomerRoles(user);
        return user;
    }

    private void setManagerRoles(User user){
        Role role = new Role("manager");
        Role role2 = new Role("admin");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roles.add(role2);
        user.setRoles(roles);
    }


    private void setCustomerRoles(User user){
        Role role = new Role("customer");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
    }
}
