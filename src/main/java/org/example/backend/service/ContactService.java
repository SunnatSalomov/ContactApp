package org.example.backend.service;

import org.example.backend.db.Database;
import org.example.backend.dto.Response;
import org.example.backend.model.Contact;

import java.util.Objects;
import java.util.Optional;

public class ContactService {
    public Response login(String firstName, String phoneNumber) {
        Contact contacts = null;
        for (Contact contact : Database.CONTACT_LIST) {
            if(contact.getPhoneNumber().equals(phoneNumber)){
                contacts = contact;
            }
        }
        if (contacts!=null){
            return new Response("Sucssefully", true);
        }

        return new Response("not found", false);
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
