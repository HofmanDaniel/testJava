import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alimentare extends Prodotto {
    LocalDate scadenza;
    boolean conservareInFrigo;
    String origine;

    public Alimentare(String descrizione, double prezzoUnit, int nProdotti, LocalDate scadenza,
            boolean conservareInFrigo, String origine) {
        super(descrizione, prezzoUnit, nProdotti);
        this.scadenza = scadenza;
        this.conservareInFrigo = conservareInFrigo;
        this.origine = origine;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public boolean isConservareInFrigo() {
        return conservareInFrigo;
    }

    public void setConservareInFrigo(boolean conservareInFrigo) {
        this.conservareInFrigo = conservareInFrigo;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public double getPrezzo(boolean carta) {
        if (carta){
            if (ChronoUnit.DAYS.between(LocalDate.now(), scadenza) < 10 && conservareInFrigo) {
                return (prezzoUnit - (prezzoUnit * 20 / 100))*nProdotti;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), scadenza) < 10)
                return (prezzoUnit - (prezzoUnit * 15 / 100))*nProdotti;
        }
        return prezzoUnit*nProdotti;
    }
    /*
     * del 20% se la data di scadenza è a meno di 10 giorni dalla data attuale e il
     * prodotto è da frigo
     * del 15% non da frigo sempre con scadenza minore 10 giorni
     */

    @Override
    public String toString() {
        return super.toString()+", scadenza=" + scadenza + ", conservareInFrigo=" + conservareInFrigo + ", origine=" + origine+"]";
    }

     
}
