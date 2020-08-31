package marcopolo;

import java.util.Random;
import java.util.Scanner;
import static marcopolo.MarcoPolo.poloDirection;

public class MarcoPolo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("How big is the pool you would like? ");
        int size = s.nextInt();
        s.nextLine();

        Random r = new Random();

        int marcoX = r.nextInt(size) + 1;
        int marcoY = r.nextInt(size) + 1;

        int poloX, poloY;

        do {
            poloX = r.nextInt(size) + 1;
            poloY = r.nextInt(size) + 1;
        } while (marcoX == poloX && marcoY == poloY);

        while (!(marcoX == poloX && marcoY == poloY)) {
            System.out.printf("You are at (%d, %d).\n", marcoX, marcoY);

            System.out.print("What would you like to do? ");
            String command = s.nextLine();

            switch (command.toLowerCase()) {
                case "move north":
                case "move up":
                    if (marcoY > 1)
                        marcoY--;
                    else
                        System.out.println("Ouch! You ran into the edge of the pool!");
                    break;
                case "move south":
                case "move down":
                    marcoY++;
                    break;
                case "move east":
                case "move right":
                    marcoX++;
                    break;
                case "move west":
                case "move left":
                    marcoX--;
                    break;
                case "shout marco":
                    poloDirection(marcoX, marcoY, poloX, poloY);
                    break;
            }
        }
        System.out.println("You found Polo! Congratulations");
        System.out.println("Polo was located at ("+poloX+", "+poloY+")!");

    }

    public static void poloDirection(int marcoX, int marcoY, int poloX, int poloY) {
        int y = poloY - marcoY;
        int x = poloX - marcoX;
        double angle = Math.atan2(y, x);
        double eigthPi = Math.PI / 8;

        if (angle < - 7 * eigthPi) {
            System.out.println("You hear 'polo' from the West.");
        } else if (angle < -5 * eigthPi) {
            System.out.println("You hear 'polo' from the Northwest.");
        } else if (angle < - 3 * eigthPi) {
            System.out.println("You hear 'polo' from the North.");
        } else if (angle < -1 * eigthPi) {
            System.out.println("You hear 'polo' from the Northeast.");
        } else if (angle < 1 * eigthPi) {
            System.out.println("You hear 'polo' from the East.");
        } else if (angle < 3 * eigthPi) {
            System.out.println("You hear 'polo' from the Southeast.");
        } else if (angle < 5 * eigthPi) {
            System.out.println("You hear 'polo' from the South.");
        } else if (angle < 7 * eigthPi) {
            System.out.println("You hear 'polo' from the Southwest.");
        } else {
            System.out.println("You hear 'polo' from the West.");
        }
    }

}
