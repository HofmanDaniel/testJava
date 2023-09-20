public class NonAlimentare extends Prodotto {
    String materiale;
    public NonAlimentare(String descrizione, double prezzoUnit, int nProdotti, String materiale) {
        super(descrizione, prezzoUnit, nProdotti);
        this.materiale = materiale;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    @Override
    public double getPrezzo(boolean carta) {
        if (((materiale.equals("carta") || materiale.equals("vetro") || materiale.equals("plastica")) && carta)) {
            return (prezzoUnit - (prezzoUnit * 10 / 100))*nProdotti;
        }
        return prezzoUnit*nProdotti;
    }
    /*
     * sconto del 10% se il prodotto è composto da un materiale riciclabile (carta,
     * vetro o plastica)
     */

    @Override
    public String toString() {
        return super.toString()+", materiale=" + materiale+"]";
    }

     
}
