import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Das ist ein Testkommentar

        //Aufgabe 1
        System.out.println("Daniel Stamatakis");

        //Aufgabe 2
        int meinAlter = 25;
        System.out.println(meinAlter);

        //Aufgabe 3
        Random random = new Random();
        int number = random.nextInt(21) + 10;
        System.out.println(number);
        if (number > 20)
            System.out.println("Die Zahl ist größer als 20");
        else
            System.out.println("Die Zahl ist kleiner als 20");

        //Aufgabe 4
        int dice = random.nextInt(6) + 1;
        if (dice == 3)
            System.out.println("Gewonnen! Du hast eine 3 gewürfelt!");
        else if (dice > 3)
            System.out.println("Du hast eine " + dice + " gewürfelt und darfst es noch einmal versuchen.");
        else
            System.out.println("Leider verloren, du hast eine " + dice + " gewürfelt.");

        //Aufgabe 5
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            int numbers = random.nextInt(6) + 1;
            if (numbers == 6)
                counter += 1;
        }
        System.out.println(counter);

        //Aufgabe 6
        int tries = 0;
        int newnumber = 0;
        while (newnumber != 6) {
            newnumber = random.nextInt(6) + 1;
            tries += 1;
        }
        System.out.println("Es wurden " + tries + " Versuche benötigt!");

        //Aufgabe 7
        tries = 0;
        do {
            newnumber = random.nextInt(6) + 1;
            tries += 1;
        }
        while (newnumber != 6);
        System.out.println("Es wurden " + tries + " Versuche benötigt!");

        //Aufgabe 8
        tries = 0;
        while(true){
            newnumber = random.nextInt(6)+1;
            if(newnumber != 6)
                tries += 1;
            else
                break;
            }
        System.out.println("Es wurden " + tries + " Versuche benötigt!");

    }
}
