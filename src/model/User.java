package model;

public class User {
    private String name;
    private String email;
    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email.matches(EMAIL_PATTERN)) {
            this.email = email;
            return true;
        }
        return false;

    }

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
