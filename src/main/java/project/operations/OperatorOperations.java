package project.operations;

import project.ConnectionWithDatabase;
import project.Validate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class OperatorOperations {

    static Scanner scanner = new Scanner(System.in);

    public static void getInformation(String operatorName) {

        String query = String.format("SELECT * FROM operators WHERE name='%s'", operatorName);

        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("The query cannot be fulfilled");
        }


        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date dateOfRegistration = rs.getDate("dateOfRegistration");

                System.out.println(String.format(" ** Operator name: %s%n ** Email: %s%n ** Date of registration: %s", name, email, dateOfRegistration));

            }

        } catch (SQLException e) {
            System.out.println("Cannot get the data from the  database");
        }
        try {
            st.close();
        } catch (SQLException e) {
            System.out.println("Cannot stop the connection");
        }
    }

    public static void searchForUser() {

        System.out.print("Enter text for search: ");
        String userPattern = scanner.nextLine();

        String query = String.format("SELECT * FROM users WHERE LOWER(name) LIKE LOWER('%%%s%%')", userPattern);

        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("The query cannot be fulfilled");
        }

        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date dateOfRegistration = rs.getDate("dateOfRegistration");


                System.out.println(String.format(" # Match #%n ** User name: %s%n ** Email: %s%n ** Date of registration: %s", name, email, dateOfRegistration));
                System.out.println("**********");

            }

        } catch (SQLException e) {
            System.out.println("Cannot get the data from the  database");
        }
        try {
            st.close();
        } catch (SQLException e) {
            System.out.println("Cannot stop the connection");
        }

    }

    public static void searchForService() {

        System.out.print("Enter text for search: ");
        String servicePattern = scanner.nextLine();

        String query = String.format("SELECT * FROM services WHERE LOWER(name) LIKE LOWER('%%%s%%')", servicePattern);

        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("The query cannot be fulfilled");
        }

        try {
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String minutesToBulgaria = rs.getString("minutesToBulgaria");
                String minutesToAbroad = rs.getString("minutesToAbroad");
                int mbInternetToBulgaria = rs.getInt("mbInternetToBulgaria");
                int mbInternetToAbroad = rs.getInt("mbInternetToAbroad");
                int sms = rs.getInt("sms");
                String extras = rs.getString("extras");


                System.out.println(String.format(" # Match #%n # Service name: %s%n # Price per month: %.2f%n # Minutes to Bulgaria: %s%n # Minutes to Abroad: %s%n # MB Internet: %s%n # MB Internet Roaming: %s%n # SMS: %s%n # Extras:%s",
                        name,
                        price,
                        minutesToBulgaria,
                        minutesToAbroad,
                        mbInternetToBulgaria,
                        mbInternetToAbroad,
                        sms,
                        extras
                ));
                System.out.println("**********");

            }

        } catch (SQLException e) {
            System.out.println("Cannot get the data from the  database");
        }
        try {
            st.close();
        } catch (SQLException e) {
            System.out.println("Cannot stop the connection");
        }

    }

    public static void createNewUser() {
        System.out.println("Creating new User...");

        System.out.print("Enter name:");
        String name = scanner.nextLine();
        Validate.name(name);

        System.out.print("Enter password:");
        String password = scanner.nextLine();
        Validate.password(password);

        System.out.print("Enter email:");
        String email = scanner.nextLine();
        Validate.email(email);

        String dateOfRegistration = String.valueOf(LocalDate.now());

        String query = String.format("INSERT INTO users VALUES('%s' , '%s' , '%s', '%s')", name, password, email, dateOfRegistration);

        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }

        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Exception in sql execute");
        }

    }

    public static void createNewService() {

        System.out.println("Creating new Service...");

        System.out.print("Enter Name:");
        String name = scanner.nextLine();
        Validate.name(name);

        System.out.print("Enter Price per month:");
        double price = Double.parseDouble(scanner.nextLine());
        Validate.price(price);

        System.out.print("Enter Minutes to Bulgaria(Integer or \"Neogranicheni\"):");
        String minutesToBulgaria = scanner.nextLine();
        Validate.serviceMinutes(minutesToBulgaria);

        System.out.print("Enter Minutes to Abroad(Integer or \"Neogranicheni\"):");
        String minutesToAbroad = scanner.nextLine();
        Validate.serviceMinutes(minutesToAbroad);

        System.out.print("Enter MB Internet:");
        int mbInternetToBulgaria = Integer.parseInt(scanner.nextLine());
        Validate.serviceInternet(mbInternetToBulgaria);

        System.out.print("Enter MB Internet Roaming:");
        int mbInternetToAbroad = Integer.parseInt(scanner.nextLine());
        Validate.serviceInternet(mbInternetToAbroad);

        System.out.print("Enter SMS:");
        int sms = Integer.parseInt(scanner.nextLine());
        Validate.sms(sms);

        System.out.print("Enter extras:");
        String extras = scanner.nextLine();


        String query = String.format("INSERT INTO services VALUES('%s' , '%.2f' , '%s', '%s', '%d', '%d', '%d', '%s')",
                name,
                price,
                minutesToBulgaria,
                minutesToAbroad,
                mbInternetToBulgaria,
                mbInternetToAbroad,
                sms,
                extras);

        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }

        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Exception in sql execute");
        }

    }

    public static void searchForNotPaidServices() {

        String query = "SELECT *, mobileServices.user_name, mobileServices.service_name " +
                "FROM invoices " +
                "JOIN mobileServices " +
                "ON invoices.mobileservices_mobilenumber = mobileServices.mobileNumber " +
                "WHERE status='not_paid'";

//SELECT invoices.price, mobileServices.user_name, mobileServices.service_name FROM invoices JOIN mobileServices ON invoices.mobileservices_mobilenumber = mobileServices.mobileNumber
        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("The query cannot be fulfilled");
        }

        try {
            while (rs.next()) {
                double price = rs.getDouble("price");
                String fromDate = rs.getString("fromDate");
                String toDate = rs.getString("toDate");
                String deadline = rs.getString("deadline");
                String mobileNumber = rs.getString("mobileServices_mobileNumber");

                String userName = rs.getString("user_name");
                String serviceName = rs.getString("service_name");


                System.out.println(String.format("      ! NOT PAID INVOICE ! %n # For mobile number: %s%n # Price per month: %.2f%n # From Date: %s%n # To Date: %s%n # Deadline: %s",
                        mobileNumber,
                        price,
                        fromDate,
                        toDate,
                        deadline
                ));


                System.out.println(String.format(" Details: %n Person name: %s%n Service name: %s",
                        userName,
                        serviceName
                ));
                System.out.println("*********************************");

            }

        } catch (SQLException e) {
            System.out.println("Cannot get the data from the  database");
        }
        try {
            st.close();
        } catch (SQLException e) {
            System.out.println("Cannot stop the connection");
        }

    }

    public static void addNewServiceToUser() {

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        Validate.name(userName);

        String query = String.format("SELECT * FROM users WHERE LOWER(name) = LOWER('%s')", userName);

        Statement st = null;

        try {
            st = ConnectionWithDatabase.connectWithDatabase().createStatement();
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("The query cannot be fulfilled!");
        }

        try {
            if (!rs.next()) {
                System.out.println("No user with this name");

            } else {

                System.out.println("Adding a service to the user...");

                System.out.println("Enter the new phone number:");
                String mobileNumber = scanner.nextLine();
                Validate.mobileNumber(mobileNumber);

                System.out.println("Enter Service name:");
                String serviceName = scanner.nextLine();
                Validate.name(serviceName);

                String newQuery = String.format("INSERT INTO mobileServices VALUES('%s' , '%s' , '%s')",
                        mobileNumber,
                        userName,
                        serviceName
                );

                try {
                    st.executeUpdate(newQuery);
                } catch (SQLException e) {
                    System.out.println("Exception in sql execute");
                }


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
