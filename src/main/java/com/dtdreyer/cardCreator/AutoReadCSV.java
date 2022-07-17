package com.dtdreyer.cardCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AutoReadCSV {

    private static File cardFile = new File("cardcreater\\data\\cardList.csv");
    
    /**
     * This method reads the card list csv file and creates monster and spell cards.
     * 
     * @throws FileNotFoundException if the file is not found.
     *
     * @author DTDreyer
     */
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

    /**
     * This method converts a line of text from the card list csv file into a string array.
     * 
     * @param line the line of text from the card list csv file.
     * 
     * @return the string array.
     * 
     * @author DTDreyer
     */
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