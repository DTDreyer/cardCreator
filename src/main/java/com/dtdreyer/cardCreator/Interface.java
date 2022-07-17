package com.dtdreyer.cardcreater;

import java.util.Scanner;

import org.json.JSONObject;

public class Interface {


    public static void mainMenu() {
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("Welcome to the card creator!");
            System.out.println("Please select an option:");
            System.out.println("1. Create a new card");
            System.out.println("2. View all cards");
            System.out.println("3. Convert CVS file to card library");
            System.out.println("b. Exit");
            System.out.println(" ");
            System.out.println("Enter your selection: ");

            String input = getUserInput();
            if (input.equals("1")) {
                createCard();
            }
            if (input.equals("2")) {
                viewCards();
            }
            if (input.equals("3")) {
                AutoReadCSV.readFileAndAddCards();
                continue;
            }
            if (input.equals("b")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

    }

    private static void createCard(){
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("What kind of card would you like to create?");
            System.out.println("1. Monster");
            System.out.println("2. Spell");
            System.out.println("3. Curse");
            System.out.println("b. Back");
            System.out.println(" ");
            System.out.println("Enter your selection: ");
            String input = getUserInput();
            if (input.equals("1")) {
                createMonster();
            }
            if (input.equals("2")) {
                createSpellOrCurse("spell");
            }
            if (input.equals("3")) {
                createSpellOrCurse("curse");
            } 
            if (input.equals("b")) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        mainMenu();
    }

    private static void createMonster() {
        String input = "";
        System.out.println("----------------------------------------------------");
        System.out.println("Monster creation menu:");
        System.out.println(" ");

        // Get name of monster from user.
        System.out.println("Name of the monster: ");
        String name = getUserInput();

        // Get image path from user.
        System.out.println("Image path of the monster: ");
        System.out.println("Path style: cardcreater\\data\\images\\name.png");
        String imagePath = getUserInput();

        // Get attribute of monster from user.
        System.out.println("Attribute of the monster: ");
        System.out.println("1. Fire");
        System.out.println("2. Water");
        System.out.println("3. Earth");
        System.out.println("4. Wind");
        System.out.println("5. Light");
        System.out.println("6. Dark");

        String attribute = "";
        while (attribute.equals("")) {
            input = getUserInput();
            if (input.equals("1")) {
                attribute = "fire";
            } else if (input.equals("2")) {
                attribute = "water";
            } else if (input.equals("3")) {
                attribute = "earth";
            } else if (input.equals("4")) {
                attribute = "wind";
            } else if (input.equals("5")) {
                attribute = "light";
            } else if (input.equals("6")) {
                attribute = "dark";
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        // Get type of monster from user.
        System.out.println("Type of the monster: ");
        System.out.println("1. Beast");
        System.out.println("2. Plant");
        System.out.println("3. Insect");
        System.out.println("4. Fish");
        System.out.println("5. Reptile");
        System.out.println("6. Machine");
        System.out.println("7. Beast-Warrrior");
        System.out.println("8. Rock");
        System.out.println("9. Dragon");
        System.out.println("10. Thunder");
        System.out.println("11. Dinosaur");
        System.out.println("12. Pyro");
        System.out.println("13. Aqua");
        System.out.println("14. Warrior");
        System.out.println("15. Winged-Beast");
        System.out.println("16. Sea Serpent");
        System.out.println("17. Fairy");
        System.out.println("18. Fiend");
        System.out.println("19. Zombie");
        System.out.println("20. Spellcaster");

        String type = "";
        while (type.equals("")) {
            input = getUserInput();
            if (input.equals("1")) {
                type = "beast";
            } else if (input.equals("2")) {
                type = "plant";
            } else if (input.equals("3")) {
                type = "insect";
            } else if (input.equals("4")) {
                type = "fish";
            } else if (input.equals("5")) {
                type = "reptile";
            } else if (input.equals("6")) {
                type = "machine";
            } else if (input.equals("7")) {
                type = "beast-warrior";
            } else if (input.equals("8")) {
                type = "rock";
            } else if (input.equals("9")) {
                type = "dragon";
            } else if (input.equals("10")) {
                type = "thunder";
            } else if (input.equals("11")) {
                type = "dinosaur";
            } else if (input.equals("12")) {
                type = "pyro";
            } else if (input.equals("13")) {
                type = "aqua";
            } else if (input.equals("14")) {
                type = "warrior";
            } else if (input.equals("15")) {
                type = "winged-beast";
            } else if (input.equals("16")) {
                type = "sea-serpent";
            } else if (input.equals("17")) {
                type = "fairy";
            } else if (input.equals("18")) {
                type = "fiend";
            } else if (input.equals("19")) {
                type = "zombie";
            } else if (input.equals("20")) {
                type = "spellcaster";
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        // Get archetype of monster from user.
        System.out.println("Archtype of the monster: ");
        System.out.println("1. Masculine");
        System.out.println("2. Feminine");
        System.out.println("3. Gem");
        System.out.println("4. None");

        String archtype = "placeholder";
        while (archtype.equals("placeholder")) {
            input = getUserInput();
            if (input.equals("1")) {
                archtype = "masculine";
            } else if (input.equals("2")) {
                archtype = "feminine";
            } else if (input.equals("3")) {
                archtype = "gem";
            } else if (input.equals("4")) {
                archtype = "";
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        // Get first alignment of monster from user.
        System.out.println("First alignment of the monster: ");
        System.out.println("1. Mind");
        System.out.println("2. Body");
        System.out.println("3. Purity");
        System.out.println("4. Corruption");
        System.out.println("5. Life");
        System.out.println("6. Death");
        System.out.println("7. Youth");
        System.out.println("8. Age");
        System.out.println("9. Eternity");
        System.out.println("10. void");
        String alignment1 = "";

        while (alignment1.equals("")) {
            input = getUserInput();
            if (input.equals("1")) {
                alignment1 = "mind";
            } else if (input.equals("2")) {
                alignment1 = "body";
            } else if (input.equals("3")) {
                alignment1 = "purity";
            } else if (input.equals("4")) {
                alignment1 = "corruption";
            } else if (input.equals("5")) {
                alignment1 = "life";
            } else if (input.equals("6")) {
                alignment1 = "death";
            } else if (input.equals("7")) {
                alignment1 = "youth";
            } else if (input.equals("8")) {
                alignment1 = "age";
            } else if (input.equals("9")) {
                alignment1 = "eternity";
            } else if (input.equals("10")) {
                alignment1 = "void";
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        // Get second alignment of monster from user.
        System.out.println("Second alignment of the monster: ");
        System.out.println("1. Mind");
        System.out.println("2. Body");
        System.out.println("3. Purity");
        System.out.println("4. Corruption");
        System.out.println("5. Life");
        System.out.println("6. Death");
        System.out.println("7. Youth");
        System.out.println("8. Age");
        System.out.println("9. Eternity");
        System.out.println("10. void");
        String alignment2 = "";
        while (alignment2.equals("")) {
        input = getUserInput();
            if (input.equals("1")) {
                alignment2 = "mind";
            } else if (input.equals("2")) {
                alignment2 = "body";
            } else if (input.equals("3")) {
                alignment2 = "purity";
            } else if (input.equals("4")) {
                alignment2 = "corruption";
            } else if (input.equals("5")) {
                alignment2 = "life";
            } else if (input.equals("6")) {
                alignment2 = "death";
            } else if (input.equals("7")) {
                alignment2 = "youth";
            } else if (input.equals("8")) {
                alignment2 = "age";
            } else if (input.equals("9")) {
                alignment2 = "eternity";
            } else if (input.equals("10")) {
                alignment2 = "void";
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        System.out.println("Attack of the monster: ");
        String attack = getUserInput();
        System.out.println("Defence of the monster: ");
        String defence = getUserInput();

        String[] data = {
            name,
            imagePath, 
            attribute, 
            type, 
            archtype, 
            alignment1, 
            alignment2, 
            attack, 
            defence
        };
        cardAddConfirmation("monster", data);
    }

    private static void createSpellOrCurse(String identifier) {
        System.out.println("----------------------------------------------------");
        System.out.println(identifier + " creation menu:");
        System.out.println(" ");

        // Get name of spell or curse from user.
        System.out.println("Name of the "+identifier+": ");
        String name = getUserInput();

        // Get image path of spell or curse from user.
        System.out.println(" ");
        System.out.println("Image path of the "+identifier+": ");
        String imagePath = getUserInput();

        // Get type of spell or curse from user.
        System.out.println(" ");
        System.out.println("Type of the "+identifier+": ");
        String type = getUserInput();

        // Get effect of spell or curse from user.
        System.out.println(" ");
        System.out.println("Effect of the "+identifier+": ");
        String effect = getUserInput();

        String[] data = {
            name,
            imagePath, 
            type, 
            effect, 
        };
        cardAddConfirmation(identifier, data);
    }

    private static void cardAddConfirmation(String cardType, String[] data) {

        System.out.println("Add "+cardType+" to library? (y/n)");
        String input = getUserInput();
        if (input.equals("y")) {
            if (cardType.equals("monster")) {
                AddCard.createMonsterCard(data);
            }
            if (cardType.equals("spell")) {
                AddCard.createSpellCard(data);
            }
            if (cardType.equals("curse")) {
                AddCard.createCurseCard(data);
            }
        }

        System.out.println("Create another card? (y/n)");
        input = getUserInput();
        if (input.equals("y")) {
            createCard();
        } else {
            mainMenu();
        }
    }

    private static void viewCards(){
        System.out.println("----------------------------------------------------");
        System.out.println("View cards menu:");
        System.out.println("b. Back");
        System.out.println(" ");
        System.out.println("Enter the id of the card you want to view: ");
        String input = getUserInput();
        if (input.equals("b")) {
            mainMenu();
        }
        String id = input;
        JSONObject card = JSONController.getCardById(id);
        if (card.has("attack")) {
            ViewCard.viewMonsterCard(card);
        }
        if (card.has("effect")) {
            ViewCard.viewSpellAndCurseCard(card);
        }
        System.out.println(" ");
        System.out.println("View another card? (y/n)");
        input = getUserInput();
        if (input.equals("y")) {
            viewCards();
        }
        mainMenu();
    }
    
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
