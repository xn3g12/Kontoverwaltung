abstract class Kontoklasse {
    private static int kontonummerCounter = 1;
    private int kontonummer;
    private String kontoinhaber;
    private double kontostand;

    public Kontoklasse(String kontoinhaber, double startbetrag) {
        this.kontonummer = kontonummerCounter++;
        this.kontoinhaber = kontoinhaber;
        this.kontostand = startbetrag;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println("Betrag eingezahlt: " + betrag);
        } else {
            System.out.println("Ungültiger Betrag.");
        }
    }

    public void abheben(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println("Betrag abgehoben: " + betrag);
        } else {
            System.out.println("Ungültiger Betrag oder unzureichendes Guthaben.");
        }
    }

    public void kontoauszug() {
        System.out.println("Kontoauszug für " + kontoinhaber + " (Konto-Nr: " + kontonummer + "):");
        System.out.println("Kontostand: " + kontostand);
    }
}
