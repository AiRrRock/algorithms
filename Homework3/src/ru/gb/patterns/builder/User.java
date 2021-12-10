package ru.gb.patterns.builder;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String patranimic;

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
