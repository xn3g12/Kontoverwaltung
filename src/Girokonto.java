public class Girokonto extends Kontoklasse {
    public Girokonto(String kontoinhaber, double startbetrag) {
        super(kontoinhaber, startbetrag);
    }

    @Override
    public void kontoauszug() {
        super.kontoauszug();
        System.out.println("Girokonto-Details");
    }
}
