public abstract class Prodotto {
    int codice;
    String descrizione;
    double prezzoUnit;
    int nProdotti;
    static int _codice = 0;

    public Prodotto(String descrizione, double prezzoUnit, int nProdotti) {
        this.codice = _codice++;
        this.descrizione = descrizione;
        this.prezzoUnit = prezzoUnit;
        this.nProdotti = nProdotti;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzoUnit() {
        return prezzoUnit;
    }

    public void setPrezzoUnit(double prezzoUnit) {
        this.prezzoUnit = prezzoUnit;
    }

    public int getnProdotti() {
        return nProdotti;
    }

    public void setnProdotti(int nProdotti) {
        this.nProdotti = nProdotti;
    }

    public abstract double getPrezzo(boolean carta);

    @Override
    public String toString() {
        return "[codice=" + codice + ", descrizione=" + descrizione + ", prezzoUnit=" + prezzoUnit+ ", nProdotti=" + nProdotti;
    }

}
