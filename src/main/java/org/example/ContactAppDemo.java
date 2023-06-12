package org.example;

import org.example.backend.db.Database;
import org.example.frontend.MainUI;

public class ContactAppDemo {
    public static void main(String[] args) {

        Database.load();

        MainUI mainUI = new MainUI();

        mainUI.window();


    }
}