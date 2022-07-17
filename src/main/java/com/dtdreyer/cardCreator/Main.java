package com.dtdreyer.cardCreator;

public class Main {
    
    /**
     * This method is the entry point of the program.
     * 
     * @author dtdreyer
     */
    public static void main(String[] args) {
        JSONController.createCardLib();
        Interface.mainMenu();
        AutoReadCSV.readFileAndAddCards();

    } 
}
