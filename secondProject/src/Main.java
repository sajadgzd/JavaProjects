// using java.security.SecureRandom
import java.security.SecureRandom;


public class Main {

    public static void nextRound(){
        System.out.printf("%s%n", "------------------------------------------------");
    }
    public static void main(String[] args) {

        System.out.printf("%s%n", "On Your Mark, Get Set, Go");
        RaceSimulation word = new RaceSimulation();

        System.out.printf("%s%n",word.toString());

        nextRound();




    }
}
