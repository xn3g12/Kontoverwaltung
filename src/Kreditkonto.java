public class Kreditkonto extends Kontoklasse {
    public Kreditkonto(String kontoinhaber, double startbetrag) {
        super(kontoinhaber, startbetrag);
    }

    @Override
    public void kontoauszug() {
        super.kontoauszug();
        System.out.println("Kreditkonto-Details");
    }
}
