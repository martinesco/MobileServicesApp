package project.controller;

import project.operations.OperatorOperations;

import java.util.Scanner;

public class OperatorController {

    static Scanner scanner = new Scanner(System.in);

    public static void operatorMethod(String name) {
        System.out.println("You are logged in as Operator\nSelect an option:");

        System.out.println(String.format(
                "0.Exit%n" +
                        "1.My info%n" +
                        "2.Search for User%n" +
                        "3.Search for Service%n" +
                        "4.Search for not paid services%n" +
                        "5.Create new User%n" +
                        "6.Create new Service%n" +
                        "7.Add service to an User"));

        int input = Integer.parseInt(scanner.nextLine());

        while (input != 0) {

            switch (input) {
                case 1:
                    OperatorOperations.getInformation(name);
                    break;
                case 2:
                    OperatorOperations.searchForUser();
                    break;
                case 3:
                    OperatorOperations.searchForService();
                    break;
                case 4:
                    OperatorOperations.searchForNotPaidServices();
                    break;
                case 5:
                    OperatorOperations.createNewUser();
                    System.out.println("New User created successfully!");
                    break;
                case 6:
                    OperatorOperations.createNewService();
                    System.out.println("New Service created successfully!");
                    break;
                case 7:
                    OperatorOperations.addNewServiceToUser();
                    System.out.println("New Service added successfully!");
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;

            }

            System.out.println(String.format("---------- %n" +
                    "Select an option:%n" +
                    "0.Exit%n" +
                    "1.My info%n" +
                    "2.Search for User%n" +
                    "3.Search for Service%n" +
                    "4.Search for not paid services%n" +
                    "5.Create new User%n" +
                    "6.Create new Service%n" +
                    "7.Add service to an User"));
            input = Integer.parseInt(scanner.nextLine());
        }
    }



}
