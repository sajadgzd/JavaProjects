
// Sajad Gholamzadehrizi

// Importing Necessary Libraries
import java.security.SecureRandom;
import java.util.Arrays;


public class Race {

    // Declaring variables
    public static String runway[] = new String[100];
    public static int R1;
    public static int R2;
    public static final SecureRandom randomNum = new SecureRandom();

    // Track Method
    public static void track(){


        //Fills array with 100 characters
        Arrays.fill(runway, " ");

        // If Racers are at lower than zero position, they will be set to zero.
        if (R1 <= 0) {
            R1 = 0;
        }
        if (R2 <= 0) {
            R2 = 0;
        }
        // Racers are named R1 and R2
        runway[R1] = "R1";
        runway[R2] = "R2";
        // If R1 and R2 are on the same square, as an example in the beginning of the race insert B
        if(R1 == R2){
                runway[R1] = "B";
        }

        // Printing Racer's Position
        for(String x: runway){
            System.out.print(x);
        }
    }

    // R1 Move Types method
    public static void R1_movement(){

        // generating random number between 1 to 10
        int rand = 1 + randomNum.nextInt(10);

        switch(rand){
            // In the Cases of 1 to 5 (Jump 50%): R1 is moving 3 squares forwards
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                R1 += 3;
                break;
            // Cases of 6 to 8 (Slip 30%): R1 is moving 6 squares backwards
            case 6:
            case 7:
            case 8:
                R1 -= 6;
                break;

            // Cases of 9 to 10 (Walk 20%): R1 is moving 1 square forwards
            case 9:
            case 10:
                ++R1;
        }
    }

    // R2 Move Types method
    public static void R2_movement(){

        // Makes sure the randomNum int generated is between 1-10
        int rand = 1 + randomNum.nextInt(10);

        switch(rand){
            // Case 1 (Sleep 10%): No move
            case 1:
                break;

            // Cases of 2 to 3(Jump 20%): R2 is moving 5 squares forwards
            case 2:
            case 3:
                R2 += 5;
                break;

            // Cases of 4 to 5 (Small Slip 20%): R2 is moving 2 squares backwards
            case 4:
            case 5:
                R2 -= 2;
                break;

            // Case 6 (Slip 10%): R2 is moving 10 squares backwards
            case 6:
                R2 -= 10;
                break;

            // Cases of 7 to 10 (Walk 40%): R2 is moving 1 square forwards
            case 7:
            case 8:
            case 9:
            case 10:
                ++R2;
                break;
        }
    }

    public static void main(String[] args) {

        // Initiates runway to start
        R1 = 0;
        R2 = 0;
        System.out.printf("%s%n","On Your Mark,Get Set,Go");

        //initiates time to 0
        int time = 0;

        // Iteration over the track runway, which runs over time
        while(R1 < 100 && R2 < 100){
            System.out.printf("%nTime: %d%n", time);

            track();
            R1_movement();
            R2_movement();

            System.out.println();

            // Runway squares
            for (int i = 1; i < 100; ++i){
                char dash = '-';
                System.out.printf("%s", dash);
            }
            // Incrementing time
            ++time;

        }
        System.out.println();

        // Results at the end of the race
        if(R1 == R2) {
            System.out.printf("%s%n", "IT's A TIE.");
        } else if(R1 >= 100) {
            System.out.printf("%s%n", "Runner 1 Wins.");
        } else if(R2 >= 100){
            System.out.printf("%s%n","Runner 2 Wins.");
        }
        System.out.printf("%s%d%s%n","Time Elapsed = ", time, " seconds");
    }
}
