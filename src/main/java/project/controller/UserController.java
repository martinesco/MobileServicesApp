package project.controller;

import project.operations.UserOperations;

import java.util.Scanner;

public class UserController {

    static Scanner scanner = new Scanner(System.in);

    public static void userMethod(String name) {


        System.out.println("You are logged in as User\nSelect an option:");

        System.out.println(String.format(
                "0.Exit%n" +
                        "1.My info%n" +
                        "2.My service info%n" +
                        "3.My invoice info"));
        int input = Integer.parseInt(scanner.nextLine());

        while (input != 0) {
            switch (input) {
                case 1:
                    UserOperations.getInformation(name);

                    break;
                case 2:

                    UserOperations.getServiceInformation(name);

                    break;
                case 3:

                   UserOperations.getInvoiceInformation(name);
                    break;


                default:
                    System.out.println("Wrong input!");
                    break;

            }

            System.out.println(String.format("---------- %n" +
                    "Select an option:%n" +
                    "0.Exit%n" +
                    "1.My info%n" +
                    "2.My service info%n" +
                    "3.My invoice info"));
            input = Integer.parseInt(scanner.nextLine());
        }
    }
}
