package project;

public class Validate {

    public static void name(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("A name should not be empty and less than 3 character!");

        }
    }

    public static void password(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password should be at least 6 character!");
        }
    }

    public static void email(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Incorrect input for email!");
        }
    }

    public static void price(double price) {
        if (price <= 0.0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
    }

    public static void serviceMinutes(String serviceMinutes) {
        if (!serviceMinutes.equals("Neogranicheni") && serviceMinutes.matches("-[0-9]*")) {
            throw new IllegalArgumentException("Minutes must be integer and cannot be negative!");
        }
    }

    public static void serviceInternet(int serviceInternet) {
        if (serviceInternet < 0) {
            throw new IllegalArgumentException("MB cannot be negative!");
        }
    }

    public static void sms(int sms) {
        if (sms < 0) {
            throw new IllegalArgumentException("SMS cannot be negative!");
        }
    }

    public static void mobileNumber(String mobileNumber) {
        if (!mobileNumber.matches("[0-9]*")){
            throw new IllegalArgumentException("Phone number must contain only digits!");
        }
    }

    public static void yesNoAnswer(String answer){
        if (!answer.toLowerCase().equals("yes") && !answer.toLowerCase().equals("no")){
            throw new IllegalArgumentException("Only Yes and No are correct answers!");
        }
    }
}
