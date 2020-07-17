package project;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        System.out.println("Enter username:");
        String name = scanner.nextLine();
        Validate.name(name);

        System.out.println("Enter password:");
        String password = scanner.nextLine();
        Validate.password(password);

        Login login = new Login();


        login.checkForOperator(name, password);

        login.checkForUser(name, password);


        System.out.println("END");
    }

}
