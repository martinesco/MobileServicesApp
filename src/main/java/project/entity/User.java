package project.entity;

import project.Role;
import project.Validate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User{

    private Role role;
    private String name;
    private String password;
    private String email;
    private LocalDate dateOfRegistration;
    private List<MobileService> mobileServices;

   /* private String mobileNumber;
    private Service service;
    private Map<String, Service> numberServiceMap;

    private List<Invoice> invoices;*/

    public User(String name, String password, String email) {
        this.setRole();
        this.setName(name);
        this.setPassword(password);
        this.setEmail(email);
        this.setDateOfRegistration();
        this.setMobileServices();
    }


    private void setRole() {
        this.role = Role.USER;
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

    private void setMobileServices() {
        this.mobileServices = new ArrayList<>();
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

    public List<MobileService> getMobileServices() {
        return mobileServices;
    }

    @Override
    public String toString() {
        return String.format(" ## Name: %s%n ## Email: %s%n ## Date of registration: %s", this.getName(), this.getEmail(), this.getDateOfRegistration());

    }
}

