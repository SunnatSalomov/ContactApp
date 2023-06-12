package org.example.frontend;

import org.example.backend.dto.Response;
import org.example.backend.model.Contact;
import org.example.backend.service.ContactService;

import java.util.Scanner;

public class MainUI {
    public void window() {
        while (true) {
            System.out.println("""
                    1.Login
                    0.Exit
                    
                   
                    """);

            Scanner scanner = new Scanner(System.in);
            System.out.println("?!");
            String operation = scanner.nextLine();

           if (operation.equals("0")){
               break;

           }
           if (operation.equals("1")){
               login();
           }



        }
    }

    private void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the phone Number :");
        String phoneNumber = scanner.nextLine();

        ContactService contactService = new ContactService();

        Response response = contactService.login(firstName, phoneNumber);

        if (response.success()){
            contactPage();
        }
        else System.out.println("Error ");

    }

    private void contactPage() {

        while (true){
            System.out.println("""
                    1.Show contacts
                    2.Search contact
                    0.back
                    """);
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("0")) return;

            switch (option){
                case "1"-> showContacts();
                case "2"-> searchContact();
                default -> System.out.println("Wrong operation");

            }


        }

    }

    private void searchContact() {

        System.out.println("enter the user name");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        ContactService contactService = new ContactService();

        Contact contact = contactService.searchContact(userName);
        System.out.println(contact);

    }

    private void showContacts() {
        ContactService contactService = new ContactService();
        contactService.showContact();


    }
}
