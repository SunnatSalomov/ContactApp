package org.example.backend.service;

import org.example.backend.db.Database;
import org.example.backend.dto.Response;
import org.example.backend.model.Contact;

import java.util.Objects;
import java.util.Optional;

public class ContactService {
    private Contact getContactByPhoneNumber(String phonenumber){
         return  Database.CONTACT_LIST.stream().filter(contact -> contact.getPhoneNumber().equals(phonenumber))
                 .findFirst().orElse(null);
    }
    public Response login(String firstName, String phoneNumber) {
        try {
            Contact contact = getContactByPhoneNumber(phoneNumber);

            if (contact==null){
                return new Response("not found", false);
            }
            if (!contact.getFirstName().equals(firstName)) {
                return new Response("not found", false);
            }

            return new Response("Successfully", true);

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("not found", false);
        }

    }

    public void showContact() {
        Database.CONTACT_LIST.forEach(System.out::println);

    }

    public Contact searchContact(String userName) {

        Contact contact = getContactByUserName(userName);
        return contact;

    }

    private Contact getContactByUserName(String userName) {
        Optional<Contact> optionalContact = Database.CONTACT_LIST.stream().filter(contact -> contact.getFirstName().toLowerCase().contains(userName.toLowerCase())).findFirst();
        Contact contact = optionalContact.get();
        return contact;
    }
}
