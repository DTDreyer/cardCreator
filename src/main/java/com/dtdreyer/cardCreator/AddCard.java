package com.dtdreyer.cardCreator;

import org.json.JSONObject;

public class AddCard {
    
    /**
     * This method creates a monster card json object and adds it to the card library.
     * 
     * @param data the monster card data.
     * 
     * @return true if the card was added, false if it was not.
     * 
     * @author DTDreyer
     */
    public static boolean createMonsterCard(String[] data) {
        int id = JSONController.getLastAddedCardId();
        String idString = Integer.toString(id);
        
        // Get the card data from the string array.
        String name = data[0];

        if (JSONController.checkIfMonsterAlreadyExists(name)) {
            System.err.println("Monster card already exists.");
            return false;
        }

        String image = data[1];
        String attribute = data[2];
        String type = data[3];
        String archtype = data[4];
        String alignment1 = data[5];
        String alignment2 = data[6];
        String attack = data[7];
        String defence = data[8];

        JSONObject cardData = new JSONObject();

        // Add the card data to the card json object.
        cardData.put("name", name)
        .put("image", image)
        .put("attribute", attribute)
        .put("type", type)
        .put("archtype", archtype)
        .put("alignment1", alignment1)
        .put("alignment2", alignment2)
        .put("attack", attack)
        .put("defence", defence);

        // Add the monster card to the card library.
        JSONController.addMonsterCard(idString, cardData);
        JSONController.setLastAddedCardId();
        return true;
    }

    /**
     * This method creates a spell card json object and adds it to the card library.
     * 
     * @param data the spell card data.
     * 
     * @return true if the card was added, false if it was not.
     * 
     * @author DTDreyer
     */
    public static boolean createSpellCard(String[] data) {
        int id = JSONController.getLastAddedCardId();
        String idString = Integer.toString(id);

        // Get the card data from the string array.
        String name = data[0];

        if (JSONController.checkIfSpellAlreadyExists(name)) {
            System.err.println("Spell card already exists.");
            return false;
        }

        String image = data[1];
        String type = data[2];
        String effect = data[3];

        JSONObject cardData = new JSONObject();

        // Add the card data to the card json object.
        cardData.put("name", name)
        .put("image", image)
        .put("type", type)
        .put("effect", effect);


        // Add the spell card to the card library.
        JSONController.addSpellCard(idString, cardData);
        JSONController.setLastAddedCardId();
        return true;
    } 

    /**
     * This method creates a curse card json object and adds it to the card library.
     * 
     * @param data the curse card data.
     * 
     * @return true if the card was added, false if it was not.
     * 
     * @author DTDreyer
     */
    public static boolean createCurseCard(String[] data) {
        int id = JSONController.getLastAddedCardId();
        String idString = Integer.toString(id);

        // Get the card data from the string array.
        String name = data[0];

        if (JSONController.checkIfCurseAlreadyExists(name)) {
            System.err.println("Curse card already exists.");
            return false;
        }

        String image = data[1];
        String type = data[2];
        String effect = data[3];

        JSONObject cardData = new JSONObject();

        // Add the card data to the card json object.
        cardData.put("name", name)
        .put("image", image)
        .put("type", type)
        .put("effect", effect);

        // Add the curse card to the card library.
        JSONController.addCurseCard(idString, cardData);
        JSONController.setLastAddedCardId();
        return true;
    }

}
