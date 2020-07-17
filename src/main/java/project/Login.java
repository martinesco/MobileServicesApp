package project;

import project.controller.OperatorController;
import project.controller.UserController;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {

    public void checkForUser(String searchedName, String searchedPassword){

        String query = "SELECT * FROM users";
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
        boolean isFound = false;
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                if (name.equals(searchedName) && password.equals(searchedPassword)) {
                    isFound = true;
                }

            }
        } catch (SQLException e) {
            System.out.println("Cannot get the data from database");
        }

        if (isFound == true) {
            UserController.userMethod(searchedName);
        } else
            //  System.out.println("Not found an user!");

            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Cannot stop the connection");
            }

    }

    public void checkForOperator(String searchedName, String searchedPassword)  {
       
        String query = "SELECT * FROM operators";
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
        boolean isFound = false;
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                if (name.equals(searchedName) && password.equals(searchedPassword)) {
                    isFound = true;
                }

            }
        } catch (SQLException e) {
            System.out.println("Cannot get the data from database");
        }

        if (isFound == true) {
            OperatorController.operatorMethod(searchedName);
        } else
          //  System.out.println("Not found an operator!");

        try {
            st.close();
        } catch (SQLException e) {
            System.out.println("Cannot stop the connection");
        }
    }
}
