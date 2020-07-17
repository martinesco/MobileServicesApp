package project.operations;


import project.ConnectionWithDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class UserOperations {
    public static void getInformation(String userName) {

        String query = String.format("SELECT * FROM users WHERE name='%s'", userName);

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

                System.out.println(String.format(" ** User name: %s%n ** Email: %s%n ** Date of registration: %s", name, email, dateOfRegistration));

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

    public static void getServiceInformation(String userName) {

        String query = String.format("SELECT users.name, mobileServices.service_name FROM users JOIN mobileServices ON users.name=mobileServices.user_name WHERE name ='%s'", userName);

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
                String serviceName = rs.getString("mobileServices.service_name");

                System.out.println(String.format(" ** My name: %s%n ** My Service name: %s%n", userName, serviceName));


                String newQuery = String.format("SELECT * FROM services WHERE name='%s'", serviceName);

                try {
                    st = ConnectionWithDatabase.connectWithDatabase().createStatement();
                } catch (SQLException e) {
                    System.out.println("Cannot connect to the database");
                }


                try {
                    rs = st.executeQuery(newQuery);
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


                        System.out.println(String.format(" # Price per month: %.2f%n # Minutes to Bulgaria: %s%n # Minutes to Abroad: %s%n # MB Internet: %s%n # MB Internet Roaming: %s%n # SMS: %s%n # Extras:%s",

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

    public static void getInvoiceInformation(String name) {

        String query = String.format("SELECT *, mobileServices.mobileNumber FROM invoices JOIN mobileServices ON invoices.mobileServices_mobileNumber=mobileServices.mobileNumber WHERE user_name ='%s'", name);

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
                String status = rs.getString("status");
                double price = rs.getDouble("price");
                String fromDate = rs.getString("fromDate");
                String toDate = rs.getString("toDate");
                String deadline = rs.getString("deadline");

                System.out.println(String.format(" ## Invoice status: %s%n ## Price: %.2f%n ## From date: %s%n ## To date: %s%n ## Deadline for payment: %s",
                        status,
                        price,
                        fromDate,
                        toDate,
                        deadline
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
}
