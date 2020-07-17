package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionWithDatabase {
    public static Connection connectWithDatabase() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

      //  String myDriver = null;
        Connection conn = null;
       // String myUrl = null;

       /* Statement stmt = null;
        ResultSet rs = null;*/
        try {

            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/E:\\Java\\MobileServicesApp\\app_db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE", "", "");

        } catch (Exception e) {
            e.printStackTrace();
        }


        return conn;
    }
}
