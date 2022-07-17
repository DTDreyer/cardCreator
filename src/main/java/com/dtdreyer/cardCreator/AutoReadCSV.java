package com.dtdreyer.cardcreater;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AutoReadCSV {

    private static File cardFile = new File("cardcreater\\data\\cardList.csv");
    
    public static void readFileAndAddCards() {
        try {
            Scanner scanner = new Scanner(cardFile);
            while (scanner.hasNextLine()) {
                convertCardToArray(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while reading card file.");
        }

    }

    public static void convertCardToArray(String cardInfo) {
        String[] cardInfoArray= cardInfo.split(",");
        if (cardInfoArray.length == 9) {
            AddCard.createMonsterCard(cardInfoArray); 
        }
        if (cardInfoArray[2].contains("spell")) {
            AddCard.createSpellCard(cardInfoArray);
        }
        if (cardInfoArray[2].contains("curse")) {
            AddCard.createCurseCard(cardInfoArray);
        }
    }
}