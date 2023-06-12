package org.example.backend.db;

import org.example.backend.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Database {


       List<Contact> CONTACT_LIST = new ArrayList<>();

       static void load(){

           Contact contact1 = new Contact("Ibrohim", "977776399");
           Contact contact2 = new Contact("Alisher", "900787802");
           Contact contact3 = new Contact("Nodir", "904430302");
           Contact contact4 = new Contact("Sunnatillo", "999805970");

           Collections.addAll(CONTACT_LIST,contact1,contact2,contact3,contact4);

           CONTACT_LIST.forEach(System.out::println);

       }


}
