package com.dtdreyer.cardcreater;

import java.io.*;
import java.util.Scanner;

import org.json.JSONObject;

public class JSONController {
    private static File cardLibFile = new File("cardcreater\\data\\cardLib.json");

    /**
     * This method creates the card library file if it does not exist.
     *
     * @return true if the file was created, false if it already exists.
     *
     * @throws IOException if the file could not be created.
     *
     * @author dtdreyer
     */
    public static void createCardLib() {
        try {
            if (!cardLibFile.exists()) {
                cardLibFile.createNewFile();
                initCardLib();
            } else {
                if (checkIfEmpty()){
                    initCardLib();
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while creating card library file.");
        }
    }

    /**
     * This method initializes the card library file with the default values.
     *
     * @throws IOException if the file could not be created.
     * 
     * @author dtdreyer
     */
    private static void initCardLib() {
        // Create the JSON objects.
        JSONObject monsters = new JSONObject();
        JSONObject spells = new JSONObject();
        JSONObject curses = new JSONObject();
        JSONObject metaData = new JSONObject();

        metaData.put("lastAddedCardId", 0);

        JSONObject cardLib = (new JSONObject()).put("metaData", metaData).put("monsters", monsters).put("spells", spells).put("curses", curses);
        // new file writer for initializing the card library
        try (FileWriter file = new FileWriter(cardLibFile)) {
            file.write(cardLib.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while initializing card library file.");
        }
    }

    /** 
     * This method checks if the card library is empty.
     * 
     * @throws SecurityException if file has been maliciousy modified.
     * 
     * @return true if the card library is empty, false otherwise.
     * 
     * @author dtdreyer
     */
    private static boolean checkIfEmpty() {
        try {
            if (cardLibFile.length() == 0) {
                initCardLib();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** 
     * This method is used to add a monster card to the card library.
     * 
     * @param newMonsterCard The monster card to be added to the card library.
     * 
     * @author dtdreyer
     */
    public static void addMonsterCard(String id, JSONObject newMonsterCard) {
        JSONObject cardLib = getCardLib();

        JSONObject monsters = cardLib.getJSONObject("monsters");
        monsters.put(id, newMonsterCard);
        cardLib.put("monsters", monsters);
        setCardLib(cardLib);
        System.out.println(newMonsterCard.getString("name") + " has been added to the card library.");
    }

    /** 
     * This method is used to add a spell card to the card library.
     * 
     * @param newSpellCard The spell card to be added to the card library.
     * 
     * @author dtdreyer
     */
    public static void addSpellCard(String id, JSONObject newSpellCard) {
        JSONObject cardLib = getCardLib();
            JSONObject spells = cardLib.getJSONObject("spells");
            spells.put(id, newSpellCard);
            cardLib.put("spells", spells);
            setCardLib(cardLib);
            System.out.println(newSpellCard.getString("name") + " has been added to the card library.");
    }

    /** 
     * This method is used to add a curse card to the card library.
     * 
     * @param newCurseCard The curse card to be added to the card library.
     * 
     * @author dtdreyer
     */
    public static void addCurseCard(String id, JSONObject newCurseCard) {
        JSONObject cardLib = getCardLib();
        JSONObject curses = cardLib.getJSONObject("curses");
        curses.put(id, newCurseCard);
        cardLib.put("curses", curses);
        setCardLib(cardLib);
        System.out.println(newCurseCard.getString("name") + " has been added to the card library.");
    }

    /** 
     * This method is used to get the data from the card library file.
     * 
     * @return JSONObject - the data from the card library file.
     * 
     * @author dtdreyer
     *
     */
    public static JSONObject getCardLib() {
        String data = "";
        try {
            // Create scanner to read cardlib.json and create a string of all existing lines.
            Scanner scanner = new Scanner(cardLibFile);
            while (scanner.hasNextLine()) {
                data += scanner.nextLine();
            }
            scanner.close();
            // Convert string to JSONObject.
            JSONObject cardLib = new JSONObject(data);
            return cardLib;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while reading card library file.");
            return null;
        }
    }

    /**
     * This method is used to set the data in the card library file.
     * 
     * @param cardLib The data to be set in the card library file.
     * 
     * @author dtdreyer
     */
    public static void setCardLib(JSONObject newCardLib) {
        try {
            // Create file writer to write newCardLib to cardlib.json.
            FileWriter file = new FileWriter(cardLibFile);
            file.write(newCardLib.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while writing to card library file.");
        }
    }

    public static int getLastAddedCardId() {
        JSONObject cardLib = getCardLib();
        JSONObject metaData = cardLib.getJSONObject("metaData");
        int lastAddedCardId = metaData.getInt("lastAddedCardId");
        return lastAddedCardId;
    }

    public static void setLastAddedCardId() {
        JSONObject cardLib = getCardLib();
        JSONObject metaData = cardLib.getJSONObject("metaData");
        int lastAddedCardId = metaData.getInt("lastAddedCardId") + 1;
        metaData.put("lastAddedCardId", lastAddedCardId);
        cardLib.put("metaData", metaData);
        try {
            FileWriter writer = new FileWriter(cardLibFile);
            writer.write(cardLib.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while writing to card library file.");
        }
    }

    public static JSONObject getCardById(String id) {
        // Searchs the card libary for the card with the given id.
        JSONObject cardLib = getCardLib();
        JSONObject monsters = cardLib.getJSONObject("monsters");
        JSONObject spells = cardLib.getJSONObject("spells");
        JSONObject curses = cardLib.getJSONObject("curses");

        if (monsters.has(id)) {
            return monsters.getJSONObject(id);
        }
        if (spells.has(id)) {
            return spells.getJSONObject(id);
        }
        if (curses.has(id)) {
            return curses.getJSONObject(id);
        }


        System.out.println("Card with id " + id + " not found.");
        return null;
    }

    public static boolean checkIfMonsterAlreadyExists(String newName) {
        JSONObject cardLib = getCardLib();
        JSONObject monsters = cardLib.getJSONObject("monsters");
        int totalMonsters = monsters.length() - 1;
        for (int i = 0; i <= totalMonsters; i++) {
            // Convert i to string.
            String id= Integer.toString(i);
            JSONObject monster = monsters.getJSONObject(id);
            if (monster.getString("name").equals(newName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkIfSpellAlreadyExists(String newName) {
        JSONObject cardLib = getCardLib();
        JSONObject spells = cardLib.getJSONObject("spells");
        int totalSpells = spells.length() - 1;
        for (int i = 0; i <= totalSpells; i++) {
            // Convert i to string.
            String id= Integer.toString(i);
            JSONObject spell = spells.getJSONObject(id);
            if (spell.getString("name").equals(newName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfCurseAlreadyExists(String newName) {
        JSONObject cardLib = getCardLib();
        JSONObject curses = cardLib.getJSONObject("curses");
        int totalCurses = curses.length() - 1;
        for (int i = 0; i <= totalCurses; i++) {
            // Convert i to string.
            String id= Integer.toString(i);
            JSONObject curse = curses.getJSONObject(id);
            if (curse.getString("name").equals(newName)) {
                return true;
            }
        }
        return false;
    }

}
