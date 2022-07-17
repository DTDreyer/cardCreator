package com.dtdreyer.cardcreater;

import org.json.JSONObject;

public class ViewCard {
    
    /**
     * This method prints the monster JSONObject to the console.
     * 
     * @param monsterCard the monster JSONObject to be printed.
     */
    public static void viewMonsterCard(JSONObject monster) {
        System.out.println("----------------------------------------------------");
        System.out.println("Monster Card:");
        System.out.println("");

        String headerLeft = monster.getString("name");
        String headerRight = monster.getString("attribute");
        String upperBodyLeft = monster.getString("type");
        String upperBodyRight = monster.getString("alignment1");
        String lowerBodyLeft = monster.getString("archtype");
        String lowerBodyRight = monster.getString("alignment2");
        String footerLeft = monster.getString("attack");
        String footerRight = monster.getString("defence");

        String header = headerLeft + "\t\t" + headerRight;
        String upperBody = upperBodyLeft + "\t\t\t" + upperBodyRight;
        String lowerBody = lowerBodyLeft + "\t\t\t" + lowerBodyRight;
        String footer = footerLeft + "\t\t\t" + footerRight;

        System.out.println(header);
        System.out.println(upperBody);
        System.out.println(lowerBody); 
        System.out.println(footer);
    }

    /**
     * This method prints the spell JSONObject to the console.
     * 
     * @param spellCard the spell JSONObject to be printed.
     */
    public static void viewSpellAndCurseCard(JSONObject spell) {
        System.out.println("Spell Card:");
        System.out.println("");
        String headerLeft = spell.getString("name");
        String headerRight = spell.getString("type");
        String body = spell.getString("effect");

        String header = headerLeft + "\t\t\t" + headerRight;

        System.out.println(header);
        System.out.println(body);

    }
}
