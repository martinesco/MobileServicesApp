package project.entity;

import project.Role;
import project.Validate;

import java.time.LocalDate;

public class Operator {

    private Role role;
    private String name;
    private String password;
    private String email;
    private LocalDate dateOfRegistration;


    public Operator(String name, String password, String email) {
        this.setRole();
        this.setName(name);
        this.setPassword(password);
        this.setEmail(email);
        this.setDateOfRegistration();
    }

    private void setRole() {
        this.role = Role.OPERATOR;
    }

    private void setName(String name) {
        Validate.name(name);
        this.name = name;
    }

    private void setPassword(String password) {
        Validate.password(password);
        this.password = password;
    }

    private void setEmail(String email) {
        Validate.email(email);
        this.email = email;
    }

    private void setDateOfRegistration() {
        this.dateOfRegistration = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    @Override
    public String toString() {
        return String.format(" ** Operator name: %s%n ** Email: %s%n ** Date of registration: %s",
                this.getName(),
                this.getEmail(),
                this.getDateOfRegistration()
        );
    }
}
