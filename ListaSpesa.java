import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ListaSpesa {
    private ArrayList<Prodotto> lista;

    public ListaSpesa() {
        lista = new ArrayList<>();
    }

    public void add(Prodotto p) {
        lista.add(p);
    }

    public String getScontrino(boolean carta) {
        double totaleSenzaSconto = 0;
        double totaleConSconto = 0;
        for (Prodotto p : lista) {
            totaleSenzaSconto += p.getPrezzo(false);
            totaleConSconto += p.getPrezzo(carta);
        }

        return String.format("Hai pagato %.2f risparmiando %.2f", totaleConSconto,
                (totaleSenzaSconto - totaleConSconto));
    }

    public String getInScadenza() {
        String risFrigo = "";
        String risFuoriFrigo = "";
        for (Prodotto p : lista) {
            if (p instanceof Alimentare && ((Alimentare) p).isConservareInFrigo() && ChronoUnit.DAYS.between(LocalDate.now(), ((Alimentare)p).getScadenza()) < 10) {
                risFrigo += p + "\n";
            } else if (p instanceof Alimentare && ChronoUnit.DAYS.between(LocalDate.now(), ((Alimentare)p).getScadenza()) < 10) {
                risFuoriFrigo += p + "\n";
            }
        }
        return "Da Frigo:\n"+risFrigo +"Fuori Frigo:\n"+risFuoriFrigo;
    }

    public ArrayList<Prodotto> getNonRiciclabili(){
        ArrayList<Prodotto> ris=new ArrayList<>();
        for (Prodotto p : lista) {
            if(p instanceof NonAlimentare && !(((NonAlimentare)p).getMateriale().equals("carta") || ((NonAlimentare)p).getMateriale().equals("vetro") || ((NonAlimentare)p).getMateriale().equals("plastica"))){
                ris.add(p);
            }
        }
        return ris;
    }

    public ArrayList<Prodotto> getProdottiItaliani(){
        ArrayList<Prodotto> ris=new ArrayList<>();
        for (Prodotto p : lista) {
            if(p instanceof Alimentare && ((Alimentare) p).getOrigine().equals("Italia")){
                ris.add(p);
            }
        }
        return ris;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
