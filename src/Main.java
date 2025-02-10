import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Kontoklasse> konten = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===============================");
            System.out.println("           BANK SYSTEM");
            System.out.println("===============================");
            System.out.println("Wähle eine Option:");
            System.out.println("1. Konto anlegen");
            System.out.println("2. Übersicht");
            System.out.println("3. Einzahlen");
            System.out.println("4. Abheben");
            System.out.println("5. Kontoauszug");
            System.out.println("0. Exit");
            System.out.print("Deine Wahl: ");

            switch (input.nextLine()) {
                case "1":
                    kontoAnlegen();
                    break;
                case "2":
                    kontoÜbersicht();
                    break;
                case "3":
                    einzahlen();
                    break;
                case "4":
                    abheben();
                    break;
                case "5":
                    kontoauszug();
                    break;
                case "0":
                    System.out.println("\nProgramm beendet. Auf Wiedersehen!");
                    return;
                default:
                    System.out.println("\nUngültige Eingabe, bitte wähle erneut!");
                    break;
            }
        }
    }

    private static void kontoAnlegen() {
        System.out.println("\n--- Konto anlegen ---");
        System.out.print("Gib den Kontoinhaber ein: ");
        String kontoinhaber = input.nextLine();

        System.out.print("Startbetrag eingeben: ");
        double startbetrag = Double.parseDouble(input.nextLine());

        System.out.println("\nWähle die Kontoart:");
        System.out.println("1. Girokonto");
        System.out.println("2. Sparkonto");
        System.out.println("3. Kreditkonto");
        System.out.print("Deine Wahl: ");
        int kontoart = Integer.parseInt(input.nextLine());

        switch (kontoart) {
            case 1:
                konten.add(new Girokonto(kontoinhaber, startbetrag));
                System.out.println("\nGirokonto erfolgreich angelegt!");
                break;
            case 2:
                konten.add(new Sparkonto(kontoinhaber, startbetrag));
                System.out.println("\nSparkonto erfolgreich angelegt!");
                break;
            case 3:
                konten.add(new Kreditkonto(kontoinhaber, startbetrag));
                System.out.println("\nKreditkonto erfolgreich angelegt!");
                break;
            default:
                System.out.println("\nUngültige Kontoart! Konto konnte nicht angelegt werden.");
                break;
        }
    }

    private static void kontoÜbersicht() {
        System.out.println("\n--- Kontoübersicht ---");
        if (konten.isEmpty()) {
            System.out.println("Es sind noch keine Konten vorhanden.");
        } else {
            for (Kontoklasse konto : konten) {
                konto.kontoauszug();
                System.out.println("-------------------------------------");
            }
        }
    }

    private static void einzahlen() {
        System.out.print("\nKontonummer eingeben: ");
        int kontonummer = Integer.parseInt(input.nextLine());

        Kontoklasse konto = findeKonto(kontonummer);
        if (konto != null) {
            System.out.print("Betrag zum Einzahlen: ");
            double betrag = Double.parseDouble(input.nextLine());
            konto.einzahlen(betrag);
        } else {
            System.out.println("Konto mit der Nummer " + kontonummer + " wurde nicht gefunden.");
        }
    }

    private static void abheben() {
        System.out.print("\nKontonummer eingeben: ");
        int kontonummer = Integer.parseInt(input.nextLine());

        Kontoklasse konto = findeKonto(kontonummer);
        if (konto != null) {
            System.out.print("Betrag zum Abheben: ");
            double betrag = Double.parseDouble(input.nextLine());
            konto.abheben(betrag);
        } else {
            System.out.println("Konto mit der Nummer " + kontonummer + " wurde nicht gefunden.");
        }
    }

    private static void kontoauszug() {
        System.out.print("\nKontonummer eingeben: ");
        int kontonummer = Integer.parseInt(input.nextLine());

        Kontoklasse konto = findeKonto(kontonummer);
        if (konto != null) {
            konto.kontoauszug();
        } else {
            System.out.println("Konto mit der Nummer " + kontonummer + " wurde nicht gefunden.");
        }
    }

    private static Kontoklasse findeKonto(int kontonummer) {
        for (Kontoklasse konto : konten) {
            if (konto.getKontonummer() == kontonummer) {
                return konto;
            }
        }
        return null;
    }
}
