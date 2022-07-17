package com.dtdreyer.cardcreater;

public class Main {
    public static void main(String[] args) {
        JSONController.createCardLib();
        Interface.mainMenu();
        AutoReadCSV.readFileAndAddCards();

    } 
}
