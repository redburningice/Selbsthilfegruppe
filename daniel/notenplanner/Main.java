import java.util.Scanner;
import static java.lang.Thread.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
        Fächerzuweisung:
        1: AEuP     2: IT-Projekt     3: Englisch    4: PUG    5: Sport
         */
        Fach notelist = new Fach();
        boolean active = true;
        notelist.reading();
        int decision;

        while (active) {
            notelist.clean();
            System.out.println("[1] Note hinzufügen \n" +
                    "[2] Notenschnitt ausgeben \n" +
                    "[3] Alle Noten ausgeben \n" +
                    "[4] Beenden");
            decision = notelist.decision();

            switch (decision) {
                case 1:
                    notelist.clean();
                    System.out.println("Fach angeben:\n" +
                            "[1] AEuP\n" +
                            "[2] IT-Projekt\n" +
                            "[3] Englisch\n" +
                            "[4] PUG\n" +
                            "[5] Sport");
                    int fach = notelist.decision();
                    notelist.clean();
                    System.out.println("Typ angeben:\n" +
                            "[1] Mündlich\n" +
                            "[2] Schriftlich");
                    int typ = notelist.decision();
                    notelist.clean();
                    System.out.println("Note angeben:");

                    int note = notelist.decision();
                    notelist.gradeAdd(fach, note);
                    if (typ == 2)
                        notelist.gradeAdd(fach, note);
                    System.out.println("Note gespeichert!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    notelist.clean();
                    break;
                case 2:
                    notelist.clean();
                    notelist.calc();
                    for (int i = 0; i < 5; i++)
                        System.out.println(" ");
                    System.out.println("[1] Hauptmenü\n" +
                            "[2] Beenden");
                    if (notelist.decision() == 1)
                        notelist.clean();
                    else {
                        notelist.save();
                        active = false;
                    }
                    break;
                case 3:
                    notelist.clean();
                    notelist.showGrades();
                    for (int i = 0; i < 5; i++)
                        System.out.println(" ");
                    System.out.println("[1] Hauptmenü");
                    System.out.println("[2] Beenden");
                    if (scan.nextInt() == 1)
                        notelist.clean();
                    else {
                        notelist.save();
                        active = false;
                    }
                    break;
                case 4:
                    notelist.save();
                    active = false;
                    notelist.clean();
                    System.out.println("Beendet");
                    break;
                default:
                    notelist.clean();
                    System.out.println("Bitte zutreffende Nummer eingeben!");
            }

        }
    }
}


