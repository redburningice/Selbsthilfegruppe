import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fach {
    public int[][] grades = new int[5][15];
    Scanner scan = new Scanner(System.in);

    public void reading() {
        File datei = new File("notes.txt");
        Scanner scanData = null;
        try {
            scanData = new Scanner(datei);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        try {
            String data = scanData.nextLine();
            int counter = 0;
            for (int i = 0; i < grades.length; i++) {
                for (int y = 0; y < grades[i].length; y++) {
                    grades[i][y] = Integer.parseInt(String.valueOf(data.charAt(counter)));
                    counter++;
                }
            }
        } catch (NoSuchElementException e) {
            for (int i = 0; i < grades.length; i++)
                for (int y = 0; y < grades[i].length; y++)
                    grades[i][y] = 0;
        }
    }

    public void save() {
        File datei = new File("notes.txt");
        try {
            FileWriter writer = new FileWriter(datei);
            for (int i = 0; i < grades.length; i++) {
                for (int y = 0; y < grades[i].length; y++) {
                    writer.write(String.valueOf(grades[i][y]));
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Speichern fehlgeschlagen");
        }
    }

    //cleaning Window
    public void clean() {
        for (int i = 0; i < 10; i++)
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public int decision() {
        int i = 0;
        try {
            i = scan.nextInt();
            return i;
        } catch (InputMismatchException e) {
            System.out.println("Bitte zutreffende Ziffer eingeben!");
            return i;
        }
    }


    //Adding grades in Array. One column per subject
    public void gradeAdd(int subject, int grade) {
        boolean saved = false;

        switch (subject) {
            //AEuP
            case 1:
                for (int i = 0; i < grades[0].length; i++)
                    if (!saved && grades[0][i] == 0) {
                        grades[0][i] = grade;
                        saved = true;
                    }
                break;


            //IT-Projekt
            case 2:
                for (int i = 0; i < grades[1].length; i++) {
                    if (!saved && grades[1][i] == 0) {
                        grades[1][i] = grade;
                        saved = true;
                    }
                }
                break;

            //Englisch
            case 3:
                for (int i = 0; i < grades[2].length; i++) {
                    if (!saved && grades[2][i] == 0) {
                        grades[2][i] = grade;
                        saved = true;
                    }
                }
                break;

            //PUG
            case 4:
                for (int i = 0; i < grades[3].length; i++) {
                    if (!saved && grades[3][i] == 0) {
                        grades[3][i] = grade;
                        saved = true;
                    }
                }
                break;

            //Sport
            case 5:
                for (int i = 0; i < grades[4].length; i++) {
                    if (!saved && grades[4][i] == 0) {
                        grades[4][i] = grade;
                        saved = true;
                    }
                }
                break;
        }
    }


    //Calculating grade point average
    public void calc() {
        DecimalFormat df = new DecimalFormat("#.##");
        int sub = 1;
        double count;
        double mid;

        for (int i = 0; i < grades.length; i++) {
            count = 0;
            mid = 0;
            switch (sub) {
                case 1:
                    System.out.println("\n AEuP:");
                    break;
                case 2:
                    System.out.println("\n IT-Projekt:");
                    break;
                case 3:
                    System.out.println("\n Englisch:");
                    break;
                case 4:
                    System.out.println("\n PUG:");
                    break;
                case 5:
                    System.out.println("\n Sport:");
                    break;
            }

            sub += 1;
            for (int j = 0; j < grades[i].length; j++) {
                if (grades[i][j] != 0) {
                    mid += grades[i][j];
                    count += 1;
                }
            }
            if (count != 0) {
                double result = mid / count;
                System.out.println(df.format(result));
            }
        }
    }

    //shows all grades
    public void showGrades() {
        int sub = 1;
        for (int i = 0; i < grades.length; i++) {
            switch (sub) {
                case 1:
                    System.out.println("\n AEuP:");
                    break;
                case 2:
                    System.out.println("\n IT-Projekt:");
                    break;
                case 3:
                    System.out.println("\n Englisch:");
                    break;
                case 4:
                    System.out.println("\n PUG:");
                    break;
                case 5:
                    System.out.println("\n Sport:");
                    break;
            }
            sub += 1;
            for (int j = 0; j < grades[i].length; j++) {
                if (grades[i][j] != 0) {
                    System.out.println(grades[i][j]);
                }
            }
        }
    }
}
