package ru.gb.patterns.facade;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String patranimic;
    private List<Role> roles;

    private User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatranimic() {
        return patranimic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatranimic(String patranimic) {
        this.patranimic = patranimic;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder {
        private final User user = new User();

        public UserBuilder withId(Long id) {
            user.id = id;
            return this;
        }

        public UserBuilder withName(String name) {
            user.name = name;
            return this;
        }

        public UserBuilder withSurname(String surname) {
            user.surname = surname;
            return this;
        }

        public UserBuilder withPatranimic(String patranimic) {
            user.patranimic = patranimic;
            return this;
        }

        public User build() {
            return user;
        }
    }


}
