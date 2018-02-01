import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;



public class Main {




    public static int start() {
        int userChoice;
        int dexLength;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your new PokeDex!");
        System.out.println("How many Pokemon are in your region :");
        System.out.println();
        while (true) { // checking for non integer input
            try {
                dexLength = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("That is not a valid choice. Try again.");
            }
        }

        System.out.println("Your new Pokedex can hold " + dexLength + " " +
                "Pokemon.  Let’s start using it!");
        System.out.println();

        return dexLength;
}

public static int getMenu() {
    int userChoice;
    Scanner scnr = new Scanner(System.in);

    System.out.println("1. List Pokemon");
    System.out.println("2. Add Pokemon");
    System.out.println("3. Check a Pokemon’s Stats");
    System.out.println("4. Evolve Pokemon");
    System.out.println("5. Sort Pokemon");
    System.out.println("6. Exit");
    System.out.println();
    System.out.println("What would you like to do?");

   while (true) { // checking for non integer input
        try {
            userChoice = scnr.nextInt();
            break;
        } catch (InputMismatchException e) {
            scnr.nextLine();
            System.out.println("That is not a valid choice. Try again.");
        }
    }

    while ((userChoice < 0) || (userChoice > 6)) { // checking for out of bounds input
        System.out.println("That is not a valid choice. Try again.");
        scnr.nextLine();
        while (true) { // checking yet again for non int input
            try {
                userChoice = scnr.nextInt();
                break;
            } catch (InputMismatchException e) {
                scnr.nextLine();
                System.out.println("That is not a valid choice. Try again.");
            }
        }
    }
    return userChoice;
}
public static void main(String[] args){
    Pokedex pokedex;


        int userChoice;
        int dexLength;


        dexLength = start();

    pokedex = new Pokedex(dexLength);
        userChoice = getMenu();

    Scanner poke = new Scanner(System.in);

    while (userChoice!= 6) {
        if (userChoice == 1) {
            pokedex.listPokemon();
        }
        if (userChoice == 2) {
            System.out.println("Please enter the Pokemon's Species: ");
            String species = poke.nextLine();
            species =  species.toUpperCase();
            pokedex.addPokemon(species);


        }
        if (userChoice == 3){
            System.out.println("Please enter the Pokemon of interest: ");
            String species = poke.nextLine();
            species =  species.toUpperCase();
            int[] stats = pokedex.checkStats(species);
            System.out.println("Attack: " + stats[0]);
            System.out.println("Defense: " + stats[1]);
            System.out.println("Speed: " + stats[2]);

        }
        if (userChoice == 4) {
            System.out.println("Please enter the Pokemon of interest: ");
            String species = poke.nextLine();
            species =  species.toUpperCase();
            pokedex.evolvePokemon(species);
            System.out.println(species + " has evolved!");
        }
        if (userChoice == 5) {
            pokedex.sortPokedex();
        }
       userChoice = getMenu();
    }

}
}


