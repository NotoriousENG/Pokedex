import java.util.Arrays;
import java.util.Collections;

public class Pokedex {

    private Pokemon[] pokemon;

    public Pokedex(int dexLength) {
        pokemon = new Pokemon[dexLength];
    }

    /*
* Return all the names of the Pokemon species in the
* Pokedex
*/
    public String[] listPokemon() {
        String[] list = new String[pokemon.length];

        for (int p = 0; p < pokemon.length; p++) {
            if (pokemon[p] == null) {
                break;
            }
            list[p] = pokemon[p].getSpecies();
            System.out.println((p + 1) + ": " + list[p]);

        }
        return list;
    }

    /*
    * Add a Pokemon to the Pokedex and return true if it can
    * actually be added to the Pokedex. If not, return false.
    */
    public boolean addPokemon(String species) {

        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] == null) {
                pokemon[i] = new Pokemon(species);
                System.out.println(Arrays.toString(pokemon));
                return true;
            }

            if ((pokemon[i].getSpecies().equals(species))) {
                System.out.println("Duplicate");
                return false;
            }
            if (i == pokemon.length - 1) {
                System.out.println("Max");
                return false;
            }
        }
    return false;
    }

    /*
     * Return the stats of a certain Pokemon that you are
    * searching for.
    */
    public int[] checkStats(String species) {
        System.out.println(Arrays.toString(pokemon));
        for (int i = 0; i < pokemon.length; i++) {
            System.out.println(pokemon[i].getSpecies());
            if (pokemon[i] == null) {
                System.out.println("ONE");
                return null;
            } else if (species.equals(pokemon[i].getSpecies())) {
                int stats[] = new int[3];
                stats[0] = pokemon[i].getAttack();
                stats[1] = pokemon[i].getDefense();
                stats[2] = pokemon[i].getSpeed();
                System.out.println("TWO");
                return stats;

            }
        }
        System.out.println("THREE");
        return null;

    }

    /*
    * Sort Pokedex in lexical order according to Java string ordering.
    */
    public void sortPokedex() {
        if (pokemon[0]== null){
            return;
        }
        for (int k = 1; k < pokemon.length; k++) {
            if (pokemon[k]== null){
                return;
            }
            for (int l = k; l >= 1; l--) {
                if (pokemon[l].getSpecies().compareToIgnoreCase(pokemon[l - 1].getSpecies()) > 0) {
                    Pokemon temp = pokemon[l];
                    pokemon[l] = pokemon[l - 1];
                    pokemon[l - 1] = temp;
                }
            }
        }
    }




    /*
    * Evolve a certain Pokemon that you are searching for in the
    * Pokedex and return true if the Pokemon is actually in the
    * the Pokedex. If not, return false.
     */
    public boolean evolvePokemon(String species) {

        for (int j = 0; j < pokemon.length; j++) {
            if (pokemon[j] == null) {
                return false;
            } else if (species.equals(pokemon[j].getSpecies())) {
                pokemon[j].evolve();
                return true;
            }
        }
        return false;
    }
}
